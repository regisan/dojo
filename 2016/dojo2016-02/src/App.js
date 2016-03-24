function saque(valor) {

    var nota10 = 0;
    var nota20 = 0;
    var nota50 = 0;
    var nota100 = 0;

    while (valor > 0) {
        if (valor >= 100) {
            nota100++;
            valor -= 100;
        }
        else if (valor >= 50) {
            nota50++;
            valor -= 50;
        }
        else if (valor >= 20) {
            nota20++;
            valor -= 20;
        }
        else if (valor >= 10) {
            nota10++;
            valor -= 10;
        }
    }

    return [nota10,nota20,nota50,nota100];
}
