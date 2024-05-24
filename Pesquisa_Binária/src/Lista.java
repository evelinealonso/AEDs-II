import java.util.NoSuchElementException;

public class Lista<E extends Comparable<E>> {

	private final E[] lista;
	private final int primeiro;
	private int ultimo;
	
	@SuppressWarnings("unchecked")
	public Lista(int tamanho) {
		
		lista = (E[]) new Comparable[tamanho];
		this.primeiro = this.ultimo = 0;
	}
	
	public boolean vazia() {
		
		return (this.primeiro == this.ultimo);
	}
	
	public boolean cheia() {
		
		return (this.ultimo == this.lista.length); 
	}
	
	public void inserir(E novo, int posicao) {
		
		if (cheia())
			throw new IllegalStateException("Não foi possível inserir o item na lista: "
					+ "a lista está cheia!");

		if ((posicao < 0) || (posicao > this.ultimo)) 
			throw new IndexOutOfBoundsException ("Não foi possível inserir o item na lista: "
					+ "a posição informada é inválida!");
		
		for (int i = this.ultimo; i > posicao; i--)
			lista[i] = lista[i-1];
				
		lista[posicao] = novo;
				
		this.ultimo++;
	}
	
	public E remover(int posicao) {
		
		E removido;
		
		if (vazia())
			throw new IllegalStateException("Não foi possível remover o item da lista: "
					+ "a lista está vazia!");

		if ((posicao < 0) || (posicao >= this.ultimo))
			throw new IndexOutOfBoundsException ("Não foi possível remover o item da lista: "
					+ "a posição informada é inválida!");
			
		removido = lista[posicao];
		
		this.ultimo--;
				
		for (int i = posicao; i < this.ultimo; i++)
			lista[i] = lista[i+1];
				
		return removido;
	}
	
	public void ordenar() {
		quicksort(0, this.ultimo - 1);
	}
	
	/**
	* Algoritmo de ordenação Quicksort.
	* @param int esq: início da partição a ser ordenada
	* @param int dir: fim da partição a ser ordenada
	*/
	private void quicksort(int esq, int dir) {
				
		int part;
		if (esq < dir){
			part = particao(esq, dir);
			quicksort(esq, part - 1);
			quicksort(part + 1, dir);
		}
	}
					
	private int particao(int inicio, int fim) {
			
		E pivot = lista[fim];
		int part = inicio - 1;
		for (int i = inicio; i < fim; i++) {
			if (lista[i].compareTo(pivot) < 0) {
				part++;
				swap(part, i);
			}
		}
		part++;
		swap(part, fim);
		return (part);
	}
		
	private void swap(int i, int j) {
		      
		E temp = lista[i];
		lista[i] = lista[j];
		lista[j] = temp;
	}
	
	public void imprimir() {
		for (int i = this.primeiro; i < this.ultimo; i++)
			System.out.println(lista[i]);
	}
	
	public E pesquisar(E procurado) {
		
		return (pesquisar(this.primeiro, this.ultimo - 1, procurado));
	}
	
	private E pesquisar(int inicio, int fim, E procurado) {
		
		int meio, comparacao;
		
		if (inicio > fim)
			throw new NoSuchElementException("Item não encontrado!");
		
		meio = (inicio + fim)/2;
		comparacao = procurado.compareTo(lista[meio]);
		
		if (comparacao == 0)
			// encontrou!
			return lista[meio];
		else if (comparacao > 0)
			// buscar entre os maiores
			return pesquisar(meio + 1, fim, procurado);
		else
			// buscar entre os menores
			return pesquisar(inicio, meio - 1, procurado);
	}
}
