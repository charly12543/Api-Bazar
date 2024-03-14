package com.CharlyCorporation.proyectoFinal.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;
import java.util.List;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Venta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_venta;
    
    @Temporal(TemporalType.DATE)
    private LocalDate fecha_venta;
    private Double total;
    
    @ManyToMany(cascade = CascadeType.ALL)
      @JoinTable(name = "rel_venta_producto", 
                 joinColumns = @JoinColumn(name = "FK_VENTA",nullable = false),
                 inverseJoinColumns = @JoinColumn(name = "FK_PRODUCTO", nullable = false))
    private List<Producto> listaProductos;
    
    
    @ManyToOne
    @JoinColumn(name = "fk_cliente", 
                referencedColumnName = "id_cliente" )
    private Cliente unCliente;
    
}
