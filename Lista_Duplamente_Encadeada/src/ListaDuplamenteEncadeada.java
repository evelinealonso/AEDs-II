public class ListaDuplamenteEncadeada<E> {

	private Celula<E> primeiro;
	private Celula<E> ultimo;
	private int tamanho;
	
	public ListaDuplamenteEncadeada() {
		
		Celula<E> sentinela = new Celula<>();
		
		this.primeiro = this.ultimo = sentinela;
		this.tamanho = 0;
	}
	
	public boolean vazia() {
		
		return (this.primeiro == this.ultimo);
	}
	
	public void inserirFinal(E novo) {
		
		Celula<E> novaCelula = new Celula<>(novo, this.ultimo, null);
		
		this.ultimo.setProximo(novaCelula);	
		this.ultimo = novaCelula;
		
		this.tamanho++;
		
	}
	
	public E removerFinal() {
		
		Celula<E> removida, penultima;
		
		if (vazia())
			throw new IllegalStateException("Não foi possível remover o último item da lista: "
					+ "a lista está vazia!");

		removida = this.ultimo;
			
		penultima = this.ultimo.getAnterior();
		penultima.setProximo(null);
		
		removida.setAnterior(null);
			
		this.ultimo = penultima;
			
		this.tamanho--;
			
		return (removida.getItem());
	}
}
