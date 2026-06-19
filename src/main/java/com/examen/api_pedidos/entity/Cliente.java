package com.examen.api_pedidos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    private String dni;

    private String correo;

    private LocalDate fechaRegistro;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Pedido> pedidos;
}