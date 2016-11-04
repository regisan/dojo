package com.tr.dojo;

import java.util.HashMap;
import java.util.Map;

public class ContandoLetras {

	Map<Integer, String> mapa = new HashMap<Integer, String>();
	private static final String E = "e";
	 
	public ContandoLetras(){
		mapa.put(1, "um");
		mapa.put(2, "dois");
		mapa.put(3, "três");
		mapa.put(4, "quatro");
		mapa.put(5, "cinco"); //21
		mapa.put(6, "seis"); //25
		mapa.put(7, "sete"); //29
		mapa.put(8, "oito"); //33
		mapa.put(9, "nove"); //37
		mapa.put(10, "dez"); //40
		mapa.put(11, "onze"); //44
		mapa.put(12, "doze"); //48
		mapa.put(13, "treze"); //53
		mapa.put(14, "catorze"); //60
		mapa.put(15, "quinze"); //66
		mapa.put(16, "dezesseis"); //75
		mapa.put(17, "dezessete"); //84
		mapa.put(18, "dezoito"); //91
		mapa.put(19, "dezenove"); //99
		mapa.put(20, "vinte"); //104
		mapa.put(30, "trinta"); //104
		mapa.put(40, "quarenta"); //104
		mapa.put(50, "cinquenta"); //104
		mapa.put(60, "sessenta"); //104
		mapa.put(70, "setenta"); //104
		mapa.put(80, "oitenta"); //104
		mapa.put(90, "noventa"); //104
		mapa.put(100, "cem"); //104
		mapa.put(200, "duzentos"); //104
		mapa.put(300, "trezentos"); //104
		mapa.put(400, "quatrocentos"); //104
		mapa.put(500, "quinhentos"); //104
		mapa.put(600, "seissentos"); //104
		mapa.put(700, "setessentos"); //104
		mapa.put(800, "oitossentos"); //104
		mapa.put(900, "novessentos"); //104
		mapa.put(1000, "mil"); //104

	}
	
	
	public int contar(Integer ultimo)
	{
		int valor = 0;
		
		for (int i = 1; i <= ultimo; i++) {
			if (i <= 20) 
			{
				valor += mapa.get(i).length();
			}	
			else  {
				int dezena = 0;
				int unidade = 0;
				if (i < 100) {
					String nome = String.valueOf(i);
					dezena = Integer.valueOf(nome.substring(0, 1)) * 10;
					unidade = Integer.valueOf(nome.substring(1, 2));
					valor += mapa.get(dezena).length();
					if (unidade > 0) {
						valor += mapa.get(unidade).length();
						valor ++;
					}
				} else {
					
				}
			}
		}
		
		return valor;
	}
}
