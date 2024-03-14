package com.CharlyCorporation.proyectoFinal.service;

import com.CharlyCorporation.proyectoFinal.model.Cliente;
import com.CharlyCorporation.proyectoFinal.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{
    
    @Autowired
    private IClienteRepository repo;

    @Override
    public void saveCliente(Cliente clien) {
      repo.save(clien);
    }

    @Override
    public void deleteCliente(Long id) {
     repo.deleteById(id);
    }

    @Override
    public void editCliente(Cliente clien) {
      this.saveCliente(clien);
    }

    @Override
    public Cliente findCliente(Long id) {
        Cliente clien = repo.findById(id).orElse(null);
        return clien;
    } 

    @Override
    public List<Cliente> getCliente() {
       List<Cliente> lista = repo.findAll();
       return lista;
    }

    @Override
    public List<Cliente> saveVariosClientes(List<Cliente> lista) {
       List<Cliente> lista2 = repo.saveAll(lista);
       return lista2;
    }
    
    
}
