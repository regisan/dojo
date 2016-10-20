package com.tr.dojo;

public class ResultadoPartida {
    
    private Partida p1;
    private Partida p2;
    
    public ResultadoPartida(Partida p1, Partida p2){
        this.p1 = p1;
        this.p2 = p2;
    }
    
    public String analisar() {
        
        int somaPlacarTime1 = p1.getPlacarMandante() + p2.getPlacarVisitante();
        int somaPlacarTime2 = p1.getPlacarVisitante() + p2.getPlacarMandante();
        
        if (somaPlacarTime1 > somaPlacarTime2) {
            return p1.getMandante();
        }
        else if (somaPlacarTime1 < somaPlacarTime2) {
            return p1.getVisitante();
        }
        else {
            if(p1.getPlacarVisitante() == p2.getPlacarVisitante()) {
                return "Penalti";    
            }
            else{
                return buscarVencedorSaldoDegols();
            }
        }
    }
    
    private String buscarVencedorSaldoDegols(){
        if (p1.getPlacarVisitante() > p2.getPlacarVisitante()) {
            return p1.getVisitante();
        } 
        return p2.getVisitante();         
    }

}
