package com.tuempresa.practica1.modelo;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.tuempresa.practica1.calculadores.*;

import lombok.*;

@Embeddable @Getter @Setter 
public class Detalle {

	
	int cantidad;
	
	
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	Producto producto;
	
	@Stereotype("DINERO")
	@Depends("precioPorUnidad, cantidad")
	public BigDecimal getImporte() {
		if(precioPorUnidad==null)return BigDecimal.ZERO;
		return new BigDecimal(cantidad).multiply(precioPorUnidad);
	}
	
	
	@DefaultValueCalculator(value=CalculadorPrecioPorUnidad.class,
			properties=@PropertyValue(name="numeroProducto",from="producto.numero"))
	@Stereotype("DINERO")
	BigDecimal precioPorUnidad;
	
	
}
