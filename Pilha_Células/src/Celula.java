public class Celula<T> {

	private T item;
	private Celula<T> proximo;

	public Celula() {
		this(null);
	}

	public Celula(T item) {
		setItem(item);
		setProximo(null);
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public Celula<T> getProximo() {
		return proximo;
	}

	public void setProximo(Celula<T> proximo) {
		this.proximo = proximo;
	}
}
