package com.CharlyCorporation.proyectoFinal.dto;

import com.CharlyCorporation.proyectoFinal.model.Producto;
import java.util.List;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VentasProductoDTO {
    
    
    private Long codigo_venta;
    private List<Producto> listaProductos;
   
    
}
