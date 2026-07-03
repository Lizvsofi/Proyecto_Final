package mx.uam.cua.nodo_c.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.uam.cua.nodo_c.service.FragmentService;

@RestController
@RequestMapping("/p2p")
public class P2PController {

    private final FragmentService fragmentService;

    public P2PController(FragmentService fragmentService) {
        this.fragmentService = fragmentService;
    }

    @GetMapping("/nodoA")
    public String[] consultarNodoA(){

        return fragmentService.obtenerVideosNodo(
                "http://localhost:8081"
        );
    }

    @GetMapping("/nodoB")
    public String[] consultarNodoB(){

        return fragmentService.obtenerVideosNodo(
                "http://localhost:8082"
        );
    }

}
