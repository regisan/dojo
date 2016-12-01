package com.tr.dojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PortaAutomatica {

    public int analisarRegistros(String[] log) {
        
        int qtdEntrada = 0;
        
        for (int i = 0; i < log.length; i++) {
            
            if (isValida(log[i])) {

                String h =  log[i].split(" ")[1];
                String conteudo = h.replaceAll("[\\D]", "");
                long hora = 0;
                if (!conteudo.isEmpty()) {
                    hora = Long.parseLong(conteudo);
                }

                if (hora >= 100000 && hora <= 160000) {
                    qtdEntrada++;
                }
            }
        }
        
        return qtdEntrada;
    }    
    
    public boolean isValida(String data){
        
        SimpleDateFormat sdf = new SimpleDateFormat("[yyyy-MM-dd hh:mm:ss]");
        try {   
            sdf.parse(data);
        } 
        catch (ParseException e) {
            return false;
        }
        
        return true;
    }
}
