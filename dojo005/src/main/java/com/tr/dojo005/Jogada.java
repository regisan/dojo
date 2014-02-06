package com.tr.dojo005;

public class Jogada {
    
    private int jogada1;
    private int jogada2;

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

    public int getJogada1() {
        return jogada1;
    }

    public int getJogada2() {
        return jogada2;
    }

}
