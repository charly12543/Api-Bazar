package com.CharlyCorporation.proyectoFinal.service;

import com.CharlyCorporation.proyectoFinal.model.Producto;
import com.CharlyCorporation.proyectoFinal.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{
    
    @Autowired
    private IProductoRepository repo;

    @Override
    public List<Producto> getProducto() {
      List<Producto> lista = repo.findAll();
      return lista;
    }

    @Override
    public void saveProducto(Producto prod) {
     repo.save(prod);
    }

    @Override
    public void deleteProducto(Long id) {
      repo.deleteById(id);
    }

    @Override
    public Producto findProducto(Long id) {
      Producto prod = repo.findById(id).orElse(null);
      return prod;
    }

    @Override
    public void editProducto(Producto prod) {
      this.saveProducto(prod);
    }

    @Override
    public List<Producto> getStock(int cantidad_disponible) {
        int existe;
     
        List<Producto> lista = this.getProducto();
        List<Producto> listaBusqueda = new ArrayList<Producto>();
        
        for (Producto producto : lista) {
            existe=producto.getCantidad_disponible();
            if(existe<=5){
                listaBusqueda.add(producto);
            }
        }
      return listaBusqueda;
    
    }
    
}
