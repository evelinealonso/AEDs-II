import java.util.NoSuchElementException;

public class Pilha<E> {

	private final E[] pilha;
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

	public void empilhar(E item) {

		if (pilhaCheia()) {
			throw new IllegalStateException("Nao foi possivel empilhar "
					+ "o item: a pilha está cheia!");
		}

		pilha[topo] = item;
		topo++;

	}

	public E desempilhar() {

		if (pilhaVazia()) {
			throw new NoSuchElementException("Nao foi possivel desempilhar "
					+ "o item: a pilha está vazia!");
		}

		topo--;
		return pilha[topo];

	}

	public E consultarTopo() {

		if (pilhaVazia()) {
			throw new NoSuchElementException("Nao há nenhum item na pilha!");
		}

		return pilha[topo - 1];

	}

}