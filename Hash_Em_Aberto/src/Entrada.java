import java.util.Objects;

public class Entrada<K, V> {

	private final K chave;
	private V valor;
	private boolean isRemovida;
	
	public Entrada(K chave, V item) {
		this.chave = chave;
		this.valor = item;
		this.setRemovida(false);
	}

	public K getChave() {
		return chave;
	}
	
	public V getValor() {
		return valor;
	}
	
	public void setValor(V valor) {
		this.valor = valor;
	}
	
	public boolean isRemovida() {
		return isRemovida;
	}

	public void setRemovida(boolean isRemovida) {
		this.isRemovida = isRemovida;
	}

	@Override
	public boolean equals(Object outroObjeto) {
		
		Entrada<K, V> outraEntrada;
		
		if (this == outroObjeto) return true;
		else if (outroObjeto == null || ! (outroObjeto.getClass() == this.getClass())) return false;
		else {
			outraEntrada = (Entrada<K, V>) outroObjeto;
			return (outraEntrada.getChave().equals(this.chave));
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.chave);
	}
	
	@Override
	public String toString() {
		return (this.chave + "\n" + this.valor);
	}
}
