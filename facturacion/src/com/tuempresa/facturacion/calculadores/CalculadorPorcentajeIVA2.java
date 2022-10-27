package com.tuempresa.facturacion.calculadores;

import org.openxava.calculators.*;

import com.tuempresa.facturacion.util.*;

public class CalculadorPorcentajeIVA2 implements ICalculator {
	
	@Override
	public Object calculate() throws Exception {
		 return PreferenciasFacturacion.getPorcentajeIVADefecto();
		 }

}
