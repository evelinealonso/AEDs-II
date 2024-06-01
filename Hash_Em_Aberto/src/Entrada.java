public class Entrada<K, T> {

	private final K chave;
	private final T item;
	private boolean isRemovida;

	public Entrada(K chave, T item) {
		this.chave = chave;
		this.item = item;
		this.setRemovida(false);
	}

	public K getChave() {
		return chave;
	}
	
	public T getItem() {
		return item;
	}

	public boolean isRemovida() {
		return isRemovida;
	}

	public void setRemovida(boolean isRemovida) {
		this.isRemovida = isRemovida;
	}
}
