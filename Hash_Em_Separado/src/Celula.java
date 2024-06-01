public class Celula<K, T> {

	private final K chave;
	private final T item;
	private Celula<K, T> proximo;

	public Celula() {
		this.chave = null;
		this.item = null;
		setProximo(null);
	}

	public Celula(K chave, T item) {
		this.chave = chave;
		this.item = item;
		setProximo(null);
	}

	public Celula(K chave, T item, Celula<K, T> proximo) {
		this.chave = chave;
        this.item = item;
        this.proximo = proximo;
    }
	
	public K getChave() {
		return chave;
	}
	
	public T getItem() {
		return item;
	}

	public Celula<K, T> getProximo() {
		return proximo;
	}

	public void setProximo(Celula<K, T> proximo) {
		this.proximo = proximo;
	}
}
