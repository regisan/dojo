package com.tr.dojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Parentese {
    static final String PARANTESES_A = "(";
    static final String PARANTESES_F = ")";
    
    Stack<String> operandos = new Stack<>();
    Stack<String> operadores = new Stack<>();
    
    public int avaliar(String expressao) {
        
        String[] elementos = expressao.split(" ");
        
        for (int i = 0; i < elementos.length; i++) 
        {
            String e = elementos[i];
            
            if ("and".equals(e) || "or".equals(e))
                operadores.push(e);
            else
                operandos.push(e);
        }

        int qtd = 0;
        
        
        List<String> listaOperando = new ArrayList<>();
        while (!operandos.isEmpty()) {
            listaOperando.add(operandos.pop());
        }
       
        
        for (int i = 0; i < listaOperando.size()-1; i++) {
            
            String oper = operadores.pop();
        
            switch (oper) {
            case "and":
                if(Boolean.valueOf(listaOperando.get(i)) && Boolean.valueOf(listaOperando.get(i+1)))
                    qtd++;
                break;
            case "or":
                if(Boolean.valueOf(listaOperando.get(i)) || Boolean.valueOf(listaOperando.get(i+1)))
                    qtd++;
                break;
    
            default:
                break;
            }
        }
        
        return qtd;
    }

}
