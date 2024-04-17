import java.util.NoSuchElementException;

public class Pilha<E> {

	private Celula<E> topo;
	private Celula<E> fundo;

	public Pilha() {

		Celula<E> sentinela = new Celula<E>();
		fundo = sentinela;
		topo = sentinela;

	}

	public boolean pilhaVazia() {
		return fundo == topo;
	}

	public void empilhar(E item) {

		Celula<E> novaCelula = new Celula<E>(item);
		novaCelula.setProximo(topo);
		topo = novaCelula;

	}

	public E desempilhar() {

		if (pilhaVazia()) {
			throw new NoSuchElementException("Nao foi possível desempilhar "
					+ "o item: a pilha está vazia!");
		}

		E desempilhado = topo.getItem();
		topo = topo.getProximo();
		return desempilhado;

	}

	public E consultarTopo() {

		if (pilhaVazia()) {
			throw new NoSuchElementException("Nao há nenhum item na pilha!");

		}

		return topo.getItem();

	}

}