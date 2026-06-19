package com.examen.api_pedidos.exception;

public class StockInsuficienteException extends RuntimeException {

    public StockInsuficienteException(String mensaje) {
        super(mensaje);
    }

}