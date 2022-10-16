package com.tuempresa.practica1.modelo;

import java.time.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;


@Entity @Getter @Setter
@View(extendsView="super.DEFAULT",
members="diaEntregaEstimados,"+
"factura{factura}")

@View(name="SinClienteNiFactura",
members="anyo,numero,fecha;"
		+ "detalles;"
		+ "observaciones")

public class Pedido extends DocumentoComercial{

	@ManyToOne
	@ReferenceView("SinClienteNiPedidos")
	Factura factura;
	
	
	@Depends("fecha")
	public int getDiaEntregaEstimados() {
		if(getFecha().getDayOfYear()<15) {
			return 20 -getFecha().getDayOfYear();
		}
		if ( getFecha().getDayOfWeek() == DayOfWeek.SUNDAY) 	{
			return 2;
		}
		if(getFecha().getDayOfWeek() == DayOfWeek.SATURDAY) {
			return 3;
		}
		return 1;
		
	}
	
	@Column(columnDefinition="INTEGER DEFAULT 1")
	int diasEntrega;
	
	@PrePersist @PreUpdate
	private void recalcularDiaEntrega() {
		setDiasEntrega(getDiaEntregaEstimados());
	}
	
	
}
