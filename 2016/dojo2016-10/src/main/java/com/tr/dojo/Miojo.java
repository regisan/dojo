package com.tr.dojo;

public class Miojo {

	public int calcula(int preparo, int ampMenor, int ampMaior) {
		int tempoMinimo = ampMenor;
		int tempoDiferenca = ampMaior - ampMenor;
		
		if (tempoDiferenca == 0) {
			return 9999;
		}
		
		if (tempoDiferenca == preparo) {
			tempoMinimo = ampMaior;
		}
		
		int tempoDif2 = tempoDiferenca;
		
		while (tempoDiferenca < preparo) {
			tempoMinimo += ampMenor;
			tempoDiferenca = tempoMinimo - ampMaior;		
		}
		
		if(tempoDiferenca != preparo){
			tempoMinimo = 9999;
		}
		
		int tempoMinimo2 = 9999;
		if (preparo % tempoDif2 == 0) {
			tempoMinimo2 = preparo / tempoDif2 * ampMaior;
		}
		
		if (tempoMinimo2 < tempoMinimo) {
			tempoMinimo = tempoMinimo2;
		}
		
		return tempoMinimo;
	}
	
}
