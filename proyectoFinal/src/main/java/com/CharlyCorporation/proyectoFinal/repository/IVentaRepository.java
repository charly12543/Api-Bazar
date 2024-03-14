package com.CharlyCorporation.proyectoFinal.repository;

import com.CharlyCorporation.proyectoFinal.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long>{
    
}
