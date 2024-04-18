public class Carta {

	private NaipeEnum naipe;
	private ValorCartaEnum valor;

	public Carta(NaipeEnum naipe, ValorCartaEnum valor) {
		setNaipe(naipe);
		setValor(valor);
	}

	public Carta(String naipe, String valor) {

		try {
			setNaipe(NaipeEnum.valueOf(naipe));
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("O naipe informado não é válido: " + naipe);
		}

		try {
			setValor(ValorCartaEnum.valueOf(valor));
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("O valor informado não é válido: " + valor);
		}

	}

	public NaipeEnum getNaipe() {
		return naipe;
	}

	public void setNaipe(NaipeEnum naipe) {
		this.naipe = naipe;
	}

	public ValorCartaEnum getValor() {
		return valor;
	}

	public void setValor(ValorCartaEnum valor) {
		this.valor = valor;
	}

}
