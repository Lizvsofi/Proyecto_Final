package mx.uam.cua.registry_service.controller;

import mx.uam.cua.registry_service.model.FragmentInfo;
import mx.uam.cua.registry_service.service.RegistryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registry")
public class RegistryController {

    private final RegistryService registryService;

    public RegistryController(RegistryService registryService) {
        this.registryService = registryService;
    }

    @PostMapping
    public String registrarFragmento(@RequestBody FragmentInfo fragmento) {

        System.out.println("===== REGISTRY =====");
        System.out.println("Nodo: " + fragmento.getNodo());
        System.out.println("Video: " + fragmento.getVideo());
        System.out.println("Fragmento: " + fragmento.getFragmento());

        registryService.registrar(fragmento);

        return "Fragmento registrado correctamente";
    }

    @GetMapping
    public List<FragmentInfo> obtenerFragmentos() {

        return registryService.obtenerTodos();
    }
}