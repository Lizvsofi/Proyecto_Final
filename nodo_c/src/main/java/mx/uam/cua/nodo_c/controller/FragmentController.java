package mx.uam.cua.nodo_c.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/videos")
public class FragmentController {

    @GetMapping
    public List<String> listarVideos() {

        File carpeta = new File("nodo_c/videos");

        String[] archivos = carpeta.list((dir, nombre) ->
                nombre.endsWith(".mp4"));

        return Arrays.asList(archivos);
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Resource> descargarVideo(
            @PathVariable String nombre) throws IOException {

        Path ruta = Paths.get("nodo_c", "videos")
                .resolve(nombre);

        Resource resource = new UrlResource(ruta.toUri());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + nombre + "\"")
                .body(resource);
    }
}
