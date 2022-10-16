package com.tuempresa.practica1.modelo;


import javax.persistence.*;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

@MappedSuperclass
@Getter @Setter
public class Identificable {

	@Id
	@GeneratedValue(generator="System-uuid")
	@Hidden
	@GenericGenerator(name="System-uiid", strategy = "uuid")
	@Column(length=32)
	String oid;
	
}
