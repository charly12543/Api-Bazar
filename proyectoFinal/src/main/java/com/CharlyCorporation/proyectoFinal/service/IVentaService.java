
package com.CharlyCorporation.proyectoFinal.service;

import com.CharlyCorporation.proyectoFinal.dto.VentasClienteDTO;
import com.CharlyCorporation.proyectoFinal.dto.VentasDTO;
import com.CharlyCorporation.proyectoFinal.model.Venta;
import com.CharlyCorporation.proyectoFinal.dto.VentasProductoDTO;
import java.time.LocalDate;
import java.util.List;


public interface IVentaService {
    
    public void saveVenta(Venta venta);
    
    public List<Venta> getVenta();
    
    public void deleteVenta(Long id);
    
    public void editVenta(Venta venta);
    
    public Venta findVenta(Long id);
    
    public List<Venta> saveVariasVentas(List<Venta> listaVentas);
    
    public List<VentasProductoDTO> getVentasProduc(Long codigo_venta);
    
    public List<VentasDTO> ventaDia(LocalDate fecha_venta);
    
    public VentasClienteDTO mayorVenta();
    
}
