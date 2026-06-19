package com.examen.api_pedidos.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PedidoResponse {

    private Long id;

    private String cliente;

    private BigDecimal total;

    private String estado;

}