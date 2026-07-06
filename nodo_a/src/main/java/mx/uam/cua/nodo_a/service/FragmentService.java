package mx.uam.cua.nodo_a.service;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FragmentService {

    private final RestTemplate restTemplate = new RestTemplate();

    // obtener lista de videos de otro nodo
    public String[] obtenerVideosNodo(String urlNodo) {
        return restTemplate.getForObject(
                urlNodo + "/videos",
                String[].class
        );
    }

    // DESCARGAR Y GUARDAR ARCHIVO
    public void descargarFragmento(String urlNodo, String nombreArchivo, String nodoLocal) {

        try {
            ResponseEntity<Resource> response = restTemplate.getForEntity(
                    urlNodo + "/videos/" + nombreArchivo,
                    Resource.class
            );

            Resource resource = response.getBody();

            Path ruta = Paths.get(nodoLocal, "videos", nombreArchivo);

            Files.copy(resource.getInputStream(), ruta);

            System.out.println("Archivo descargado: " + nombreArchivo);

        } catch (Exception e) {
            System.out.println("Error descargando: " + nombreArchivo);
            e.printStackTrace();
        }
    }
}