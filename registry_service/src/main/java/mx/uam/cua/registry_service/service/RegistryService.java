package mx.uam.cua.registry_service.service;

import mx.uam.cua.registry_service.model.FragmentInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistryService {

    private final List<FragmentInfo> fragmentos = new ArrayList<>();

    public void registrar(FragmentInfo fragmento) {
        fragmentos.add(fragmento);
    }

    public List<FragmentInfo> obtenerTodos() {
        return fragmentos;
    }
}