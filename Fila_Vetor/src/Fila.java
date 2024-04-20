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
		
		return (((tras + 1) % fila.length) == (frente % fila.length));
	}
	
	public boolean vazia() {
		
		return (frente == tras);
	}
	
	public void enfileirar(E item) {
		
		if (cheia()) {
			throw new IllegalStateException ("Erro ao tentar enfileirar um item. "
					+ "A fila está cheia!");
		}
		fila[tras % fila.length] = item;
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

		return fila[frente % fila.length];

	}

}
