package com.tuempresa.practica1.modelo;

import java.util.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

@Entity @Getter @Setter
public class Autor {

	@Id @GeneratedValue(generator="System-uuid")
	@Hidden
	@GenericGenerator(name="System-uuid",strategy="uuid")
	@Column(length=32)
	String oid;
	
	@Column(length=50) @Required
	String nombre;
	
	@OneToMany(mappedBy="autor",cascade=CascadeType.REMOVE)
	@ListProperties("numero,descripcion,precio")
	Collection<Producto>productos;
}
