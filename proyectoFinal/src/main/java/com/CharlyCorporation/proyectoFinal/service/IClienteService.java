package com.CharlyCorporation.proyectoFinal.service;

import com.CharlyCorporation.proyectoFinal.model.Cliente;
import java.util.List;


public interface IClienteService {
    
    public void saveCliente(Cliente clien);
    
    public void deleteCliente(Long id);
    
    public void editCliente(Cliente clien);
    
    public Cliente findCliente(Long id);
    
    public List<Cliente> getCliente();
    
    public List<Cliente> saveVariosClientes(List<Cliente> lista);
    
}
