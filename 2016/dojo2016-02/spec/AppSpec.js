describe("Caixa Eletronico", function() {

    it("should be 10 reais", function() {
        var valor = 10;
        expect(saque(valor)).toEqual([1,0,0,0]);
    });

    it("should be 20 reais", function() {
        var valor = 20;
        expect(saque(valor)).toEqual([0,1,0,0]);
    });

    it("should be 50 reais", function() {
        var valor = 50;
        expect(saque(valor)).toEqual([0,0,1,0]);
    });

    it("should be 100 reais", function() {
        var valor = 100;
        expect(saque(valor)).toEqual([0,0,0,1]);
    });

    it("should be 30 reais", function() {
        var valor = 30;
        expect(saque(valor)).toEqual([1,1,0,0]);
    });

    it("should be 880 reais", function() {
        var valor = 880;
        expect(saque(valor)).toEqual([1,1,1,8]);
    });

    it("should be 40 reais", function() {
        var valor = 40;
        expect(saque(valor)).toEqual([0,2,0,0]);
    });

    it("should be 60 reais", function() {
        var valor = 60;
        expect(saque(valor)).toEqual([1,0,1,0]);
    });
});
