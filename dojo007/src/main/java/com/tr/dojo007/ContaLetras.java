package com.tr.dojo007;

import java.util.HashMap;
import java.util.Map;

/**
 * Dojo Contando as letras dos numeros
 * @see http://dojopuzzles.com/problemas/exibe/contando-as-letras-dos-numeros/
 *
 */
public class ContaLetras {
	
	private static final Map<Integer, String> MAPA = new HashMap<>();
	private static final int TOTAL_LETRAS_CEM = 3;
	
	static {
		MAPA.put(1, "um");
		MAPA.put(2, "dois");
		MAPA.put(3, "tres");
		MAPA.put(4, "quatro");
		MAPA.put(5, "cinco");
		MAPA.put(6, "seis");
		MAPA.put(7, "sete");
		MAPA.put(8, "oito");
		MAPA.put(9, "nove");
		MAPA.put(10, "dez");
		MAPA.put(11, "onze");
		MAPA.put(12, "doze");
		MAPA.put(13, "treze");
		MAPA.put(14, "quatorze");
		MAPA.put(15, "quinze");
		MAPA.put(16, "dezesseis");
		MAPA.put(17, "dezessete");
		MAPA.put(18, "dezoito");
		MAPA.put(19, "dezenove");
		MAPA.put(20, "vinte");
		MAPA.put(30, "trinta");
		MAPA.put(40, "quarenta");
		MAPA.put(50, "cinquenta");
		MAPA.put(60, "sessenta");
		MAPA.put(70, "setenta");
		MAPA.put(80, "oitenta");
		MAPA.put(90, "noventa");
		MAPA.put(100, "cento");
		MAPA.put(200, "duzentos");
		MAPA.put(300, "trezentos");
		MAPA.put(400, "quatrocentos");
		MAPA.put(500, "quinhentos");
		MAPA.put(600, "seiscentos");
		MAPA.put(700, "setecentos");
		MAPA.put(800, "oitocentos");
		MAPA.put(900, "novecentos");
		MAPA.put(1000, "mil");
	}

	public int contar(int n) {
		
	    int soma = 0;
		
	    for (int i = 1; i <= n; i++) {
	        int valorDecomposto = decompor(i);
	        
	        if (i == 100 && i == valorDecomposto) {
	            // cem ao inves de cento
	            soma += TOTAL_LETRAS_CEM;
	        }
	        else {
	            soma += MAPA.get(valorDecomposto).length();

	            // decompor a dezena do numero i
	            if (valorDecomposto < i) {
	                soma++; // incrementa com a conjuncao "e" (cento "e" um)
	                int sobra = i - valorDecomposto;
	                if (sobra > 20) {
	                    valorDecomposto = decompor(sobra);
	                    soma += MAPA.get(valorDecomposto).length();
	                    
	                    // ainda tem a unidade
	                    if (sobra > valorDecomposto) {
	                        soma++;
	                        soma += MAPA.get(sobra % 10).length();
	                    }
	                }
	                else {
	                    soma += MAPA.get(i - valorDecomposto).length();
	                }
	            }
	        }
	    }
		
		return soma;
	}
	
	/**
	 * Decompoe o numero em milhar, centena e dezena
	 * Para valor >= 1000, retorna a milhar (ex: 1000, 2000, 3000)
	 * Para 100 <= valor < 1000, retorna a centena (ex: 100, 200, 300)
	 * Para 20 <= valor < 100, retorna a dezena (ex: 20, 30, 40)
	 * Para valor < 20, retorna o proprio valor sem decompor
	 * @param valor
	 * @return milhar, centena, dezena ou o próprio valor
	 */
	public int decompor(int valor) {
	    return (valor >= 1000) ? valor - (valor % 1000) : 
	        (valor >= 100 && valor < 1000) ? valor - (valor % 100) : 
	            (valor >= 20 && valor < 100) ? valor - (valor % 10) : valor;
	}
	
}
