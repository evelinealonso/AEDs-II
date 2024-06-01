import java.util.NoSuchElementException;

public class Lista<K, V> {

	private Celula<K, V> primeiro;
	private Celula<K, V> ultimo;
	private int tamanho;
	
	public Lista() {
		
		Celula<K, V> sentinela = new Celula<>();
		
		this.primeiro = this.ultimo = sentinela;
		this.tamanho = 0;
	}
	
	public boolean vazia() {
		
		return (this.primeiro == this.ultimo);
	}
	
	public void inserir(K chave, V novo, int posicao) {
		
		Celula<K, V> anterior, novaCelula, proximaCelula;
		
		if ((posicao < 0) || (posicao > this.tamanho))
			throw new IndexOutOfBoundsException("Não foi possível inserir o item na lista: "
					+ "a posição informada é inválida!");
		
		anterior = this.primeiro;
		for (int i = 0; i < posicao; i++)
			anterior = anterior.getProximo();
				
		novaCelula = new Celula<>(chave, novo);
			
		proximaCelula = anterior.getProximo();
			
		anterior.setProximo(novaCelula);
		novaCelula.setProximo(proximaCelula);
			
		if (posicao == this.tamanho)  // a inserção ocorreu na última posição da lista
			this.ultimo = novaCelula;
			
		this.tamanho++;		
	}
	
	public void inserirFinal(K chave, V novo) {
		
		Celula<K, V> novaCelula = new Celula<>(chave, novo);
		
		this.ultimo.setProximo(novaCelula);
		this.ultimo = novaCelula;
		
		this.tamanho++;
	}
	
	private V removerProxima(Celula<K, V> anterior) {
		
		Celula<K, V> celulaRemovida, proximaCelula;
		
		celulaRemovida = anterior.getProximo();
		
		proximaCelula = celulaRemovida.getProximo();
				
		anterior.setProximo(proximaCelula);
		celulaRemovida.setProximo(null);
				
		if (celulaRemovida == this.ultimo)
			this.ultimo = anterior;
				
		this.tamanho--;
				
		return (celulaRemovida.getItem());	
	}
	
	public V remover(int posicao) {
		
		Celula<K, V> anterior;
		
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
	
	public V remover(K chave) {
		
		Celula<K, V> anterior;
		
		if (vazia())
			throw new IllegalStateException("Não foi possível remover o item da lista: "
					+ "a lista está vazia!");
		
		anterior = this.primeiro;
		while ((anterior.getProximo() != null) && !(anterior.getProximo().getChave().equals(chave)))
			anterior = anterior.getProximo();
		
		if (anterior.getProximo() == null)
			throw new NoSuchElementException("Item não encontrado!");
		else {
			return (removerProxima(anterior));
		}
	}
	
	public V pesquisar(K procurado) {
		
		Celula<K, V> aux;
		
		aux = this.primeiro.getProximo();
		
		while (aux != null) {
			if (aux.getChave().equals(procurado))
				return aux.getItem();
			aux = aux.getProximo();
		}
		
		throw new NoSuchElementException("Item não encontrado!");
	}
	
	public void imprimir() {
		
		Celula<K, V> aux;
		
		aux = this.primeiro.getProximo();
		
		while (aux != null) {
			System.out.println(aux.getItem());
			aux = aux.getProximo();
		}
	}
}
