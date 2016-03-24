function saque(valor) {
    var notas = [10, 20, 50, 100];

    var nota10 = 0;
    var nota20 = 0;
    var nota50 = 0;
    var nota100 = 0;
    var valores = [];
    while (valor > 0) {
        if (valor >= 100) {
            nota100 = nota100 + 1;
            valor = valor - 100
        }
        else if (valor >= 50) {
            nota50 = nota50 + 1;
            valor = valor - 50
        }
        else if (valor >= 20) {
            nota20 = nota20 + 1;
            valor = valor - 20
        }
        else if (valor >= 10) {
            nota10 = nota10 + 1;
            valor = valor - 10
        }
    }
    return valores = [nota10,nota20,nota50,nota100];
}