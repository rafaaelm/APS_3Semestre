package Modelo;
public class RendimentoVO {
	private boolean aprovado;
	private NotasVO media;
	private CursoVO curso;
	private AlunosVO aluno;

	public RendimentoVO(boolean aprovado, NotasVO media, CursoVO curso, AlunosVO aluno) {
		super();
		this.aprovado = aprovado;
		this.media = media;
		this.curso = curso;
		this.aluno = aluno;
	}
	public boolean isAprovado() {
		return aprovado;
	}
	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}
	public NotasVO getMedia() {
		return media;
	}
	public void setMedia(NotasVO media) {
		this.media = media;
	}
	public CursoVO getCurso() {
		return curso;
	}
	public void setCurso(CursoVO curso) {
		this.curso = curso;
	}
	public AlunosVO getAluno() {
		return aluno;
	}
	public void setAluno(AlunosVO aluno) {
		this.aluno = aluno;
	}
}