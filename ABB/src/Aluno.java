public class Aluno implements Comparable<Aluno> {

	private int numMatricula; // número de matrícula do aluno.
    private String nome;      // nome do aluno.
    private double nota;      // nota do aluno.
    
    /// Construtor da classe.
    /// Esse construtor cria um novo objeto da classe Aluno atribuindo a esse objeto os seguintes valores:
    /// - numMatricula recebe o valor que foi passado por meio do parâmetro matricula.
    /// - nome recebe o valor que foi passado por meio do parâmetro nome.
    /// - nota recebe o valor que foi passado por meio do parâmetro nota.
    public Aluno(int matricula, String nome, double nota) {
        this.numMatricula = matricula;
        this.nome = nome;
        this.nota = nota;
    }

    @Override
    public String toString() {
    	return ("Nome: " + this.nome + "\nNúmero de matrícula: " + this.numMatricula + "\nNota: " + this.nota);
    }
    
	/**
	 * @return the numMatricula
	 */
	public int getNumMatricula() {
		return this.numMatricula;
	}

	/**
	 * @param numMatricula the numMatricula to set
	 */
	public void setNumMatricula(int numMatricula) {
		this.numMatricula = numMatricula;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the nota
	 */
	public double getNota() {
		return this.nota;
	}

	/**
	 * @param nota the nota to set
	 */
	public void setNota(double nota) {
		this.nota = nota;
	}

	@Override
	public int compareTo(Aluno outroAluno) {
		
		return (this.nome.compareTo(outroAluno.getNome()));
	}
	
	@Override
	public boolean equals(Object outroObjeto) {
		
		Aluno outroAluno = (Aluno) outroObjeto;
		
		return (this.nome.equals(outroAluno.getNome()));
	}
}