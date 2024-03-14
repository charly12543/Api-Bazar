package com.CharlyCorporation.proyectoFinal.dto;

import com.CharlyCorporation.proyectoFinal.model.Cliente;
import com.CharlyCorporation.proyectoFinal.model.Producto;
import java.util.List;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VentasClienteDTO {
    
    private Long codigo_venta;
    private Double total;
    private List<Producto> listaProductos;
    private String nombreCliente;
    private String apellidoCliente;
    private Double ventaMasAlta;
    
    
    
}
