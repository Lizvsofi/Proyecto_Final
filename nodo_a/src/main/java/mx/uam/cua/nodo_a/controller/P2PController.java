package mx.uam.cua.nodo_a.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.uam.cua.nodo_a.service.FragmentService;

@RestController
@RequestMapping("/p2p")
public class P2PController {

    private final FragmentService fragmentService;

    public P2PController(FragmentService fragmentService) {
        this.fragmentService = fragmentService;
    }

    @GetMapping("/descargar")
    public String descargar() {

        fragmentService.descargarFragmento(
                "http://localhost:8082",   // nodo B
                "video_prueba03.mp4",      // archivo
                "nodo_a"                   // nodo actual
        );

        return "Descarga iniciada";
    }
}