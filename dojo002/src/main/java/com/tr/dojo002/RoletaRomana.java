package com.tr.dojo002;

public class RoletaRomana {

	public int roleta(int n, int k, int i) {
		Pessoa roda = iniciaPessoas(n);
		roda = encontrarPessoaInicial(i, roda);

		while (getNumeroSobreviventes(roda, n) > 1) {
			roda = encontrarPessoaEmKPosicao(k, roda);
			roda.morrer();
			roda = procurarProximoVivo(roda);
		}

		roda = procurarProximoVivo(roda);
		return roda.posicao;
	}

	public Pessoa iniciaPessoas(int numero) {
		Pessoa tail = new Pessoa(numero);
		Pessoa head = tail;

		for (int i = numero - 1; i > 0; i--) {
			Pessoa p = new Pessoa(i);
			p.setPessoaEsquerda(head);
			head = p;
		}

		tail.setPessoaEsquerda(head);

		return head;
	}

	public Pessoa encontrarPessoaInicial(int posicicaoInicial, Pessoa roda) {
		if (roda.posicao == posicicaoInicial)
			return roda;
		else
			return encontrarPessoaInicial(posicicaoInicial, roda.pessoaEsquerda);
	}

	public Pessoa encontrarPessoaEmKPosicao(int k, Pessoa roda) {

		for (int i = 1; i < k; i++) {
			roda = roda.pessoaEsquerda;
		}

		roda = procurarProximoVivo(roda);

		return roda;
	}

	public Pessoa procurarProximoVivo(Pessoa pessoa) {
		if (pessoa.isVivo())
			return pessoa;
		return procurarProximoVivo(pessoa.pessoaEsquerda);
	}

	public int getNumeroSobreviventes(Pessoa pessoa, int n) {
		int numeroDeVivos = 0;

		for (int i = 0; i < n; i++) {
			if (pessoa.isVivo())
				numeroDeVivos++;

			pessoa = pessoa.pessoaEsquerda;
		}

		return numeroDeVivos;
	}
}

class Pessoa {
	boolean vivo;
	int posicao;
	Pessoa pessoaEsquerda;

	public Pessoa(int posicao) {
		vivo = true;
		this.posicao = posicao;
	}

	public boolean isVivo() {
		return vivo;
	}

	public void morrer() {
		this.vivo = false;
	}

	public void setPessoaEsquerda(Pessoa esquerda) {
		this.pessoaEsquerda = esquerda;
	}
}