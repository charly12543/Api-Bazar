package com.CharlyCorporation.proyectoFinal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_cliente;
    @Basic
    private String nombre;
    private String apellido;
    private  String dni;
    
}
