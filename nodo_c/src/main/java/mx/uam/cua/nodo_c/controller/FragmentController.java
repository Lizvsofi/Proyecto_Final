package mx.uam.cua.nodo_c.controller;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/videos")
public class FragmentController {

    @GetMapping
    public List<String> listarFragmentos(){
        File carpeta = new File("nodo_c/videos");
        String[] archivos = carpeta.list();

        if (archivos == null){
            return List.of();
        }

        return Arrays.asList(archivos);
    }
}
