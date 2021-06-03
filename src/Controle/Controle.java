package Controle;

import java.util.ArrayList;
import Modelo.*;

public class Controle {
	Modelo modelo = new Modelo();
	Verificar verifica = new Verificar();
	public void carregaCSV() {
		modelo.carregaCSV();
		return;
	}

	public boolean veriricaAluno(String id) {
		return verifica.veriricaAluno(modelo.listarAlunos(), id);
	}

	public boolean veriricaCurso(String nome, String tipo, int ano) {
		return verifica.veriricaCurso(modelo.listarCursos(), nome, tipo, ano);
	}

	public boolean verificaAprovacao(String tipoCurso, double np1, double np2, double rep, double exame) {
		return verifica.verificaAprovacao(tipoCurso, np1, np2, rep, exame);
	}

	public void cadastrarAluno(String id, String nome) {
		modelo.cadastrarAluno(id, nome);
	}

	public void cadastrarCurso(String nome, String tipo, int ano) {
		modelo.cadastrarCurso(nome, tipo, ano);
	}

	public boolean cadastrarRendimento(boolean aprovacao, NotasVO nota, CursoVO curso, AlunosVO aluno) {
		modelo.cadastrarRendimento(aprovacao, nota, curso, aluno);
		return true;
	}

	public ArrayList<AlunosVO> listarAlunos() {
		return modelo.listarAlunos();
	}

	public ArrayList<CursoVO> listarCursos() {
		return modelo.listarCursos();
	}

	public ArrayList<RendimentoVO> listarRendimento() {
		return modelo.listarRendimento();
	}

	public AlunosVO retornaAluno(String id_aluno) {
		return modelo.retornaAluno(id_aluno);
	}

	public ArrayList<RendimentoVO> retornaHistorico(String id) {
		return modelo.retornaHistorico(id);
	}

	public ArrayList<RendimentoVO> retornaRendimentosCurso(String nome, String tipo, int ano) {
		return modelo.retornaRendimentosCurso(nome, tipo, ano);
	}

	public void recarregarArquivos() {
		modelo.recarregarCSV();
		return;
	}

	public void salvarArquivos() {
		modelo.escreverCSV();
		return;
	}
}
