package com.tuempresa.practica1.calculadores;

import org.openxava.calculators.*;

import com.tuempresa.practica1.util.*;

public class CalculadorPorcentajeIVA implements ICalculator{
	
	@Override
	public Object calculate()throws Exception{
		return PreferenciasFacturacion.getPorcentajeIVADefecto();
	}

}
