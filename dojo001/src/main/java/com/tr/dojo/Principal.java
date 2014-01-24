package com.tr.dojo;

import java.util.HashMap;
import java.util.Map;

public class Principal {
	
	private final static Map<String, String> mapaSms = new HashMap<>();
	
	static {
		mapaSms.put("A", "2");
		mapaSms.put("B", "22");
		mapaSms.put("C", "222");
		mapaSms.put("D", "3");
		mapaSms.put("E", "33");
		mapaSms.put("F", "333");
		mapaSms.put("G", "4");
		mapaSms.put("H", "44");
		mapaSms.put("I", "444");
		mapaSms.put("J", "5");
		mapaSms.put("K", "55");
		mapaSms.put("L", "555");
		mapaSms.put("M", "6");
		mapaSms.put("N", "66");
		mapaSms.put("O", "666");
		mapaSms.put("P", "7");
		mapaSms.put("Q", "77");
		mapaSms.put("R", "777");
		mapaSms.put("S", "7777");
		mapaSms.put("T", "8");
		mapaSms.put("U", "88");
		mapaSms.put("V", "888");
		mapaSms.put("W", "9");
		mapaSms.put("X", "99");
		mapaSms.put("Y", "999");
		mapaSms.put("Z", "9999");
		mapaSms.put(" ", "0");
	}
	
	
	
	public String converte(String frase) {
		
		StringBuilder sb = new StringBuilder();
		String anterior = " "; 
		
		for (int i = 0; i < frase.length(); i++) {
			String letra = String.valueOf(frase.charAt(i));
			String atual = mapaSms.get(letra.toUpperCase());
			sb.append(pausa(anterior, atual));
			sb.append(atual);
			anterior = atual;
		}
		
		return sb.toString();
	}
	
	public String pausa(String anterior, String atual) {
		return anterior.substring(0,1).equals(atual.substring(0,1)) ? "_" : "";
	}
}
