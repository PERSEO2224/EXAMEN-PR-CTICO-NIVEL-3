package com.examen.api_pedidos.service;

import com.examen.api_pedidos.entity.Producto;
import com.examen.api_pedidos.repository.ProductoRepository;
import com.examen.api_pedidos.service.impl.ProductoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductoServiceImplTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoServiceImpl productoService;

    @Test
    void guardarProducto() {

        Producto producto = Producto.builder()
                .id(1L)
                .nombre("Laptop")
                .precio(new BigDecimal("3500"))
                .stock(10)
                .build();

        when(productoRepository.save(any()))
                .thenReturn(producto);

        Producto resultado =
                productoService.guardar(producto);

        assertEquals("Laptop",
                resultado.getNombre());
    }

    @Test
    void buscarProductoPorId() {

        Producto producto = Producto.builder()
                .id(1L)
                .build();

        when(productoRepository.findById(1L))
                .thenReturn(Optional.of(producto));

        Producto resultado =
                productoService.buscarPorId(1L);

        assertEquals(1L,
                resultado.getId());
    }

    @Test
    void listarProductos() {

        when(productoRepository.findAll())
                .thenReturn(List.of(new Producto()));

        assertEquals(
                1,
                productoService.listar().size()
        );
    }
}