public class Entrada<K, V> {

	private K chave;
	private V item;
	private boolean isRemovida;

	public Entrada(K chave, V item) {
		this.chave = chave;
		this.item = item;
		this.setRemovida(false);
	}

	public K getChave() {
		return chave;
	}
	
	public void setChave(K chave) {
		this.chave = chave;
	}
	
	public V getItem() {
		return item;
	}
	
	public void setItem(V item) {
		this.item = item;
	}
	
	public boolean isRemovida() {
		return isRemovida;
	}

	public void setRemovida(boolean isRemovida) {
		this.isRemovida = isRemovida;
	}
}
