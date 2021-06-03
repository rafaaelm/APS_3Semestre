package Modelo;

import java.util.ArrayList;

public class Verificar {

	public boolean veriricaAluno(ArrayList<AlunosVO> listaAlunos, String ID) {
		if(listaAlunos.size() > 0) {
			for(int i = 0; i < listaAlunos.size(); i++) {

				if( listaAlunos.get(i).getId().equals(ID) ) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean veriricaCurso(ArrayList<CursoVO> listaCurso, String nome, String tipo, int ano) {
		CursoVO curso = new CursoVO(nome, tipo, ano);
		for(int i = 0; i < listaCurso.size(); i++) {

			String nomeCursoLista = listaCurso.get(i).getNomeCurso().toUpperCase();
			String nomeCurso = curso.getNomeCurso().toUpperCase();

			String tipoCursoLista = listaCurso.get(i).getTipoCurso().toUpperCase();
			String tipoCurso = curso.getTipoCurso().toUpperCase();

			int anoCursoLista = listaCurso.get(i).getAnoCurso();
			int anoCurso = curso.getAnoCurso();

			if( nomeCurso.equals(nomeCursoLista) && tipoCurso.equals(tipoCursoLista) && anoCurso == anoCursoLista) {
				return false;
			}
		}
		return true;
	}

	public boolean veriricaRendimento(ArrayList<RendimentoVO> listaRendimento, NotasVO nota, CursoVO curso, AlunosVO aluno, int i) {
		if(listaRendimento.get(i).getAluno().getId().equals(aluno.getId()) &&
				listaRendimento.get(i).getCurso().getNomeCurso().equalsIgnoreCase(curso.getNomeCurso()) &&
				listaRendimento.get(i).getCurso().getTipoCurso().equalsIgnoreCase(curso.getTipoCurso()) &&
				listaRendimento.get(i).getCurso().getAnoCurso() == curso.getAnoCurso() ) {
			return true;
		}
		return false;
	}

	public boolean verificaAprovacao(String tipoCurso, double np1, double np2, double rep, double exame) {
		if(tipoCurso.equalsIgnoreCase("GRADUACAO")) {
			double media_inicial = retornaMediaInicial(np1, np2, rep);
			if(media_inicial < 7) {
				if((media_inicial + exame)/2 < 5) {
					return false;
				} else {
					return true;
				}
			} else {
				return true;
			}
		}else if(tipoCurso.equals("POS_GRADUACAO")) {
			double media_inicial = retornaMediaInicial(np1, np2, rep);
			if(media_inicial < 5) {
				if((media_inicial + exame)/2 < 5) {
					return false;
				} else {
					return true;
				}
			} else {
				return true;
			}
		}
		System.out.println("Deu ruim");
		return false;
	}

	public double retornaMediaInicial(double np1, double np2, double sub) {
		double maior;
		double segundo;
		if(np1 >= np2) {
			if( np1 >= sub) {
				maior = np1;
				if(np2 >= sub) {
					segundo = np2;
				} else {
					segundo = sub;
				}
			} else {
				maior = sub;
				segundo = np1;
			}
		} else {
			if( np2 >= sub) {
				maior = np2;
				if(np1 >= sub) {
					segundo = np1;
				} else {
					segundo = sub;
				}
			} else {
				maior = sub;
				segundo = np2;
			}
		}
		double media = (maior + segundo)/2;
		return media;
	}
}