package com.tr.dojo;

import java.util.ArrayList;
import java.util.List;

public class Principal {

    public String ligar(Corredor c) {
        List<Lampada> lampadas = c.getLampadas();
        
        // caminhada
        for (int i = 1; i <= lampadas.size(); i++) {
            
            // ligar ou desligar interruptor
            for (int j = 1; j <= lampadas.size(); j++) {
                if (j % i == 0){
                    lampadas.get(j-1).pressionarInterruptor();
                }
            }
        }
        
        return c.toString();
    }
    
}

class Lampada {
    private boolean ligada;
    
    public boolean isLigada (){
        return ligada;
    }
     
    public void pressionarInterruptor(){
        ligada = !ligada;
    }

    @Override
    public String toString() {
        return ligada ? "on" : "off";
    }
    
}

class Corredor {
    
    List<Lampada> lampadas;
    
    public Corredor(int numLampadas) {
        lampadas = new ArrayList<>(numLampadas);
        
        for (int i = 0; i < numLampadas; i++) {
            lampadas.add(new Lampada());
        }
    }
    
    public List<Lampada> getLampadas() {
        return lampadas;
    }
    
    @Override
    public String toString() {
        return lampadas.toString();
    }
    
}