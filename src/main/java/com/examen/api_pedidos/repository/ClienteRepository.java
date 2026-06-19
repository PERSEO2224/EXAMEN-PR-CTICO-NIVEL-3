package com.examen.api_pedidos.repository;

import com.examen.api_pedidos.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}