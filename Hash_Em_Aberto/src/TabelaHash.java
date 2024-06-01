import java.util.NoSuchElementException;

public class TabelaHash<K, V> {

	private Entrada<K, V>[] tabelaHash; 
	
	private int capacidade; /// tamanho da tabela hash.
	                        /// deve ser um número primo grande para diminuirmos a probabilidade de colisões.

	/// Construtor da classe.
	/// Esse método é responsável por inicializar a tabela hash que trabalha com endereçamento em aberto.
	/// Assim, esse método atribui, ao atributo capacidade, dessa classe, o valor passado por meio do parâmetro capacidade.
	/// Esse método também cria um vetor, de tamanho capacidade, de entradas; e o atribui ao atributo tabelaHash.
	/// Adicionalmente, cada posição do vetor é inicializada com null.
	/// Parâmetro "capacidade": tamanho da tabela hash. 
	@SuppressWarnings("unchecked")
	public TabelaHash(int capacidade) {
		
		this.capacidade = capacidade;
		this.tabelaHash = (Entrada<K, V>[]) new Entrada[this.capacidade]; 
		
		for (int i = 0; i < this.capacidade; i++)
			this.tabelaHash[i] = null;
	}
	
	/// Esse método implementa a função de transformação da tabela hash, 
	/// ou seja, calcula a posição, na tabela hash, em que o item,
	/// que possui a chave informada por meio do parâmetro chave, deve ser encontrado.
	/// A função de transformação utilizada corresponde ao resto da divisão do hashCode de chave pelo tamanho da tabela hash.
	/// Parâmetro "chave": chave da qual desejamos saber a posição na tabela hash.
	/// Retorna a posição que o item, cuja chave corresponde a que foi passada como parâmetro para esse método, 
	/// deve ocupar na tabela hash.
	private int funcaoHash(K chave, int tentativas) {
		return (Math.abs(chave.hashCode() % this.capacidade) + tentativas) % this.capacidade;
	}
	
	/// Método responsável por inserir um novo item na tabela hash.
	/// Não é permitido inserir, nessa tabela hash, mais de um item com uma mesma chave.
	/// Parâmetro "chave": chave do item que deve ser inserido na tabela hash.
	/// Parâmetro "item": referência ao item que deve ser inserido na tabela hash.
	/// Retorna a posição na tabela hash em que o novo item foi inserido.
	public int inserir(K chave, V item) {
		
		int tentativas = 0;
		int posicao = funcaoHash(chave, tentativas);
		boolean inseriu = false;
		
		while ((tentativas < this.capacidade) && !inseriu) {
			if ((this.tabelaHash[posicao] == null) || (this.tabelaHash[posicao].isRemovida())) {
				this.tabelaHash[posicao] = new Entrada<>(chave, item);
				inseriu = true;
			} else if (this.tabelaHash[posicao].getChave().equals(chave))
				throw new IllegalArgumentException("O item já havia sido inserido anteriormente na tabela hash!");
			else
				tentativas++;
			
			/// cálculo da posição da tabela hash em que o novo item deverá ser armazenado.
			posicao = funcaoHash(chave, tentativas);
		}
		
		if (inseriu)
			return posicao;
		else
			throw new IllegalStateException("A tabela hash está cheia: não foi possível inserir o novo elemento.");
	}
	
	/// Método responsável por localizar, na tabela hash, o item
	/// cuja chave corresponde à que foi passada como parâmetro para esse método.
	/// Parâmetro "chave": chave do item que deve ser localizado na tabela hash.
	/// Retorna uma referência ao item encontrado.
	/// O método lança uma exceção caso o item não tenha sido localizado na tabela hash.
	public V pesquisar(K chave) {
		
		int tentativas = 0;
		int posicao = funcaoHash(chave, tentativas);
		
		while (tentativas < this.capacidade) {
			if (this.tabelaHash[posicao] == null)
				throw new NoSuchElementException("Item não encontrado!");
			else if ((this.tabelaHash[posicao].getChave().equals(chave)) && !(this.tabelaHash[posicao].isRemovida()))
					return this.tabelaHash[posicao].getItem();
			else
				tentativas++;
				
			/// cálculo da posição da tabela hash em que o item deve estar armazenado.
			posicao = funcaoHash(chave, tentativas);	
		}
				
		throw new NoSuchElementException("Item não encontrado!");
	}
	
	/// Método responsável por remover, da tabela hash, o item
	/// cuja chave corresponde à que foi passada como parâmetro para esse método.
	/// Parâmetro "chave": chave do item que deve ser removido da tabela hash.
	/// Retorna uma referência ao item removido.
	/// O método lança uma exceção caso o item não tenha sido localizado na tabela hash.
	public V remover(K chave) {
		
		int tentativas = 0;
		int posicao = funcaoHash(chave, tentativas);
		
		while (tentativas < this.capacidade) {
			
			if (this.tabelaHash[posicao] == null)
				throw new NoSuchElementException("Item não encontrado!");
			else if ((this.tabelaHash[posicao].getChave().equals(chave)) && !(this.tabelaHash[posicao].isRemovida())) {
					this.tabelaHash[posicao].setRemovida(true);
					return this.tabelaHash[posicao].getItem();
			} else
				tentativas++;
				
			/// cálculo da posição da tabela hash em que o item deve estar armazenado.
			posicao = funcaoHash(chave, tentativas);	
		}
				
		throw new NoSuchElementException("Item não encontrado!");
	}
	
	/// Método responsável por imprimir todo o conteúdo da tabela hash.
	/// É impresso o índice da tabela hash e seu correspondente conteúdo.
	/// Se a posição da tabela hash estiver vazia, é impressa uma mensagem explicativa.
	/// Caso contrário, para todos os itens, armazenados na lista encadeada 
	/// associada a uma posição da tabela hash, são impressos seus dados.
	public void imprimir(){
	
		for (int i = 0; i < this.capacidade; i++) {
			System.out.println("Posição[" + i + "]: ");
			if ((this.tabelaHash[i] == null) || (this.tabelaHash[i].isRemovida()))
				System.out.println("vazia");
			else System.out.println(this.tabelaHash[i].getItem());
		}
	}
}
