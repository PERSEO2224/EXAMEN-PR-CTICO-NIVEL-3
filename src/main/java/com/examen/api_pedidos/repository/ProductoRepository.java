package com.examen.api_pedidos.repository;

import com.examen.api_pedidos.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}