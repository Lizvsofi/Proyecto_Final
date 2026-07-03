package mx.uam.cua.nodo_b.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FragmentService {

    private final RestTemplate restTemplate = new RestTemplate();

    public String[] obtenerVideosNodo(String urlNodo) {
        return restTemplate.getForObject(
                urlNodo + "/videos",
                String[].class
        );
    }

}
