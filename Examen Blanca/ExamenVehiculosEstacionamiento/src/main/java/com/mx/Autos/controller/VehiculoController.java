package com.mx.Autos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Autos.servicio.VehiculoService;


import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/vehiculos")
@RequiredArgsConstructor
public class VehiculoController {

    @Autowired
    VehiculoService service;

    // URL: http://localhost:9001/vehiculos/lista
    @GetMapping(value = "/lista")
    public ResponseEntity<?> lista() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.listarVehiculos());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al obtener los vehículos: " + e.getMessage());
        }
    }

    // URL: http://localhost:9001/vehiculos/entrada/
    @PostMapping(value = "entrada/{placa}")
    public ResponseEntity<String> entrada(@PathVariable("placa") String placa) {
        try {
            service.registrarEntrada(placa);
            return ResponseEntity.ok("Entrada registrada");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Error al registrar la entrada: " + e.getMessage());
        }
    }

    // URL: http://localhost:9001/vehiculos/salida/
    @PostMapping(value = "salida/{placa}")
    public ResponseEntity<String> salida(@PathVariable("placa") String placa) {
        try {
            double pago = service.registrarSalida(placa);
            return ResponseEntity.ok("Salida registrada. Pago: $" + pago);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Error al registrar la salida: " + e.getMessage());
        }
    }
}
