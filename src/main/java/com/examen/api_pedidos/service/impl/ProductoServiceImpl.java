package com.examen.api_pedidos.service.impl;

import com.examen.api_pedidos.entity.Producto;
import com.examen.api_pedidos.repository.ProductoRepository;
import com.examen.api_pedidos.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    @Override
    public Producto buscarPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }
}