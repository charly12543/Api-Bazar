package com.CharlyCorporation.proyectoFinal.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_producto;
    @Basic
    private String nombre;
    private String marca;
    private Double costo;
    private int cantidad_disponible;
    
//    @ManyToMany(mappedBy = "listaProductos")
//    private List<Venta> listaVenta;
    
    
}
