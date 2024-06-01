public class Celula<K, V> {

	private final K chave;
	private final V item;
	private Celula<K, V> proximo;

	public Celula() {
		this.chave = null;
		this.item = null;
		setProximo(null);
	}

	public Celula(K chave, V item) {
		this.chave = chave;
		this.item = item;
		setProximo(null);
	}

	public Celula(K chave, V item, Celula<K, V> proximo) {
		this.chave = chave;
        this.item = item;
        this.proximo = proximo;
    }
	
	public K getChave() {
		return chave;
	}
	
	public V getItem() {
		return item;
	}

	public Celula<K, V> getProximo() {
		return proximo;
	}

	public void setProximo(Celula<K, V> proximo) {
		this.proximo = proximo;
	}
}
