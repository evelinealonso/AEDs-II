public class Celula<T> {

	private final T item;
	private Celula<T> proximo;

	public Celula() {
		this.item = null;
		setProximo(null);
	}

	public Celula(T item) {
		this.item = item;
		setProximo(null);
	}

	public Celula(T item, Celula<T> proximo) {
        this.item = item;
        this.proximo = proximo;
    }
	
	public T getItem() {
		return item;
	}

	public Celula<T> getProximo() {
		return proximo;
	}

	public void setProximo(Celula<T> proximo) {
		this.proximo = proximo;
	}
}
