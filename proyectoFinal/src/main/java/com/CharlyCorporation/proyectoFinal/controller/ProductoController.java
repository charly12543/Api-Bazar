package com.CharlyCorporation.proyectoFinal.controller;

import com.CharlyCorporation.proyectoFinal.model.Producto;
import com.CharlyCorporation.proyectoFinal.service.IProductoService;
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
@RequestMapping("/v1")
public class ProductoController {
    
    @Autowired
    private IProductoService service;
    
    @PostMapping("/producto/save")
    public String saveProducto(@RequestBody Producto prod){
        service.saveProducto(prod);
        return "Producto Generado exitosamente";
    }
    
    @GetMapping("/producto/lista")
    public List<Producto> getProducto(){
        List<Producto> lista= service.getProducto();
        return lista;
    }
    
    @GetMapping("/productos/find/{id}")
    public Producto findProducto(@PathVariable Long id){
        Producto producto= service.findProducto(id);
        return producto;
    }
    
    @PutMapping("/producto/editar")
    public Producto editProducto(@RequestBody Producto prod){
        service.editProducto(prod);
        return service.findProducto(prod.getCodigo_producto());
        
    }
    
    @DeleteMapping("/producto/delete/{id}")
    public String deleteProducto(@PathVariable Long id){
        service.deleteProducto(id);
        return "Producto eliminado exitosamente";
    }
    
    @GetMapping("/producto/stock/{disponible}")
    public List<Producto> getStock(@PathVariable int disponible){
        List<Producto> lista = service.getStock(disponible);
        return lista;
    }
    
    
    
}
