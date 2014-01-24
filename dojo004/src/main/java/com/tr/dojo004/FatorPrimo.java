package com.tr.dojo004;

import java.util.ArrayList;
import java.util.List;

/**
 * Dojo realizado em 16/01/2014
 * @see http://dojopuzzles.com/problemas/exibe/geracao-de-fatores-primos/
 */

public class FatorPrimo {

	public List<Integer> calcularFatores(final int numero) {
		List<Integer> resultado = new ArrayList<>();

		if (numero == 1) {	
			resultado.add(1);
		}
		else {
			int quociente = numero;
			int primo = calcularProximoPrimo(1);
			
			do  {
				if (quociente % primo == 0) {
					quociente = quociente / primo;
					resultado.add(primo);
				} else {
					primo = calcularProximoPrimo(primo);
				}
			} while (quociente > 1);
		}

		return resultado;
	}
	
	public int calcularProximoPrimo(int n) {
		
		for (int i = n + 1; ; i++) {
			
			boolean isPrimo = true;
			int raiz = (int) Math.sqrt(i);
			
			for (int j = 2; j <= raiz && isPrimo; j++) {
				if (i % j == 0) { 
					isPrimo = false;
				}
			}
			
			if (isPrimo)
				return i;
		}
	}
}
