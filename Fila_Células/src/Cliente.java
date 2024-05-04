import java.time.LocalDateTime;

public class Cliente {

	private static int contador = 0;
	
	private final int codigo;
	private String nome;
	private LocalDateTime horarioChegada;
	
	Cliente(String nome, LocalDateTime horarioChegada) {
		this.codigo = contador++;
		this.nome = nome;
		this.horarioChegada = horarioChegada;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public LocalDateTime getHorarioChegada() {
		return horarioChegada;
	}
	
	public void setHorarioChegada(LocalDateTime horarioChegada) {
		this.horarioChegada = horarioChegada;
	}
	
	public String toString() {
		return ("Código: " + this.codigo + " Nome: " + this.nome + 
				" Horário de chegada: " + this.horarioChegada);
		
	}
}
