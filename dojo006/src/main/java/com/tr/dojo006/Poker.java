package com.tr.dojo006;

import java.util.Collections;
import java.util.List;

public class Poker {
	
	public Carta getCartaMaior(Carta carta1, Carta carta2){
		if (carta1.compareTo(carta2) == 1) {
			return carta1;
		} else {
			return carta2;
			
		}
	}
}

class Carta implements Comparable<Carta> {
	int valor;
	String naipe;
	
	public Carta (int _valor, String _naipe) {
		valor = _valor;
		naipe = _naipe;
	}
	
	
	@Override
	public int compareTo (Carta outraCarta) {
		if (this.valor == outraCarta.valor)
			return 0;
		else
			return (this.valor > outraCarta.valor) ? 1 : -1;
	}
}

class Mao {
	List<Carta> maoJogador;
	
	public Mao (List<Carta> mao) {
		this.maoJogador = mao;
		Collections.sort(maoJogador);
	}

	public boolean isPar(){
		boolean hasPar = false;
		
		for (int i = 0; i < maoJogador.size() && !hasPar; i++) {
			Carta carta1 = maoJogador.get(i);
			Carta carta2 = null;
			
			if (i < maoJogador.size() -1)
				carta2 = maoJogador.get(i+1);
			
			if (carta2 != null && carta1.compareTo(carta2) == 0)
				hasPar = true;
		}
		
		return hasPar;		
	}
	
	public boolean isTrinca(){
		
		boolean hasThreeOfKind = false;
		
		for (int i = 0; i < maoJogador.size() && !hasThreeOfKind; i++) {
			Carta carta1 = maoJogador.get(i);
			Carta carta2 = null;
			Carta carta3 = null;
			
			if (i < maoJogador.size() -1){
				carta2 = maoJogador.get(i+1);	
			}
			
			if (carta2 != null && carta1.compareTo(carta2) == 0)
				if (i < maoJogador.size() -2){
					carta3 = maoJogador.get(i+2);
				}
				if (carta3 != null && carta2.compareTo(carta3) == 0)
					hasThreeOfKind = true;
		}
		
		return hasThreeOfKind;

	}
	
	public boolean is2Par(){
		int parCount = 0;
		
		for (int i = 0; i < maoJogador.size(); i++) {
			Carta carta1 = maoJogador.get(i);
			Carta carta2 = null;
			
			if (i < maoJogador.size() -1)
				carta2 = maoJogador.get(i+1);
			
			if (carta2 != null && carta1.compareTo(carta2) == 0 && parCount < 2){
				parCount++;
			}
		}
		
		return parCount == 2 ? true : false;		
	}
	
	public boolean isSequencia() {
		for (int i = 0; i < maoJogador.size(); i++) {
			int valorCartaAtual = maoJogador.get(i).valor;
			
			if (i < maoJogador.size() - 1) {
				if (!(valorCartaAtual == 5 && maoJogador.get(i + 1).valor == 14)) {
					if ((valorCartaAtual + 1) != maoJogador.get(i + 1).valor)
						return false;
				}
			}
			
		}
		
		return true;
	}

	public boolean isFullHouse() {
		
		if (is2Par() && isTrinca()){
			return true;
		}
		return false;
	}

}