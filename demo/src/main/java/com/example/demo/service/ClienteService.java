package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {
    
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

  
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> filtrarPorParteDoNome(String parteNome) {
        return clienteRepository.findNome(parteNome);
    }
    
    public List<Cliente> filtrarPorDdd(String ddd) {
        return clienteRepository.findDddTelefone("(" + ddd);
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}