describe("Jokenpo", function(){
    it("should be papel", function() {
        expect(jokenpo("pedra", "papel")).toEqual("papel");
        expect(jokenpo("papel", "pedra")).toEqual("papel");
    });
    
    it("should be tesoura", function() {
        expect(jokenpo("tesoura", "papel")).toEqual("tesoura");
        expect(jokenpo("papel", "tesoura")).toEqual("tesoura");
    });
    
    it("should be pedra", function() {
        expect(jokenpo("pedra", "tesoura")).toEqual("pedra");
        expect(jokenpo("tesoura", "pedra")).toEqual("pedra");
    });
    
    it("should be empate", function() {
        expect(jokenpo("pedra", "pedra")).toEqual("empate");
        expect(jokenpo("papel", "papel")).toEqual("empate");
        expect(jokenpo("tesoura", "tesoura")).toEqual("empate");
    });
    
    it("should be invalido", function() {
        expect(jokenpo("web", "pedra")).toEqual("invalido");
        expect(jokenpo("papel", "web")).toEqual("invalido");
        expect(jokenpo("web", "web")).toEqual("invalido");
    });

    it("should be erro", function() {
        expect(jokenpo("", "pedra")).toEqual("erro");
        expect(jokenpo("papel", "")).toEqual("erro");
        expect(jokenpo("", "")).toEqual("erro");
    });

});
