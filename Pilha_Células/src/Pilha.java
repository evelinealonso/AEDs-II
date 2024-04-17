import java.util.NoSuchElementException;

public class Pilha<T> {

	private Celula<T> topo;
	private Celula<T> fundo;

	public Pilha() {

		Celula<T> sentinela = new Celula<T>();
		fundo = sentinela;
		topo = sentinela;

	}

	public boolean pilhaVazia() {
		return fundo == topo;
	}

	public void empilhar(T item) {

		Celula<T> novaCelula = new Celula<T>(item);
		novaCelula.setProximo(topo);
		topo = novaCelula;

	}

	public T desempilhar() {

		if (pilhaVazia()) {
			throw new NoSuchElementException("Nao foi possível desempilhar "
					+ "o item: a pilha está vazia!");
		}

		T desempilhado = topo.getItem();
		topo = topo.getProximo();
		return desempilhado;

	}

	public T consultarTopo() {

		if (pilhaVazia()) {
			throw new NoSuchElementException("Nao há nenhum item na pilha!");

		}

		return topo.getItem();

	}
}