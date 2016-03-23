package com.tr.dojo201601;

import java.util.HashMap;
import java.util.Map;

public class Romanos {

	Map<Integer, String> mapa = new HashMap<>();

	public Romanos() {

		mapa.put(0, "");
		mapa.put(1, "I");
		mapa.put(4, "IV");
		mapa.put(5, "V");
		mapa.put(9, "IX");
		mapa.put(10, "X");
		mapa.put(40, "XL");
		mapa.put(50, "L");
		mapa.put(90, "XC");
		mapa.put(100, "C");
		mapa.put(400, "CD");
		mapa.put(500, "D");
		mapa.put(900, "CM");
		mapa.put(1000, "M");
	}

	public String convert(int valor) {
		String valorRomano = "";
		String valorString = String.valueOf(valor);

		for (int i = 0; i < valorString.length(); i++) {
			int valorUnidade = Integer.valueOf(valorString.substring(i, i + 1));
			for (int j = i + 1; j < valorString.length(); j++)
				valorUnidade = valorUnidade * 10;
			System.out.println(valor + " = " + valorUnidade);
			valorRomano = valorRomano + convertPorUnidade(valorUnidade);
		}

		return valorRomano;
	}

	private String convertPorUnidade(int valor) {
		String valorRomano = mapa.get(valor);

		if (valorRomano == null) {
			valorRomano = "";
			int div = 0;
			String caraca = "";

			if (valor <= 3) {
				div = valor;
				caraca = "I";
			} else if (valor > 4 && valor <= 10) {
				div = valor - 5;
				valorRomano = valorRomano + "V";
				caraca = "I";
			} else if (valor <= 30) {
				div = valor / 10;
				caraca = "X";
			} else if (valor > 40 && valor <= 100) {
				div = (valor - 50) / 10;
				valorRomano = valorRomano + "L";
				caraca = "X";
			} else if (valor <= 300) {
				div = valor / 100;
				caraca = "C";
			} else if (valor > 400 && valor <= 1000) {
				div = (valor - 500) / 100;
				valorRomano = valorRomano + "D";
				caraca = "C";
			}

			for (int i = 1; i <= div; i++) {
				valorRomano = valorRomano + caraca;
			}

		}
		return valorRomano;
	}

}
