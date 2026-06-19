package com.examen.api_pedidos.service;

import com.examen.api_pedidos.entity.*;
import com.examen.api_pedidos.exception.PedidoNotFoundException;
import com.examen.api_pedidos.exception.StockInsuficienteException;
import com.examen.api_pedidos.repository.PedidoRepository;
import com.examen.api_pedidos.repository.ProductoRepository;
import com.examen.api_pedidos.service.impl.PedidoServiceImpl;
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
class PedidoServiceImplTest {

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private PedidoServiceImpl pedidoService;

    @Test
    void guardarPedidoExitoso() {

        Producto producto = Producto.builder()
                .id(1L)
                .nombre("Laptop")
                .precio(new BigDecimal("3500"))
                .stock(10)
                .build();

        DetallePedido detalle =
                DetallePedido.builder()
                        .productoId(1L)
                        .cantidad(2)
                        .build();

        Pedido pedido =
                Pedido.builder()
                        .detalles(List.of(detalle))
                        .build();

        when(productoRepository.findById(1L))
                .thenReturn(Optional.of(producto));

        when(pedidoRepository.save(any()))
                .thenReturn(pedido);

        Pedido resultado =
                pedidoService.guardar(pedido);

        assertNotNull(resultado);

        verify(productoRepository)
                .save(any(Producto.class));
    }

    @Test
    void stockInsuficiente() {

        Producto producto = Producto.builder()
                .id(1L)
                .nombre("Laptop")
                .precio(new BigDecimal("3500"))
                .stock(1)
                .build();

        DetallePedido detalle =
                DetallePedido.builder()
                        .productoId(1L)
                        .cantidad(5)
                        .build();

        Pedido pedido =
                Pedido.builder()
                        .detalles(List.of(detalle))
                        .build();

        when(productoRepository.findById(1L))
                .thenReturn(Optional.of(producto));

        assertThrows(
                StockInsuficienteException.class,
                () -> pedidoService.guardar(pedido)
        );
    }

    @Test
    void pedidoNoEncontrado() {

        when(pedidoRepository.findById(999L))
                .thenReturn(Optional.empty());

        assertThrows(
                PedidoNotFoundException.class,
                () -> pedidoService.buscarPorId(999L)
        );
    }
}