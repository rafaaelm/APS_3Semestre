package Modelo;

import java.util.ArrayList;

public class Modelo {
	static ArrayList<AlunosVO> listaAlunos = new ArrayList<AlunosVO>();
	static ArrayList<CursoVO> listaCursos = new ArrayList<CursoVO>();
	static ArrayList<RendimentoVO> listaRendimento = new ArrayList<RendimentoVO>();

	Verificar verifica = new Verificar();
	CarregaCSV CCSV = new CarregaCSV();

	public void carregaCSV() {
		ArrayList<String> lista = null;

		lista = CCSV.leCSV("cursos");

		for(int i = 0; i < lista.size(); i += 3) {	//curso
			String nomeCurso = lista.get(i).toUpperCase();
			String tipoCurso = lista.get(i+1).toUpperCase();
			int anoCurso  = Integer.parseInt(lista.get(i+2));

			CursoVO curso_novo = new CursoVO(nomeCurso, tipoCurso, anoCurso);
			listaCursos.add(curso_novo);
		}	
		lista = CCSV.leCSV("alunos");
		for(int i = 0; i < lista.size(); i += 2) {	//alunos
			String idAluno = lista.get(i);
			String nomeAluno = lista.get(i+1);

			AlunosVO aluno_novo = new AlunosVO(idAluno, nomeAluno);
			listaAlunos.add(aluno_novo);
		}	
		lista = null;
		for(int c = 0; c < listaCursos.size(); c++) { //rendimento
			lista = CCSV.leCSV(listaCursos.get(c).getNomeCurso() + "_" + listaCursos.get(c).getTipoCurso() + "_" + listaCursos.get(c).getAnoCurso());
			for(int i = 0; i < lista.size(); i += 5) {

				double np1 = Double.parseDouble(lista.get(i+1));
				double np2 = Double.parseDouble(lista.get(i+2));
				double rep = Double.parseDouble(lista.get(i+3));
				double exame = Double.parseDouble(lista.get(i+4));

				NotasVO nota = new NotasVO(np1, np2, rep, exame);

				boolean aprovacao = verifica.verificaAprovacao(listaCursos.get(c).getTipoCurso(), np1, np2, rep, exame);

				String idAluno = lista.get(i);
				AlunosVO aluno = null;
				for(int cont = 0; cont < listaAlunos.size(); cont++) {
					if(listaAlunos.get(cont).getId().equals(idAluno))
						aluno = listaAlunos.get(cont);
				}
				RendimentoVO rendimento_novo = new RendimentoVO(aprovacao, nota, listaCursos.get(c), aluno);
				listaRendimento.add(rendimento_novo);
			}
		}
	}

	public void cadastrarAluno(String id, String nome){
		AlunosVO aluno_novo = new AlunosVO(id, nome);
		listaAlunos.add(aluno_novo);
	}

	public void cadastrarCurso(String nome, String tipo, int ano){
		CursoVO curso_novo = new CursoVO(nome.toUpperCase(), tipo, ano );
		listaCursos.add(curso_novo);
	}

	public void cadastrarRendimento(boolean aprovacao, NotasVO nota, CursoVO curso, AlunosVO aluno){
		boolean ver = false;
		for(int i = 0; i < listaRendimento.size(); i++) {
			ver = verifica.veriricaRendimento(listaRendimento, nota, curso, aluno, i);
			if(ver) {
				listaRendimento.get(i).setMedia(nota);
				break;
			}
		}
		RendimentoVO rendimento_novo = new RendimentoVO(aprovacao, nota, curso, aluno);
		if(!ver) {
			listaRendimento.add(rendimento_novo);
		}
	}

	public ArrayList<AlunosVO> listarAlunos() {
		return listaAlunos;
	}

	public ArrayList<CursoVO> listarCursos() {
		return listaCursos;
	}

	public ArrayList<RendimentoVO> listarRendimento() {
		return listaRendimento;
	}

	public AlunosVO retornaAluno(String id) {
		for(int i = 0; i < listaAlunos.size(); i++) {
			if(listaAlunos.get(i).getId().equals(id)) {
				return listaAlunos.get(i);
			}
		}
		return null;
	}

	public ArrayList<RendimentoVO> retornaHistorico(String id) {
		ArrayList<RendimentoVO> listaRendimentoAluno = new ArrayList<RendimentoVO>();

		for(int i = 0; i < listaRendimento.size(); i++) {
			if(listaRendimento.get(i).getAluno().getId().equalsIgnoreCase(id)) {
				listaRendimentoAluno.add(listaRendimento.get(i));
			}
		}
		return listaRendimentoAluno;
	}

	public ArrayList<RendimentoVO> retornaRendimentosCurso(String nome, String tipo, int ano) {
		ArrayList<RendimentoVO> listaRendimentoCurso = new ArrayList<RendimentoVO>();

		for(int i = 0; i < listaRendimento.size(); i++) {
			if(listaRendimento.get(i).getCurso().getNomeCurso().equalsIgnoreCase(nome) &&
					listaRendimento.get(i).getCurso().getTipoCurso().equalsIgnoreCase(tipo) &&
					listaRendimento.get(i).getCurso().getAnoCurso() == ano) {

				listaRendimentoCurso.add(listaRendimento.get(i));
			}
		}
		return listaRendimentoCurso;
	}

	public void recarregarCSV() {
		listaAlunos.clear();
		listaCursos.clear();
		listaRendimento.clear();
		carregaCSV();
	}

	public void escreverCSV() {

		CCSV.limpaCSV("alunos");
		for(int i = 0; i < listaAlunos.size(); i++)
			CCSV.escreveCSV("alunos", listaAlunos.get(i).getId() + ";" + listaAlunos.get(i).getNomeAluno());

		CCSV.limpaCSV("cursos");
		for(int i = 0; i < listaCursos.size(); i++) {
			CCSV.escreveCSV("cursos", listaCursos.get(i).getNomeCurso() + ";" + listaCursos.get(i).getTipoCurso() + ";" + listaCursos.get(i).getAnoCurso());
			CCSV.limpaCSV(listaCursos.get(i).getNomeCurso() + "_" + listaCursos.get(i).getTipoCurso() + "_" + listaCursos.get(i).getAnoCurso());
		}
		for(int i = 0; i < listaRendimento.size(); i++) {
			String nomeArquivo =  listaRendimento.get(i).getCurso().getNomeCurso() + "_" 
					+ listaRendimento.get(i).getCurso().getTipoCurso() + "_" 
					+ listaRendimento.get(i).getCurso().getAnoCurso();
			CCSV.escreveCSV(nomeArquivo,  listaRendimento.get(i).getAluno().getId() + ";" 
					+ listaRendimento.get(i).getMedia().getNp1() + ";" 
					+ listaRendimento.get(i).getMedia().getNp2() + ";" 
					+ listaRendimento.get(i).getMedia().getReposicao() + ";" 
					+ listaRendimento.get(i).getMedia().getExame() + ";" );
		}
	}
}
