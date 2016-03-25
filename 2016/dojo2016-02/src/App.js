var NOTAS = [10, 20, 50, 100];

function Caixa(qtd10, qtd20, qtd50, qtd100) {

    this.cofre = [qtd10, qtd20, qtd50, qtd100];

    this.isEmpty = function() {
        for (var i = 0; i < this.cofre.length; i++)
            if (this.cofre[i] !== 0)
                return false;

        return true;
    };

    this.getTotal = function() {
        var sum = 0;
        for (var i = 0; i < this.cofre.length; i++) {
            sum += this.cofre[i] * NOTAS[i];
        }

        return sum;
    }

    this.getMoney = function(idx, qtde) {
        if (this.cofre[idx] >= qtde) {
            return this.cofre[idx] -= qtde;
        }
        else {
            // nao ha notas suficientes
            var disponivel = this.cofre[idx];
            this.cofre[idx] = 0;
            return disponivel - qtde;
        }
    }
};

function sacar(valor) {
    var cx = new Caixa(10,10,10,10); // total do caixa = R$ 1800
    return calcular(cx, valor, [0, 0, 0, 0], NOTAS.length - 1);
};

function calcular(cx, valor, notasRetornadas, idx) {

    if (cx.isEmpty() && valor > 0)
        throw new Error("Caixa sem dinheiro");

    if (valor > cx.getTotal())
        throw new Error("Caixa sem dinheiro suficiente");

    if (valor == 0) {
        return notasRetornadas;
    }
    else {
        var qtdeNotasNecessarias = parseInt(valor / NOTAS[idx]);

        if (qtdeNotasNecessarias >= 1) {
            var saldo = cx.getMoney(idx, qtdeNotasNecessarias);

            if (saldo >= 0) {
                notasRetornadas[idx] = qtdeNotasNecessarias;
            }
            else {
                notasRetornadas[idx] = qtdeNotasNecessarias + saldo;
                var resto = valor % NOTAS[idx];
                var vlrPendente = (NOTAS[idx] * saldo * - 1) + resto;
                return calcular(cx, vlrPendente, notasRetornadas, --idx);
            }
        }

        return calcular(cx, parseInt(valor % NOTAS[idx]), notasRetornadas, --idx);
    }
};

