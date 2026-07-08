package mx.uam.cua.nodo_b.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.uam.cua.nodo_b.messaging.FragmentPublisher;
import mx.uam.cua.nodo_b.model.FragmentInfo;

@Service
public class FragmentService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final FragmentPublisher publisher;

    public FragmentService(FragmentPublisher publisher) {
        this.publisher = publisher;
    }

    public String[] obtenerVideosNodo(String urlNodo) {
        return restTemplate.getForObject(
                urlNodo + "/videos",
                String[].class
        );
    }

    public void descargarFragmento(String urlNodo, String nombreArchivo, String nodoLocal) {

    try {

        ResponseEntity<Resource> response = restTemplate.getForEntity(
                urlNodo + "/videos/" + nombreArchivo,
                Resource.class
        );

        Resource resource = response.getBody();

        Path carpeta = Paths.get(nodoLocal, "videos");
        Files.createDirectories(carpeta);

        Path ruta = carpeta.resolve(nombreArchivo);

        System.out.println("Guardando en: " + ruta.toAbsolutePath());

        Files.copy(
                resource.getInputStream(),
                ruta,
                java.nio.file.StandardCopyOption.REPLACE_EXISTING
        );

        System.out.println("Archivo descargado: " + nombreArchivo);
        
        FragmentInfo info = new FragmentInfo(
            "nodo_b",
            nombreArchivo,
            1
        );

        restTemplate.postForObject(
            "http://localhost:8084/registry",
            info,
            String.class
        );

    } catch (Exception e) {
        System.out.println("Error descargando: " + nombreArchivo);
        e.printStackTrace();
    }
}
}