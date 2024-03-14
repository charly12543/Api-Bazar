package com.CharlyCorporation.proyectoFinal.service;

import com.CharlyCorporation.proyectoFinal.dto.VentasClienteDTO;
import com.CharlyCorporation.proyectoFinal.dto.VentasDTO;
import com.CharlyCorporation.proyectoFinal.dto.VentasProductoDTO;
import com.CharlyCorporation.proyectoFinal.model.Venta;
import com.CharlyCorporation.proyectoFinal.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{
    
    
    @Autowired
    private IVentaRepository repo;

    @Override
    public void saveVenta(Venta venta) {
       repo.save(venta);
    }
       

    @Override
    public List<Venta> getVenta() {
        List<Venta> lista = repo.findAll();
        return lista;
    }

    @Override
    public void deleteVenta(Long id) {
      repo.deleteById(id);
    }

    

    @Override
    public Venta findVenta(Long id) {
       Venta venta = repo.findById(id).orElse(null);
       return venta;
    }

    @Override
    public void editVenta(Venta venta) {
      this.saveVenta(venta);
    }

    @Override
    public List<Venta> saveVariasVentas(List<Venta> listaVentas) {
        List<Venta> lista = repo.saveAll(listaVentas);
        return lista;
    }

    @Override
    public List<VentasProductoDTO> getVentasProduc(Long codigo_venta) {
     
        VentasProductoDTO dto = new VentasProductoDTO();
        
        List<Venta> lista = this.getVenta();
        List<VentasProductoDTO> listaDTO = new ArrayList<VentasProductoDTO>();
        
        for(Venta venta : lista){
            if(venta.getCodigo_venta().equals(codigo_venta)){
            
            dto.setCodigo_venta(venta.getCodigo_venta());
            dto.setListaProductos(venta.getListaProductos());
            
            listaDTO.add(dto);
            }
            
        }
        
        return listaDTO;
        
    }   

    @Override
    public List<VentasDTO> ventaDia(LocalDate fecha_venta) {
       
         Double total = 0.0;
        int contador =0;
        
        VentasDTO dto = new VentasDTO();
        
        List<Venta> lista = this.getVenta();
        List<VentasDTO> listaNueva = new ArrayList<VentasDTO>();
        List<Object> listaId = new ArrayList<>();
        
        for (Venta venta : lista) {
            if (venta.getFecha_venta().equals(fecha_venta)) {
                  total += venta.getTotal();
                  contador++;
                  listaId.add(venta.getCodigo_venta());
                               
                  dto.setId_venta(venta.getCodigo_venta());
                  dto.setFecha_venta(fecha_venta);
                  dto.setVentaIndividual(venta.getTotal());
                  dto.setSumatoria_monto(total);
                  dto.setTotalVentas(contador);
                  dto.setListaIdVentas(listaId);
       
                                    
                  listaNueva.add(dto);
                  dto = new VentasDTO();
                                                    
            }
            
        }
          return listaNueva;
     

    } 

    @Override
    public VentasClienteDTO mayorVenta() {
        
        double mayor=0.0;
      
        VentasClienteDTO dto = new VentasClienteDTO();
        
        List<Venta> lista = this.getVenta();
        
        for (Venta venta : lista) {
            if(venta.getTotal() > mayor){
                mayor=venta.getTotal();
                
                dto.setCodigo_venta(venta.getCodigo_venta());
                dto.setListaProductos(venta.getListaProductos());
                dto.setTotal(venta.getTotal());
                dto.setNombreCliente(venta.getUnCliente().getNombre());
                dto.setApellidoCliente(venta.getUnCliente().getApellido());
                dto.setVentaMasAlta(mayor);
                
                
            }
        }
 
        return dto;
    }
    
    
    
}

