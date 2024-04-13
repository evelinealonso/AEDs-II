public class Carta {

	private String naipe;
	private String valor;
	
	public Carta(String naipe, String valor) throws Exception {
		
		setNaipe(naipe);
		setValor(valor);	
	}

	public String getNaipe() {
		return naipe;
	}

	public void setNaipe(String naipe) throws Exception{
		
		Boolean ehValido = false;
		
		for (NaipeEnum naipeOpcoes: NaipeEnum.values()) {
			if (naipe.equals(naipeOpcoes.toString())) {
				this.naipe = naipe;
				ehValido = true;
				break;
			}
		}
		
		if (! ehValido)
			throw new Exception("O naipe informado é inválido!");
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) throws Exception {
		
		Boolean ehValido = false;
		
		for (ValorCartaEnum valorOpcoes: ValorCartaEnum.values()) {
			if (valor.equals(valorOpcoes.toString())) {
				this.valor = valor;
				ehValido = true;
				break;
			}
		}
		
		if (! ehValido)
			throw new Exception("O valor informado para a carta é inválido!");

	}
}
