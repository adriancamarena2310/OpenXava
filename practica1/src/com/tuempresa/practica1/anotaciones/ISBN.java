package com.tuempresa.practica1.anotaciones;

import java.lang.annotation.*;

import javax.validation.*;

@Constraint(validatedBy= com.tuempresa.practica1.validadores.ValidadorISBN.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ISBN {

	Class<?>[]groups() default{};
	Class<? extends Payload>[] Payload() default{};
	String message() default "isbn_invalido";
}
