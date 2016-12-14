package com.tr.dojo;

import java.util.HashMap;
import java.util.Map;

public class Livraria {

    public static final double PRECO = 42.0;
    Map<Integer, Double> descontos = new HashMap<>();

    public Livraria() {
        super();
        descontos.put(0, 0.0);
        descontos.put(1, 1.0);
        descontos.put(2, 0.95);
        descontos.put(3, 0.90);
        descontos.put(4, 0.85);
        descontos.put(5, 0.80);
    }

    public double calcular(int[] volume) {
        double precoFinal = 0.0;
        int total = 0;
        do {
//            int qtde = 0;
            int dif = 0;
            total = 0;
            for (int i = 0; i < volume.length; i++) {
                total += volume[i];
                if (volume[i] > 0) {
                    dif++;
//                    qtde++;
                    volume[i]--;
                }
            }
            precoFinal += (PRECO * dif) * descontos.get(dif);
//            precoFinal = precoFinal + (PRECO * (qtde - dif));
        } while (total == 0);

        return precoFinal;
    }
}
