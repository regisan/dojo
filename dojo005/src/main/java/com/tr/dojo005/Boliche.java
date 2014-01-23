package com.tr.dojo005;

import java.util.List;

public class Boliche {

	/**
	 * @param jogadas
	 * @return
	 */
	public int resultadoPlacar(List<Jogada> jogadas) {
		int soma = 0;

		boolean aconteceuSpare = false;
		boolean aconteceuStrike1 = false;
		boolean aconteceuStrike2 = false;

		for (int i = 0; i < jogadas.size(); i++) {

			Jogada jogada = jogadas.get(i);

			if (i >= 10) {
				if (aconteceuStrike2) {
					soma += jogada.jogada1;
				}
				soma += jogada.jogada1 + jogada.jogada2;
			} 
			else {
				if (aconteceuStrike2) {
					soma += jogada.jogada1;
				}

				aconteceuStrike2 = false;

				if (aconteceuSpare) {
					soma += jogada.jogada1;
				} 
				else if (aconteceuStrike1) {
					soma += jogada.jogada1 + jogada.jogada2;
					aconteceuStrike2 = jogada.isStrike();
				}

				soma += jogada.jogada1 + jogada.jogada2;
				aconteceuSpare = jogada.isSpare();
				aconteceuStrike1 = jogada.isStrike();
			}
		}

		return soma;
	}

}

class Jogada {

	int jogada1;
	int jogada2;

	public Jogada(int j1, int j2) {
		jogada1 = j1;
		jogada2 = j2;
	}

	public boolean isSpare() {
		return jogada1 != 10 && (jogada1 + jogada2 == 10);
	}

	public boolean isStrike() {
		return jogada1 == 10;
	}
}
