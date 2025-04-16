package com.mx.Autos.dominio;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estancia_examen")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estancia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estancia_seq")
    @SequenceGenerator(name = "estancia_seq", sequenceName = "ESTANCIA_SEQ", allocationSize = 1)
    private Long id;

    private LocalDateTime entrada;
    private LocalDateTime salida;

    @ManyToOne
    @JoinColumn(name = "vehiculo_placa")
    private Vehiculo vehiculo;

    
    
	public Estancia(Long id, LocalDateTime entrada, LocalDateTime salida, Vehiculo vehiculo) {
		super();
		this.id = id;
		this.entrada = entrada;
		this.salida = salida;
		this.vehiculo = vehiculo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDateTime entrada) {
		this.entrada = entrada;
	}

	public LocalDateTime getSalida() {
		return salida;
	}

	public void setSalida(LocalDateTime salida) {
		this.salida = salida;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
    
    
}

