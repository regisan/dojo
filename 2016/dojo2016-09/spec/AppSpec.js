describe("Lendo um cheque", function(){
    it("Unidade centavos", function() {
        expect(converte("um centavo")).toEqual("0,01");
        expect(converte("dois centavos")).toEqual("0,02");
        expect(converte("dez centavos")).toEqual("0,10");
        expect(converte("vinte e um centavos")).toEqual("0,21");
        expect(converte("onze centavos")).toEqual("0,11");
    });
    
    it("Unidade reais", function() {
        expect(converte("um real")).toEqual("1,00");
        expect(converte("dois reais")).toEqual("2,00");
        expect(converte("dez reais")).toEqual("10,00");
        expect(converte("vinte e quatro reais")).toEqual("24,00");
        expect(converte("cem reais")).toEqual("100,00");
        expect(converte("cento e vinte e nove reais")).toEqual("129,00");
    });
    
    it("Unidade reais e centavos", function() {
        expect(converte("um real e um centavo")).toEqual("1,01");
        expect(converte("dois reais e dois centavos")).toEqual("2,02");
    });
    
});
