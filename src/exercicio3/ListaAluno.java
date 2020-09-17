package exercicio3;

public class ListaAluno {

	private Integer ra;
	private String nome;
	private String turma;
	private String semestre;
	private ListaAluno proximoAluno;
	
	public ListaAluno() {
	}
	
	public Integer getRA() {
		return ra;
	}
	
	public void setRA(Integer RA) {
		this.ra = RA;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String Nome) {
		this.nome = Nome;
	}
	
	public String getTurma() {
		return turma;
	}
	
	public void setTurma(String Turma) {
		this.turma = Turma;
	}
	
	public String getSemestre() {
		return semestre;
	}
	
	public void setSemestre(String Semestre) {
		this.semestre = Semestre;
	}
	
	public ListaAluno getProx() {
		return proximoAluno;
	}
	
	public void setProx(ListaAluno Prox) {
		this.proximoAluno = Prox;
	}

}

