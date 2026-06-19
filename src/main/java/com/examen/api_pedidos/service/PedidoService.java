package com.examen.api_pedidos.service;

import com.examen.api_pedidos.entity.Pedido;
import java.util.List;

public interface PedidoService {

    Pedido guardar(Pedido pedido);

    List<Pedido> listar();

    Pedido buscarPorId(Long id);

}