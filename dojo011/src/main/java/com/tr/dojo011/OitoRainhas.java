package com.tr.dojo011;

public class OitoRainhas {

    private int[][] tabuleiro;
    private int tamanho;

    public OitoRainhas(int n) {
        tamanho = n;
        tabuleiro = new int[n][n];
    }

    public boolean validarHorizontal(int m) {
        for (int i = 0; i < tamanho; i++) {
            if (tabuleiro[m][i] == 1)
                return false;
        }
        return true;
    }

    public boolean validarVertical(int n) {
        for (int i = 0; i < tamanho; i++) {
            if (tabuleiro[i][n] == 1)
                return false;
        }
        return true;
    }

    public boolean validarDiagonalDireita(int m, int n) {
        int linhaAtual = 0;
        int colunaAtual = 0;

        if (m < n)
            colunaAtual = n - m;
        else if (m > n)
            linhaAtual = m - n;

        while (linhaAtual < tamanho && colunaAtual < tamanho) {
            if (tabuleiro[linhaAtual][colunaAtual] == 1)
                return false;

            linhaAtual++;
            colunaAtual++;
        }

        return true;
    }

    public boolean validarDiagonalEsquerda(int m, int n) {

        int linhaAtual = m;
        int colunaAtual = n;

        while (linhaAtual < tamanho && colunaAtual > 0) {
            if (tabuleiro[linhaAtual][colunaAtual] == 1)
                return false;

            linhaAtual++;
            colunaAtual--;
        }

        linhaAtual = m;
        colunaAtual = n;

        while (linhaAtual > 0 && colunaAtual < tamanho) {
            if (tabuleiro[linhaAtual][colunaAtual] == 1)
                return false;

            linhaAtual--;
            colunaAtual++;
        }

        return true;
    }

    public boolean posicionarRainha(int m, int n) {
        if (validarHorizontal(m) && validarVertical(n)
                && validarDiagonalDireita(m, n)
                && validarDiagonalEsquerda(m, n)) {

            tabuleiro[m][n] = 1;
            return true;
        }
        return false;
    }

    public void resolverTabuleiro(int m, int n, int numeroRainhasPosicionadas) {
        
        if (numeroRainhas == tamanho)
        
        if (posicionarRainha(m, n)) {
            
                resolverTabuleiro(m, n + 1);
        } else {
            resolverTabuleiro(m + 1, n);
        }
        
        
    }
}
