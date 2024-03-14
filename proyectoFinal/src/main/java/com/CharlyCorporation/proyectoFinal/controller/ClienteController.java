package com.CharlyCorporation.proyectoFinal.controller;

import com.CharlyCorporation.proyectoFinal.model.Cliente;
import com.CharlyCorporation.proyectoFinal.service.IClienteService;
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
public class ClienteController {
    
    @Autowired
    private IClienteService service;
    
    @PostMapping("/clientes/crear")
    public String saveCliente(@RequestBody Cliente cliente){
        service.saveCliente(cliente);
        return "Cliente creado exitosamente";
    }
    
    @GetMapping("/clientes/lista")
    public List<Cliente> getCliente(){
        List<Cliente> lista = service.getCliente();
        return lista;
    }
    
    @PostMapping("/clientes/crearVarios")
    public List<Cliente> saveClientevarios(@RequestBody List<Cliente> lista){
        List<Cliente> listado = service.saveVariosClientes(lista);
        return listado;
    }
    
    @DeleteMapping("/cliente/borrar/{id}")
    public String deleteCliente(@PathVariable Long id){
        service.deleteCliente(id);
        return "Cliente eliminado";
    }
    
    @PutMapping("/cliente/edit")
    public Cliente editCliente(@RequestBody Cliente cliente){
        service.editCliente(cliente);
        return service.findCliente(cliente.getId_cliente());
    }
    
    @GetMapping("/cliente/find/{id}")
    public Cliente findCliente(@PathVariable Long id){
       Cliente cliente = service.findCliente(id);
       return cliente;
    }
    
    
    
    
    
    
    
    
    
    
    
}
