package com.CharlyCorporation.proyectoFinal.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VentasDTO {
    
    
    private Long id_venta;
    private LocalDate fecha_venta;
    private int totalVentas;
    private Double ventaIndividual;
    private Double sumatoria_monto;
    private List<Object> listaIdVentas;
 
    
    
}
