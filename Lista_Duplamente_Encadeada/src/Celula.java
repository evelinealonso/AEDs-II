public class Celula<T> {

	private final T item;
	private Celula<T> anterior;
	private Celula<T> proximo;

	public Celula() {
		this.item = null;
		setAnterior(null);
		setProximo(null);
	}

	public Celula(T item) {
		this.item = item;
		setAnterior(null);
		setProximo(null);
	}

	public Celula(T item, Celula<T> anterior, Celula<T> proximo) {
        this.item = item;
        this.anterior = anterior;
        this.proximo = proximo;
    }
	
	public T getItem() {
		return item;
	}

	public Celula<T> getAnterior() {
		return anterior;
	}

	public void setAnterior(Celula<T> anterior) {
		this.anterior = anterior;
	}
	
	public Celula<T> getProximo() {
		return proximo;
	}

	public void setProximo(Celula<T> proximo) {
		this.proximo = proximo;
	}
}