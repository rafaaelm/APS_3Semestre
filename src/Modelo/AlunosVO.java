package Modelo;

public class AlunosVO {

	private String id;
	private String nomeAluno;

	public AlunosVO(String id, String nomeAluno) {
		this.id = id;
		this.nomeAluno = nomeAluno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
}
