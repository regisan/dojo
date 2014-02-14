package com.tr.dojo008;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Detetive {

	int assassino;
	int localAssassinato;
	int armaUtilizada;
	
	int palpites = 0;

	List<Integer> suspeitos;
	List<Integer> armas;
	List<Integer> locais;

	public Detetive(int assassino, int local, int arma) {

		suspeitos = new ArrayList<>();
		for (int i = 1; i <= 10; i++)
			suspeitos.add(i);

		armas = new ArrayList<>();
		for (int i = 1; i <= 10; i++)
			armas.add(i);

		locais = new ArrayList<>();
		for (int i = 1; i <= 10; i++)
			locais.add(i);

		this.assassino = assassino;
		this.localAssassinato = local;
		this.armaUtilizada = arma;

	}

	public List<Integer> procurar() {
		palpites++;
		List<Integer> resultadosMisterio = new ArrayList<>();
		int testemunha = acusar(suspeitos.get(0), locais.get(0), armas.get(0));

		switch (testemunha) {
		case 1:
			suspeitos.remove(0);
			break;
		case 2:
			locais.remove(0);
			break;
		case 3:
			armas.remove(0);
			break;
		default:
			resultadosMisterio.add(suspeitos.get(0));
			resultadosMisterio.add(locais.get(0));
			resultadosMisterio.add(armas.get(0));
			System.out.println("palpites " + palpites);
			return resultadosMisterio;
		}

		return procurar();

	}

	public int acusar(int suspeito, int local, int arma) {

		Set<Integer> possibilidades = new HashSet<>();

		if (suspeito != assassino)
			possibilidades.add(1);

		if (local != localAssassinato)
			possibilidades.add(2);

		if (arma != armaUtilizada)
			possibilidades.add(3);

		if (possibilidades.size() == 0)
			return 0;

		return gerarRespostaAleatoria(possibilidades);
	}

	public int gerarRespostaAleatoria(Set<Integer> possibilidades) {
		List<Integer> pos = new ArrayList<>(possibilidades);
		int random = (int) (new Random().nextDouble() * 10);
		if (possibilidades.size() == 3) {
			if (random <= 3) {
				return pos.get(0);
			} else if (random > 3 && random < 7) {
				return pos.get(1);
			} else
				return pos.get(2);
		} else if (possibilidades.size() == 2) {
			if (random <= 4) {
				return pos.get(0);
			} else {
				return pos.get(1);
			}
		} else {
			return pos.get(0);
		}
	}
}
