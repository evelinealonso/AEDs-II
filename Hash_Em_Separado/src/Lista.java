import java.util.NoSuchElementException;

public class Lista<E> {

	private Celula<E> primeiro;
	private Celula<E> ultimo;
	private int tamanho;
	
	public Lista() {
		
		Celula<E> sentinela = new Celula<>();
		
		this.primeiro = this.ultimo = sentinela;
		this.tamanho = 0;
	}
	
	public boolean vazia() {
		
		return (this.primeiro == this.ultimo);
	}
	
	public void inserir(E novo, int posicao) {
		
		Celula<E> anterior, novaCelula, proximaCelula;
		
		if ((posicao < 0) || (posicao > this.tamanho))
			throw new IndexOutOfBoundsException("Não foi possível inserir o item na lista: "
					+ "a posição informada é inválida!");
		
		anterior = this.primeiro;
		for (int i = 0; i < posicao; i++)
			anterior = anterior.getProximo();
				
		novaCelula = new Celula<>(novo);
			
		proximaCelula = anterior.getProximo();
			
		anterior.setProximo(novaCelula);
		novaCelula.setProximo(proximaCelula);
			
		if (posicao == this.tamanho)  // a inserção ocorreu na última posição da lista
			this.ultimo = novaCelula;
			
		this.tamanho++;		
	}
	
	public void inserirFinal(E novo) {
		
		Celula<E> novaCelula = new Celula<>(novo);
		
		this.ultimo.setProximo(novaCelula);
		this.ultimo = novaCelula;
		
		this.tamanho++;
	}
	
	private E removerProxima(Celula<E> anterior) {
		
		Celula<E> celulaRemovida, proximaCelula;
		
		celulaRemovida = anterior.getProximo();
		
		proximaCelula = celulaRemovida.getProximo();
				
		anterior.setProximo(proximaCelula);
		celulaRemovida.setProximo(null);
				
		if (celulaRemovida == this.ultimo)
			this.ultimo = anterior;
				
		this.tamanho--;
				
		return (celulaRemovida.getItem());	
	}
	
	public E remover(int posicao) {
		
		Celula<E> anterior;
		
		if (vazia())
			throw new IllegalStateException("Não foi possível remover o item da lista: "
					+ "a lista está vazia!");
		
		if ((posicao < 0) || (posicao >= this.tamanho ))
			throw new IndexOutOfBoundsException("Não foi possível remover o item da lista: "
					+ "a posição informada é inválida!");
			
		anterior = this.primeiro;
		for (int i = 0; i < posicao; i++)
			anterior = anterior.getProximo();
				
		return (removerProxima(anterior));
	}
	
	public E remover(E elemento) {
		
		Celula<E> anterior;
		
		if (vazia())
			throw new IllegalStateException("Não foi possível remover o item da lista: "
					+ "a lista está vazia!");
		
		anterior = this.primeiro;
		while ((anterior.getProximo() != null) && !(anterior.getProximo().getItem().equals(elemento)))
			anterior = anterior.getProximo();
		
		if (anterior.getProximo() == null)
			throw new NoSuchElementException("Item não encontrado!");
		else {
			return (removerProxima(anterior));
		}
	}
	
	public E pesquisar(E procurado) {
		
		Celula<E> aux;
		
		aux = this.primeiro.getProximo();
		
		while (aux != null) {
			if (aux.getItem().equals(procurado))
				return aux.getItem();
			aux = aux.getProximo();
		}
		
		throw new NoSuchElementException("Item não encontrado!");
	}
	
	public void imprimir() {
		
		Celula<E> aux;
		
		aux = this.primeiro.getProximo();
		
		while (aux != null) {
			System.out.println(aux.getItem());
			aux = aux.getProximo();
		}
	}
}
