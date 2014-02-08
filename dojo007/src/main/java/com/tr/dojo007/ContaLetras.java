package com.tr.dojo007;

import java.util.HashMap;
import java.util.Map;

/**
 * Dojo Contando as letras dos números
 * @see http://dojopuzzles.com/problemas/exibe/contando-as-letras-dos-numeros/
 *
 */
public class ContaLetras {
	
	private static Map<Integer, String> mapa = new HashMap<>();
	private static final int TOTAL_LETRAS_CEM = 3;
	
	static {
		mapa.put(1, "um");
		mapa.put(2, "dois");
		mapa.put(3, "tres");
		mapa.put(4, "quatro");
		mapa.put(5, "cinco");
		mapa.put(6, "seis");
		mapa.put(7, "sete");
		mapa.put(8, "oito");
		mapa.put(9, "nove");
		mapa.put(10, "dez");
		mapa.put(11, "onze");
		mapa.put(12, "doze");
		mapa.put(13, "treze");
		mapa.put(14, "quatorze");
		mapa.put(15, "quinze");
		mapa.put(16, "dezesseis");
		mapa.put(17, "dezessete");
		mapa.put(18, "dezoito");
		mapa.put(19, "dezenove");
		mapa.put(20, "vinte");
		mapa.put(30, "trinta");
		mapa.put(40, "quarenta");
		mapa.put(50, "cinquenta");
		mapa.put(60, "sessenta");
		mapa.put(70, "setenta");
		mapa.put(80, "oitenta");
		mapa.put(90, "noventa");
		mapa.put(100, "cento");
		mapa.put(200, "duzentos");
		mapa.put(300, "trezentos");
		mapa.put(400, "quatrocentos");
		mapa.put(500, "quinhentos");
		mapa.put(600, "seiscentos");
		mapa.put(700, "setecentos");
		mapa.put(800, "oitocentos");
		mapa.put(900, "novecentos");
		mapa.put(1000, "mil");
		
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
	            soma += mapa.get(valorDecomposto).length();
	        }
	        
	        // decompor a dezena do número i
	        if (valorDecomposto < i) {
	            soma++;
	            int sobra = i - valorDecomposto;
	            if (sobra > 20) {
	                valorDecomposto = decompor(sobra);
	                soma += mapa.get(valorDecomposto).length();
	                
	                // ainda tem a unidade
	                if (sobra > valorDecomposto) {
	                    soma++;
	                    soma += mapa.get(sobra % 10).length();
	                }
	                
	            }
	            else {
	                soma += mapa.get(i - valorDecomposto).length();
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
	 * Para valor < 20, retorna o próprio valor sem decompor
	 * @param valor
	 * @return milhar, centena, dezena ou o próprio valor
	 */
	public int decompor(int valor) {
	    return (valor >= 1000) ? valor - (valor % 1000) : 
	        (valor >= 100 && valor < 1000) ? valor - (valor % 100) : 
	            (valor >= 20 && valor < 100) ? valor - (valor % 10) : valor;
	}
	
}
