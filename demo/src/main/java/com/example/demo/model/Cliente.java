package com.example.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Schema(description = "Entidade cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "id do cliente", example = "1")
    private Long id;
    
    @Schema(description = "cpf  cliente", example = "123.456.789-09")
    private String cpf;
    
    @Schema(description = "nome do cliente", example = "João Silva")
    private String nome;
    
    @Schema(description = "email do cliente", example = "joao@example.com")
    private String email;
    
    @Schema(description = "número de telefone com DDD", example = "(11) 98765-4321")
    private String telefone;

 
    public String getDdd() {
        if (telefone != null && telefone.startsWith("(") && telefone.length() > 3) {
            return telefone.substring(1, 3);
        }
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }
}