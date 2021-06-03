package Modelo;
public class NotasVO {
	private double np1;
	private double np2;
	private double reposicao;
	private double exame;

	public NotasVO(double np1, double np2, double reposicao, double exame) {
		this.np1 = np1;
		this.np2 = np2;
		this.reposicao = reposicao;
		this.exame = exame;
	}

	public double getNp1() {
		return np1;
	}

	public void setNp1(double np1) {
		this.np1 = np1;
	}

	public double getNp2() {
		return np2;
	}

	public void setNp2(double np2) {
		this.np2 = np2;
	}

	public double getReposicao() {
		return reposicao;
	}

	public void setReposicao(double reposicao) {
		this.reposicao = reposicao;
	}

	public double getExame() {
		return exame;
	}

	public void setExame(double exame) {
		this.exame = exame;
	}
}
