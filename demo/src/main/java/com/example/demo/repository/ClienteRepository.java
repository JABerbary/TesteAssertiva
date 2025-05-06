package com.example.demo.repository;

import com.example.demo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    @Query(value = "SELECT * FROM clientes WHERE nome LIKE CONCAT('%', :parteNome, '%')", nativeQuery = true)
    List<Cliente> findNome(@Param("parteNome") String parteNome);

    @Query(value = "SELECT * FROM clientes WHERE telefone LIKE CONCAT(:ddd, '%')", nativeQuery = true)
    List<Cliente> findDddTelefone(@Param("ddd") String ddd);
}