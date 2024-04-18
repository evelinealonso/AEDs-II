import java.util.NoSuchElementException;

public class Pilha<E> {

	private Celula<E> topo = null;

	public boolean pilhaVazia() {
		return topo == null;
	}

	public void empilhar(E item) {
		topo = new Celula<E>(item, topo);
	}

	public E desempilhar() {

		E desempilhado = consultarTopo();
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