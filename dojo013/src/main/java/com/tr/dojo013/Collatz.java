package com.tr.dojo013;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Collatz {
    
    private Map<Long, Long> ranking = new HashMap<>(1000000);
    
    public boolean isPar(long numero) {
        return numero % 2 == 0;
    }
    
    public long calcularProximo(long atual) {
        if (isPar(atual))
            return atual / 2;
        else
            return atual * 3 + 1;
    }
    
    public long getTamanhoSequencia(long inicial) {
        long tamanho = 1;
        long termo = inicial;
        List<Long> sequencia = new ArrayList<>();

        do {
            
            if (ranking.containsKey(termo)) {
                if (termo != inicial) {
                    tamanho += ranking.get(termo);
                }
                else {
                    tamanho++;
                }
                break;
            }
            
            termo = calcularProximo(termo);
            sequencia.add(termo);
            tamanho++;
            
        } while (termo != 1);
        
        ranking.put(inicial, tamanho);
        
        long auxiliar = tamanho;
        
        for (Long valor : sequencia) {
            if (!ranking.containsKey(valor))
                ranking.put(valor, --auxiliar);
        }
        
        sequencia.clear();        
        return tamanho;
    }
    
    public long getMaiorSequencia(int inicio, int fim) {
        int maiorValor = 0;
        long chaveSequencia = 0;
        
        for (int i = inicio; i <= fim; i++) {
            getTamanhoSequencia(i);
        }
        
        
        for (Long chave : ranking.keySet()) {
            if (ranking.get(chave).intValue() > maiorValor) {
                maiorValor = ranking.get(chave).intValue();
                chaveSequencia = chave;
            }
        }
        return chaveSequencia;
    }
}
