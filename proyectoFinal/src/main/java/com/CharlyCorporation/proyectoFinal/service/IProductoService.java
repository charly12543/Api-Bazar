package com.CharlyCorporation.proyectoFinal.service;

import com.CharlyCorporation.proyectoFinal.model.Producto;
import java.util.List;


public interface IProductoService {
    
    public List<Producto> getProducto();
    
    public void saveProducto(Producto prod);
    
    public void deleteProducto(Long id);
    
    public Producto findProducto(Long id);
    
    public void editProducto(Producto prod);
    
    public List<Producto> getStock(int cantidad_disponible);
    
}
