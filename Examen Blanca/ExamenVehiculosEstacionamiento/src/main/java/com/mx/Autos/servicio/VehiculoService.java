package com.mx.Autos.servicio;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Autos.Repository.EstanciaRepository;
import com.mx.Autos.Repository.VehiculoRepository;
import com.mx.Autos.dominio.Estancia;
import com.mx.Autos.dominio.Vehiculo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VehiculoService {

	@Autowired
	VehiculoRepository vehiculoRepo;
	@Autowired
	EstanciaRepository estanciaRepo;

	public void registrarEntrada(String placa) {
		Vehiculo v = vehiculoRepo.findById(placa).orElseThrow();
		v.setEntradaActual(LocalDateTime.now());
		vehiculoRepo.save(v);
	}

	public double registrarSalida(String placa) {
		Vehiculo v = vehiculoRepo.findById(placa).orElseThrow();
		LocalDateTime salida = LocalDateTime.now();
		long minutos = Duration.between(v.getEntradaActual(), salida).toMinutes();

		if ("OFICIAL".equals(v.getTipo())) {
			estanciaRepo.save(new Estancia(null, v.getEntradaActual(), salida, v));
		} else if ("RESIDENTE".equals(v.getTipo())) {
			v.setMinutosAcumulados(v.getMinutosAcumulados() + (int) minutos);
		} else if ("NO_RESIDENTE".equals(v.getTipo())) {
			return minutos * 0.5;
		}

		v.setEntradaActual(null);
		vehiculoRepo.save(v);
		return 0;
	}

	// Método para listar todos los vehículos
	public List<Vehiculo> listarVehiculos() {
		return vehiculoRepo.findAll();
	}

}
