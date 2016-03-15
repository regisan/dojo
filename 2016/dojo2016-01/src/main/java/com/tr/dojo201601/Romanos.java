package com.tr.dojo201601;

import java.util.HashMap;
import java.util.Map;

public class Romanos {

    Map<Integer, String> mapa = new HashMap<>();

    public Romanos() {

        mapa.put(1, "I");
        mapa.put(5, "V");
        mapa.put(10, "X");
        mapa.put(50, "L");
        mapa.put(100, "C");
        mapa.put(500, "D");
        mapa.put(1000, "M");
    }
    
    public String convertMod(int valor, int mod) {
        String caraca = "";
        int div = 0;
        String valorRomano = "";
        if(mod <= 3) {
            div = mod;
            caraca = "I";
        } else if(mod > 4 && mod <= 10) {
            div = mod - 5;
            valorRomano = valorRomano + "V";
            caraca = "I";
        }
        return caraca;
    }

    public String convert(int valor) {
        String valorRomano =  mapa.get(valor);

        if(valorRomano == null)
        {
            valorRomano = "";
            int div = 0;
            int mod = 0;
            String caraca = "";
            for(int x = 0; x < valor; x++){

                if(valor <= 3)
                {
                    div = valor;
                    caraca = "I";
                } else if(valor > 4 && valor <= 10)
                {
                    div = valor - 5;
                    valorRomano = valorRomano + "V";
                    caraca = "I";
                }
                else if(valor <= 30) {
                    div = valor / 10;
                    //x = valor - (div*10);
                    mod = valor % 10;
                    caraca = "X";
                }
                else {
                    div = valor / 100;
                    caraca = "C";
                }

                for (int i=1; i <= div ;i++) {
                    valorRomano = valorRomano + caraca;
                    if (mod != 0) {
                        valorRomano = valorRomano + convertMod(valor,mod);
                    }
                }

            }
        }
        return valorRomano;
    }

}
