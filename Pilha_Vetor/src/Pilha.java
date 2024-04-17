
public class Pilha<E> {

	private E[] pilha;
	private int topo;

	public Pilha(int tamanho) {

		pilha = (E[]) new Object[tamanho];
		topo = 0;

	}

	public boolean pilhaVazia() {
		return topo == 0;
	}

	private boolean pilhaCheia() {
		return topo == pilha.length;
	}

	public void empilhar(E item) throws Exception {

		if (pilhaCheia()) {
			throw new Exception("Nao foi possivel empilhar "
					+ "o item: a pilha está cheia!");
		}

		pilha[topo] = item;
		topo++;

	}

	public E desempilhar() throws Exception {

		if (pilhaVazia()) {
			throw new Exception("Nao foi possivel desempilhar "
					+ "o item: a pilha está vazia!");
		}

		topo--;
		return pilha[topo];

	}

	public E consultarTopo() throws Exception {

		if (pilhaVazia()) {
			throw new Exception("Nao há nenhum item na pilha!");
		}

		return pilha[topo - 1];

	}

}