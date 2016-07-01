function jokenpo(mao1, mao2) {
	
	var simbolo = ["pedra","papel","tesoura"];
	
	if (mao1 === "" || mao2 === "")
		return "erro";
	
	if (simbolo.indexOf(mao1) === -1 || simbolo.indexOf(mao2) === -1)
	  return "invalido";

	if (mao1 === mao2)
		return "empate";	
	
	var result = "";
		
	switch (mao1) {
	case "pedra":
		result = mao2 === "papel" ? mao2 : mao1;
		break;
	case "papel":
		result = mao2 === "pedra" ? mao1 : mao2;
		break;
	case "tesoura":
		result = mao2 === "papel" ? mao1 : mao2;
		break;
	default:
		break;
	}
	
	return result;
};
 