package com.tr.dojo;

import java.util.ArrayList;
import java.util.List;

public class NumerosFelizes {

    public boolean isHappy(int numero) {

        int resultadoSomaQuadrados = somaQuadrados(numero);
        List<Integer> listaResult = new ArrayList<>();
        listaResult.add(numero);

        while (resultadoSomaQuadrados != 1) {

            resultadoSomaQuadrados = somaQuadrados(resultadoSomaQuadrados);
            if (listaResult.contains(resultadoSomaQuadrados)) {
                break;
            }
            listaResult.add(resultadoSomaQuadrados);
        }

        if (resultadoSomaQuadrados == 1) {
            return true;
        }
        
        return false;
    }

    public int somaQuadrados(int numero) {
        String numeroInicial = String.valueOf(numero);
        int soma = 0;

        for (int i = 0; i < numeroInicial.length(); i++) {
            String digito = String.valueOf(numeroInicial.charAt(i));
            int valor = Integer.parseInt(digito);

            soma += valor * valor;
        }

        return soma;
    }

}
