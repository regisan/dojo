function converte(descricao) {
	
	unidades = new Map()
	unidades.set("um", 1)
	unidades.set("dois", 2)
	unidades.set("três", 3)
	unidades.set("quatro", 4)
	unidades.set("cinco", 5)
	unidades.set("seis", 6)
	unidades.set("sete", 7)
	unidades.set("oito", 8)
	unidades.set("nove", 9)
	unidades.set("dez", 10)
	unidades.set("onze", 11)
	unidades.set("doze", 12)
	unidades.set("treze", 13)
	unidades.set("quatorze", 14)
	unidades.set("quinze", 15)
	unidades.set("vinte", 20)
	unidades.set("trinta", 30)
	unidades.set("quarenta", 40)
	unidades.set("cinquenta", 50)
	unidades.set("cem", 100)
	unidades.set("cento", 100)
	
	valorAux = (new String(descricao)).toLowerCase();
	centavos = valorAux.substring(0, valorAux.search(" centavo"))
	valoresCentavos = centavos.split(" e ", -1)
	reais = valorAux.substring(0, valorAux.search(" rea"))
	valoresReais = reais.split(" e ", -1)
	
	valorCentavos = 0;
	valorReais = 0;
	for (var int = 0; int < valoresReais.length; int++) {
		valorReais += unidades.get(valoresReais[int])
	}
		
	for (var int = 0; int < valoresCentavos.length; int++) {
		valorCentavos += unidades.get(valoresCentavos[int])
	}
	
	if (isNaN(valorReais))
		valorReais = 0;

	if (isNaN(valorCentavos))
		valorCentavos = 0;
	
	if (valorCentavos >= 10)
		valorNumerico = valorReais + "," + valorCentavos
	else
		valorNumerico = valorReais + ",0" + valorCentavos
	
	return valorNumerico;
};
 