package com.mx.Autos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Autos.dominio.Vehiculo;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, String> {

}
