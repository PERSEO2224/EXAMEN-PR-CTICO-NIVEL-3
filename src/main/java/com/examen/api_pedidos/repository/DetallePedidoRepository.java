package com.examen.api_pedidos.repository;

import com.examen.api_pedidos.entity.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
}