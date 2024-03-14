package com.CharlyCorporation.proyectoFinal.repository;

import com.CharlyCorporation.proyectoFinal.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long>{
    
}
