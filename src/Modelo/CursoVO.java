package Modelo;
public class CursoVO {
	private String nomeCurso;
	private String tipoCurso;
	private int anoCurso;

	public CursoVO(String nomeCurso, String tipoCurso, int anoCurso) {
		this.nomeCurso = nomeCurso;
		this.tipoCurso = tipoCurso;
		this.anoCurso = anoCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getTipoCurso() {
		return tipoCurso;
	}

	public void setTipoCurso(String tipoCurso) {
		this.tipoCurso = tipoCurso;
	}

	public int getAnoCurso() {
		return anoCurso;
	}

	public void setAnoCurso(int anoCurso) {
		this.anoCurso = anoCurso;
	} 
}
