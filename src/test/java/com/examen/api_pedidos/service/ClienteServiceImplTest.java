package com.examen.api_pedidos.service;

import com.examen.api_pedidos.entity.Cliente;
import com.examen.api_pedidos.repository.ClienteRepository;
import com.examen.api_pedidos.service.impl.ClienteServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteServiceImplTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @Test
    void guardarCliente() {

        Cliente cliente = Cliente.builder()
                .id(1L)
                .nombre("Juan")
                .build();

        when(clienteRepository.save(any(Cliente.class)))
                .thenReturn(cliente);

        Cliente resultado = clienteService.guardar(cliente);

        assertNotNull(resultado);
        assertEquals("Juan", resultado.getNombre());
    }

    @Test
    void listarClientes() {

        when(clienteRepository.findAll())
                .thenReturn(List.of(new Cliente()));

        List<Cliente> lista = clienteService.listar();

        assertEquals(1, lista.size());
    }

    @Test
    void buscarClientePorId() {

        Cliente cliente = Cliente.builder()
                .id(1L)
                .nombre("Juan")
                .build();

        when(clienteRepository.findById(1L))
                .thenReturn(Optional.of(cliente));

        Cliente resultado = clienteService.buscarPorId(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
    }
}