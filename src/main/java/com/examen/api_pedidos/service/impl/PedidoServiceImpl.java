package com.examen.api_pedidos.service.impl;

import com.examen.api_pedidos.entity.DetallePedido;
import com.examen.api_pedidos.entity.Pedido;
import com.examen.api_pedidos.entity.Producto;
import com.examen.api_pedidos.exception.PedidoNotFoundException;
import com.examen.api_pedidos.exception.StockInsuficienteException;
import com.examen.api_pedidos.repository.PedidoRepository;
import com.examen.api_pedidos.repository.ProductoRepository;
import com.examen.api_pedidos.service.PedidoService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProductoRepository productoRepository;

    public PedidoServiceImpl(
            PedidoRepository pedidoRepository,
            ProductoRepository productoRepository) {

        this.pedidoRepository = pedidoRepository;
        this.productoRepository = productoRepository;
    }

    @Override
    public Pedido guardar(Pedido pedido) {

        BigDecimal total = BigDecimal.ZERO;

        for (DetallePedido detalle : pedido.getDetalles()) {

            Producto producto =
                    productoRepository.findById(detalle.getProductoId())
                            .orElseThrow(() ->
                                    new RuntimeException("Producto no encontrado"));

            if (producto.getStock() < detalle.getCantidad()) {

                throw new StockInsuficienteException(
                        "Stock insuficiente para "
                                + producto.getNombre());
            }

            producto.setStock(
                    producto.getStock()
                            - detalle.getCantidad());

            productoRepository.save(producto);

            detalle.setNombreProducto(
                    producto.getNombre());

            detalle.setPrecioUnitario(
                    producto.getPrecio());

            detalle.setSubtotal(
                    producto.getPrecio()
                            .multiply(
                                    BigDecimal.valueOf(
                                            detalle.getCantidad()
                                    )
                            )
            );

            detalle.setPedido(pedido);

            total = total.add(
                    detalle.getSubtotal());
        }

        pedido.setTotal(total);

        return pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido buscarPorId(Long id) {

        return pedidoRepository.findById(id)
                .orElseThrow(() ->
                        new PedidoNotFoundException(
                                "Pedido no encontrado con ID: " + id
                        )
                );
    }
}