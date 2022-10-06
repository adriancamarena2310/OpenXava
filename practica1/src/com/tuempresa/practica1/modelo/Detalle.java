package com.tuempresa.practica1.modelo;

import javax.persistence.*;

import lombok.*;

@Embeddable @Getter @Setter 
public class Detalle {

	
	int cantidad;
	
	
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	Producto producto;
}
