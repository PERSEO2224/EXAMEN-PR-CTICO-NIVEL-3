package com.examen.api_pedidos.controller;

import com.examen.api_pedidos.entity.Producto;
import com.examen.api_pedidos.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public Producto guardar(@RequestBody Producto producto) {
        return productoService.guardar(producto);
    }

    @GetMapping
    public List<Producto> listar() {
        return productoService.listar();
    }

    @GetMapping("/{id}")
    public Producto buscarPorId(@PathVariable Long id) {
        return productoService.buscarPorId(id);
    }
}