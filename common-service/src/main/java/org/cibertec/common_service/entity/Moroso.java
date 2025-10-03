package org.cibertec.common_service.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Moroso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idreporte;
	private LocalDateTime fechareporte;
	private Integer idcliente;
	private double montoprestado;
	
	@Transient
	private String message;
	
	public int getIdreporte() {
		return idreporte;
	}
	public void setIdreporte(int idreporte) {
		this.idreporte = idreporte;
	}
	public LocalDateTime getFechareporte() {
		return fechareporte;
	}
	public void setFechareporte(LocalDateTime localDateTime) {
		this.fechareporte = localDateTime;
	}
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public double getMontoprestado() {
		return montoprestado;
	}
	public void setMontoprestado(double montoprestamo) {
		this.montoprestado = montoprestamo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
