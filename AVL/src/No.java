public class No<T extends Comparable<T>> {

	private T item;        // contém os dados do item armazenado no nodo da árvore.
	private No<T> direita;    // referência ao nodo armazenado, na árvore, à direita do nó em questão.
	private No<T> esquerda;   // referência ao nodo armazenado, na árvore, à esquerda do nó em questão.
	private int altura;
	
	public No() {
		this.setItem(null);
	    this.setDireita(null);
	    this.setEsquerda(null);
	    this.altura = 0;
	}
	
	public No(T item) {
		this.setItem(item);
	    this.setDireita(null);
	    this.setEsquerda(null);
	    this.altura = 0;
	}

	public No(T item, No<T> esquerda, No<T> direita) {
		this.setItem(item);
	    this.setDireita(direita);
	    this.setEsquerda(esquerda);
	    this.altura = 0;
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
	
	private int getAltura(No<T> no) {
		
		if (no != null)
			return no.getAltura();
		else
			return -1;
	}
	
	public int getAltura() {
		return this.altura;
	}

	public void setAltura() {
		
		int alturaEsquerda, alturaDireita;
		
		alturaEsquerda = getAltura(this.esquerda);
		alturaDireita = getAltura(this.direita);
		
		if (alturaEsquerda > alturaDireita)
			this.altura = alturaEsquerda + 1;
		else
			this.altura = alturaDireita + 1;
	}
	
	public int getFatorBalanceamento() {
		
		int alturaEsquerda, alturaDireita;
		
		alturaEsquerda = getAltura(this.esquerda);
		alturaDireita = getAltura(this.direita);
		
		return (alturaEsquerda - alturaDireita);
	}
}