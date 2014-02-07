package com.tr.dojo007;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ContaLetras {
	
	private static Map<Integer, String> mapaUnidade = new HashMap<>();
	private static Map<Integer, String> mapaDezena = new HashMap<>();
	private static Map<Integer, String> mapaDezenaMultiDez = new HashMap<>();
	private static Map<Integer, String> mapaCem = new HashMap<>();
	private static Map<Integer, String> mapaCentena = new HashMap<>();
	private static Map<Integer, String> mapaMil = new HashMap<>();
	private static final String separador = "e";
	
	static {
		mapaUnidade.put(1, "um");
		mapaUnidade.put(2, "dois");
		mapaUnidade.put(3, "tres");
		mapaUnidade.put(4, "quatro");
		mapaUnidade.put(5, "cinco");
		mapaUnidade.put(6, "seis");
		mapaUnidade.put(7, "sete");
		mapaUnidade.put(8, "oito");
		mapaUnidade.put(9, "nove");
		mapaDezena.put(10, "dez");
		mapaDezena.put(11, "onze");
		mapaDezena.put(12, "doze");
		mapaDezena.put(13, "treze");
		mapaDezena.put(14, "quatorze");
		mapaDezena.put(15, "quinze");
		mapaDezena.put(16, "dezesseis");
		mapaDezena.put(17, "dezessete");
		mapaDezena.put(18, "dezoito");
		mapaDezena.put(19, "dezenove");
		mapaDezenaMultiDez.put(20, "vinte");
		mapaDezenaMultiDez.put(30, "trinta");
		mapaDezenaMultiDez.put(40, "quarenta");
		mapaDezenaMultiDez.put(50, "cinquenta");
		mapaDezenaMultiDez.put(60, "sessenta");
		mapaDezenaMultiDez.put(70, "setenta");
		mapaDezenaMultiDez.put(80, "oitenta");
		mapaDezenaMultiDez.put(90, "noventa");
		mapaCem.put(100, "cem");
		mapaCentena.put(100, "cento");
		mapaCentena.put(200, "duzentos");
		mapaCentena.put(300, "trezentos");
		mapaCentena.put(400, "quatrocentos");
		mapaCentena.put(500, "quinhentos");
		mapaCentena.put(600, "seiscentos");
		mapaCentena.put(700, "setecentos");
		mapaCentena.put(800, "oitocentos");
		mapaCentena.put(900, "novecentos");
		mapaMil.put(1000, "mil");
		
	}

	public int contar(int n) {
		
		StringBuilder numeroExtenso = new StringBuilder();
		//219
		if(n == 1000){ 
			numeroExtenso.append(mapaMil.get(n));
			n=999;
		}
		int x = n % 100;
		if(n >= 100){
			for (int i = n; i > 99; i--) {
				
				if(n == 100) {
				    numeroExtenso.append(contarDezenas( x,""));
					numeroExtenso.append(mapaCem.get(n));
				    numeroExtenso.append(contarDezenas(99,""));
				}
				else if (n % 100 == 0){
					numeroExtenso.append(mapaCentena.get(n - n % 100));
					numeroExtenso.append(contarDezenas(99, ""));
				}
				else if (n % 100 > 0){
					numeroExtenso.append(mapaCentena.get(n - n % 100));
					numeroExtenso.append(separador);
				}
				n--;
			}
		} else {
			return numeroExtenso.append(contarDezenas(n,"")).length();
		}
			
			

		
		return numeroExtenso.length();
	}
	
	public StringBuilder contarDezenas(int n , String centena) {
		StringBuilder numeroExtenso = new StringBuilder();
		
		if(n > 19 && n < 100){
			for (int i = n; i > 19; i--) {
				numeroExtenso.append(centena);
				numeroExtenso.append(mapaDezenaMultiDez.get(n - n%10));
				if (n%10 > 0 && n > 20){
					numeroExtenso.append(separador);
					numeroExtenso.append(mapaUnidade.get(n%10));
				}
				n--;
			}
		}
		
		if(n > 9){
			for (int i = n; i > 9; i--) {
				numeroExtenso.append(centena);
				numeroExtenso.append(mapaDezena.get(i));
			}
			
			n = 9;
		}
		
		
		for (int i =1; i<=n ;i++) {
			numeroExtenso.append(centena);
			numeroExtenso.append(mapaUnidade.get(i));
		}
		
		return numeroExtenso;

	}
	
}
