package com.tr.dojo;

public class Partida {
    
    private String mandante;
    private String visitante;
    private int placarVisitante;
    private int placarMandante;

    Partida(String mandante, int placarMandante, String visitante, int placarVisitante){
        this.mandante = mandante;
        this.visitante = visitante;
        this.placarMandante = placarMandante;
        this.placarVisitante = placarVisitante;
    }

    public String getMandante() {
        return mandante;
    }

    public String getVisitante() {
        return visitante;
    }

    public int getPlacarVisitante() {
        return placarVisitante;
    }

    public int getPlacarMandante() {
        return placarMandante;
    }
    
    
}
