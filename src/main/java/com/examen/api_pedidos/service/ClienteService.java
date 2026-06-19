package com.examen.api_pedidos.service;

import com.examen.api_pedidos.entity.Cliente;
import java.util.List;

public interface ClienteService {

    Cliente guardar(Cliente cliente);

    List<Cliente> listar();

    Cliente buscarPorId(Long id);

}