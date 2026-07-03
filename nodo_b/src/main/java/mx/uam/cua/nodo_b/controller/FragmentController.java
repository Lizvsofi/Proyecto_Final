package mx.uam.cua.nodo_b.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/videos")
public class FragmentController {

    @GetMapping
    public List<String> listarFragmentos(){
        File carpeta = new File("nodo_b/videos");
        String[] archivos = carpeta.list();

        if (archivos == null){
            return List.of();
        }

        return Arrays.asList(archivos);
    }
}