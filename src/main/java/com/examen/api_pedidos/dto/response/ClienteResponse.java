package com.examen.api_pedidos.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteResponse {

    private Long id;

    private String nombre;

    private String apellido;

    private String dni;

    private String correo;

}