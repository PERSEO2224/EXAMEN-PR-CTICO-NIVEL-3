package com.examen.api_pedidos.exception;

import com.examen.api_pedidos.response.BaseResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PedidoNotFoundException.class)
    public BaseResponse<Object> pedidoNoEncontrado(
            PedidoNotFoundException ex) {

        return BaseResponse.builder()
                .codigo(404)
                .mensaje(ex.getMessage())
                .objeto(null)
                .build();
    }

    @ExceptionHandler(StockInsuficienteException.class)
    public BaseResponse<Object> stockInsuficiente(
            StockInsuficienteException ex) {

        return BaseResponse.builder()
                .codigo(400)
                .mensaje(ex.getMessage())
                .objeto(null)
                .build();
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public BaseResponse<Object> datoDuplicado(
            DataIntegrityViolationException ex) {

        return BaseResponse.builder()
                .codigo(400)
                .mensaje("El registro ya existe en la base de datos")
                .objeto(null)
                .build();
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse<Object> errorGeneral(
            Exception ex) {

        return BaseResponse.builder()
                .codigo(500)
                .mensaje(ex.getMessage())
                .objeto(null)
                .build();
    }
}