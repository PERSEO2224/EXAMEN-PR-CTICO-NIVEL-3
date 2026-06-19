package com.examen.api_pedidos.service;

import com.examen.api_pedidos.entity.Producto;
import java.util.List;

public interface ProductoService {

    Producto guardar(Producto producto);

    List<Producto> listar();

    Producto buscarPorId(Long id);

}