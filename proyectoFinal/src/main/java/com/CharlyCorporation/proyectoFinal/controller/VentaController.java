package com.CharlyCorporation.proyectoFinal.controller;

import com.CharlyCorporation.proyectoFinal.dto.VentasClienteDTO;
import com.CharlyCorporation.proyectoFinal.dto.VentasDTO;
import com.CharlyCorporation.proyectoFinal.dto.VentasProductoDTO;
import com.CharlyCorporation.proyectoFinal.model.Venta;
import com.CharlyCorporation.proyectoFinal.service.IVentaService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/venta")
public class VentaController {
    
    
    @Autowired
    private IVentaService service;
    
    @PostMapping("/crear")
    public List<Venta> saveVariasVentas(@RequestBody List<Venta> listaVentas){
        List<Venta> lista = service.saveVariasVentas(listaVentas);
        return lista;
    }
    
    
    @GetMapping("/lista")
    public List<Venta> getVentas(){
        List<Venta> lista = service.getVenta();
        return lista;
    }
    
    @DeleteMapping("/borrar/{id}")
    public String deleteVenta(@PathVariable Long id){
        service.deleteVenta(id);
        return "Venta eliminada";
    }
    
    @GetMapping("/find/{id}")
    public Venta findVenta(@PathVariable Long id){
        Venta venta = service.findVenta(id);
        return venta;
    }
    
    @PutMapping("/edit")
    public Venta editVenta(@RequestBody Venta venta){
        service.editVenta(venta);
        return service.findVenta(venta.getCodigo_venta());
    }
    
    @GetMapping("/productos/{codigo_venta}")
    public List<VentasProductoDTO> getVentaProd(@PathVariable Long codigo_venta){
        List<VentasProductoDTO> lista = service.getVentasProduc(codigo_venta);
        return lista;
    }
    
    @GetMapping("/dia/{fecha_venta}")
    public List<VentasDTO> getVentaFecha(@PathVariable LocalDate fecha_venta){
        List<VentasDTO> lista = service.ventaDia(fecha_venta);
        return lista;
    }
    
    @GetMapping("/mayor_venta")
    public VentasClienteDTO ventaM(){
      VentasClienteDTO dto = service.mayorVenta();
      return dto;
    }
    
            
     
}
