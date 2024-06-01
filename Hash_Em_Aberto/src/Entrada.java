public class Entrada<K, V> {

	private final K chave;
	private final V item;
	private boolean isRemovida;

	public Entrada(K chave, V item) {
		this.chave = chave;
		this.item = item;
		this.setRemovida(false);
	}

	public K getChave() {
		return chave;
	}
	
	public V getItem() {
		return item;
	}

	public boolean isRemovida() {
		return isRemovida;
	}

	public void setRemovida(boolean isRemovida) {
		this.isRemovida = isRemovida;
	}
}
