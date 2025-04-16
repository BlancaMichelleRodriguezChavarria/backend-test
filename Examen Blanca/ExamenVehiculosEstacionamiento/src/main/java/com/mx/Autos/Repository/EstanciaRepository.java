package com.mx.Autos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Autos.dominio.Estancia;

@Repository
public interface EstanciaRepository extends JpaRepository<Estancia, Long>{

}
