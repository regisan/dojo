describe("Caixa Eletronico", function(){
    it("should be 10 reais", function(){
        expect(sacar(10)).toEqual([1,0,0,0]);
    });

    it("should throw an error because it does not have enough money", function() {
        expect(function() {sacar(5000);}).toThrow(new Error("Caixa sem dinheiro suficiente"));
    });

    it("should be 20 reais", function() {
        expect(sacar(20)).toEqual([0,1,0,0]);
    });

    it("should be 50 reais", function() {
        expect(sacar(50)).toEqual([0,0,1,0]);
    });

    it("should be 100 reais", function() {
        expect(sacar(100)).toEqual([0,0,0,1]);
    });

    it("should be 30 reais", function() {
        expect(sacar(30)).toEqual([1,1,0,0]);
    });

    it("should be 880 reais", function() {
        expect(sacar(880)).toEqual([1,1,1,8]);
    });

    it("should be 40 reais", function() {
        expect(sacar(40)).toEqual([0,2,0,0]);
    });

    it("should be 60 reais", function() {
        expect(sacar(60)).toEqual([1,0,1,0]);
    });

    it("should be 1100 reais (10 x R$ 100 and 2 x R$ 50)", function() {
        expect(sacar(1100)).toEqual([0,0,2,10]);
    });

    it("should be 1600 reais (10 x R$ 100 and 10 x R$ 50 and 5 x R$ 20)", function() {
        expect(sacar(1600)).toEqual([0,5,10,10]);
    });

    it("should be 1710 reais (10 x R$ 100 and 10 x R$ 50 and 10 x R$ 20 and 1 x R$ 10)", function() {
        expect(sacar(1710)).toEqual([1,10,10,10]);
    });

    it("should be limpar o caixa", function() {
        expect(sacar(1800)).toEqual([10,10,10,10]);
    });
});

describe("Calcular notas do saque", function() {

    var notasRetornadas;
    var cx;

    beforeEach(function() {
        notasRetornadas = [0, 0, 0, 0];
        cx = new Caixa(10,10,10,10);
    })

    it("should be 10 reais", function() {
        var valor = 10;
        expect(calcular(cx, valor, notasRetornadas, NOTAS.length - 1)).toEqual([1,0,0,0]);
    });

    it("should be 20 reais", function() {
        var valor = 20;
        expect(calcular(cx, valor, notasRetornadas, NOTAS.length - 1)).toEqual([0,1,0,0]);
    });

    it("should be 50 reais", function() {
        var valor = 50;
        expect(calcular(cx, valor, notasRetornadas, NOTAS.length - 1)).toEqual([0,0,1,0]);
    });

    it("should be 100 reais", function() {
        var valor = 100;
        expect(calcular(cx, valor, notasRetornadas, NOTAS.length - 1)).toEqual([0,0,0,1]);
    });

    it("should be 30 reais", function() {
        var valor = 30;
        expect(calcular(cx, valor, notasRetornadas, NOTAS.length - 1)).toEqual([1,1,0,0]);
    });

    it("should be 880 reais", function() {
        var valor = 880;
        expect(calcular(cx, valor, notasRetornadas, NOTAS.length - 1)).toEqual([1,1,1,8]);
    });

    it("should be 40 reais", function() {
        var valor = 40;
        expect(calcular(cx, valor, notasRetornadas, NOTAS.length - 1)).toEqual([0,2,0,0]);
    });

    it("should be 60 reais", function() {
        var valor = 60;
        expect(calcular(cx, valor, notasRetornadas, NOTAS.length - 1)).toEqual([1,0,1,0]);
    });
});

describe("Manipular cofre do caixa", function() {

    it("should is empty", function() {
        var c = new Caixa(0,0,0,0);
        expect(c.isEmpty()).toBeTruthy();
    });

    it("should not empty", function() {
        var c = new Caixa(1,0,0,0);
        expect(c.isEmpty()).toBeFalsy();
    });

    it("should be 150 no total", function() {
        var c = new Caixa(0,0,1,1);
        expect(c.getTotal()).toEqual(150);
    });

    it("should be 50 depois de sacar 100", function() {
        var c = new Caixa(0,0,1,1); // 150
        c.getMoney(3, 1);
        expect(c.getTotal()).toEqual(50);
    });

    it("should be 100 de saldo", function() {
        var c = new Caixa(0,0,1,1); // 150
        expect(c.getMoney(3, 5)).toEqual(-4);

    });

    it("should be -1 de saldo", function() {
        var c = new Caixa(0,0,0,10); // 1000
        expect(c.getMoney(3, 11)).toEqual(-1);

    });
});
