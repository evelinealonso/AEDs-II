public class No<T> {

	private T item;        // contém os dados do item armazenado no nodo da árvore.
	private No<T> direita;    // referência ao nodo armazenado, na árvore, à direita do nó em questão.
	private No<T> esquerda;   // referência ao nodo armazenado, na árvore, à esquerda do nó em questão.

	public No() {
		this.setItem(null);
	    this.setDireita(null);
	    this.setEsquerda(null);
	}
	
	public No(T item) {
		this.setItem(item);
	    this.setDireita(null);
	    this.setEsquerda(null);
	}

	public No(T item, No<T> esquerda, No<T> direita) {
		this.setItem(item);
	    this.setDireita(direita);
	    this.setEsquerda(esquerda);
	}

	public T getItem() {
		return this.item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public No<T> getDireita() {
		return this.direita;
	}

	public void setDireita(No<T> direita) {
		this.direita = direita;
	}

	public No<T> getEsquerda() {
		return this.esquerda;
	}

	public void setEsquerda(No<T> esquerda) {
		this.esquerda = esquerda;
	}
}
