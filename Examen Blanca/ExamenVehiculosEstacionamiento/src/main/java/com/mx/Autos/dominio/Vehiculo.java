package com.mx.Autos.dominio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "VEHICULO_EXAMEN")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {

    @Id
    private String placa;

    @Column(nullable = false)
    private String tipo;

    @Column(name = "entrada_actual")
    private LocalDateTime entradaActual;

    @Column(name = "minutos_acumulados")
    private int minutosAcumulados;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Estancia> estancias = new ArrayList<>();

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public LocalDateTime getEntradaActual() {
		return entradaActual;
	}

	public void setEntradaActual(LocalDateTime entradaActual) {
		this.entradaActual = entradaActual;
	}

	public int getMinutosAcumulados() {
		return minutosAcumulados;
	}

	public void setMinutosAcumulados(int minutosAcumulados) {
		this.minutosAcumulados = minutosAcumulados;
	}
    
    
}

