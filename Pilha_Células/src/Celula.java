public class Celula<T> {

	private T item;
	private Celula<T> proximo;
	
	public Celula() {
		item = null;
		proximo = null;
	}
	
	public Celula(T item) {
		this.item = item;
		proximo = null;
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
