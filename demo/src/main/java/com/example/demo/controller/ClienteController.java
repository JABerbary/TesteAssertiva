package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@Tag(name = "Clientes", description = "API para gerenciamento de clientes")
public class ClienteController {
    
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    @Operation(summary = "cadastrar  os clientes")
    public Cliente criar(@RequestBody Cliente cliente) {
        return clienteService.salvar(cliente);
    }
    @GetMapping
    @Operation(summary = "Listar todos os clientes")
    @ApiResponse(responseCode = "200", description = "Clientes encontrados")
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Buscar cliente por ID")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarPorId(id);
        return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
    }
    

    @GetMapping("/filtrar/nome")
    @Operation(summary = "Criar novo cliente")
    public List<Cliente> filtrarPorParteDoNome(@RequestParam String parteNome) {
        return clienteService.filtrarPorParteDoNome(parteNome);
    }
    
    @GetMapping("/filtrar/ddd")
    @Operation(summary = "filtrar com DDD")
    public List<Cliente> filtrarPorDdd(@RequestParam String ddd) {
        return clienteService.filtrarPorDdd(ddd);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "deletar DDD")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (clienteService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        if (clienteService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        cliente.setId(id);
        return ResponseEntity.ok(clienteService.salvar(cliente));
    }
}