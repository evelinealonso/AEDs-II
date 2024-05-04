import java.util.NoSuchElementException;

public class Fila<E> {

	private final E[] fila;
	private int frente;
	private int tras;
	
	Fila(int tamanho) {
		
		fila = (E[]) new Object[tamanho];
		frente = tras = 0;
	}
	
	public boolean cheia() {
		
		return (obterIndice(tras + 1)  == obterIndice(frente));
	}
	
	public boolean vazia() {
		
		return (frente == tras);
	}
	
	private int obterIndice (int valor) {
	
		return (valor % fila.length);
	}
	
	public void enfileirar(E item) {
		
		if (cheia()) {
			throw new IllegalStateException ("Erro ao tentar enfileirar um item. "
					+ "A fila está cheia!");
		}
		fila[obterIndice(tras)] = item;
		tras++;	
	}
	
	public E desenfileirar() {
		
		E item = consultarPrimeiro();
		frente++;
			
		return item;
	}
	
	public E consultarPrimeiro() {

		if (vazia()) {
			throw new NoSuchElementException("Nao há nenhum item na pilha!");
		}

		return fila[obterIndice(frente)];

	}
	
	public void imprimir() {
		
		int posicao;
		
		if (vazia())
			System.out.println("A fila está vazia!");
		else 
			for (int i = this.frente; i < this.tras; i++) {
				posicao = obterIndice(i);
				System.out.println(fila[posicao]);
			}
	}
}
