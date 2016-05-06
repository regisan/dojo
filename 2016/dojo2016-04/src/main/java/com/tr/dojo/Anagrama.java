package com.tr.dojo;

import java.util.ArrayList;
import java.util.List;

public class Anagrama {
    
    public String gera(String palavra) {
        String result = "";
        List<String> lista = new ArrayList<>();

        
        for (int i = 0; i < palavra.length();i++) {
            
            result += String.valueOf(palavra.charAt(i));
            
            for (int j = 0; j < palavra.length();j++) {
            
                if (i != j) {
                    result += String.valueOf(palavra.charAt(j));
                }
                
            }
            
            if(!lista.contains(result)){
                lista.add(result);
            }
            result = "";
            
            
            result += String.valueOf(palavra.charAt(i));
            
            for (int w = palavra.length()-1; w >= 0;w--) {
                
                if (i != w) {
                    result += String.valueOf(palavra.charAt(w)); 
                }

            }
            
            if(!lista.contains(result)){
                lista.add(result);
            }
            result = "";
        }
                
        for (String s : lista) {
            result += s + ";";
        }
        
        return result;
    }

}
