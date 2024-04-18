public class Aplicacao {

	public static void main(String[] args) {

		Pilha<Carta> minhaPilha = new Pilha<Carta>();
		Carta item, desempilhado;

		item = new Carta("COPAS", "AS");
		minhaPilha.empilhar(item);

		item = new Carta("ESPADAS", "DEZ");
		minhaPilha.empilhar(item);

		item = new Carta("OUROS", "NOVE");
		minhaPilha.empilhar(item);

		desempilhado = minhaPilha.desempilhar();
		System.out.println("Item desempilhado: " + desempilhado.getNaipe()
				+ ", " + desempilhado.getValor()); // OUROS, NOVE

		item = minhaPilha.consultarTopo();
		System.out.println("Item do topo: " + item.getNaipe() + ", "
				+ item.getValor()); // ESPADA, DEZ

	}
}
