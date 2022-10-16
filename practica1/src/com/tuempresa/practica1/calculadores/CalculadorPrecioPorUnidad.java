package com.tuempresa.practica1.calculadores;

import static org.openxava.jpa.XPersistence.getManager;

import org.openxava.calculators.*;

import com.tuempresa.practica1.modelo.*;

import lombok.*;




public class CalculadorPrecioPorUnidad implements ICalculator{

	@Getter @Setter
	int numeroProducto;
	
	@Override
	public Object calculate() throws Exception{
		  
		Producto producto=getManager().find(Producto.class, numeroProducto);
		
		return producto.getPrecio();
	}
}
