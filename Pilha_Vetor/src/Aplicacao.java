public class Aplicacao {

	public static void main(String[] args) {
		
		try {
			Carta carta = new Carta("COPAS", "AS");
		
			System.out.println(carta.getNaipe());
			System.out.println(carta.getValor());
		} catch (Exception excecao) {
			System.out.println(excecao.getMessage());
		}
	}
}
