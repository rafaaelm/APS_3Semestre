package Visao;

import java.util.ArrayList;
import Controle.Controle;
import Modelo.CursoVO;

public class ListarCursos {
	private Controle ct;
	private ArrayList<CursoVO> listaCursos;
	public ListarCursos(Controle ct) {
		this.ct = ct;
	}

	public void listarCursos() {
		System.out.println("\nLista de cursos inscrito:");
		listaCursos = ct.listarCursos();
		for(int i = 0; i < listaCursos.size(); i++) {
			System.out.println("\n\t Nome: " + listaCursos.get(i).getNomeCurso()
					+"\tTipo: " + listaCursos.get(i).getTipoCurso()
					+"\tAno: " + listaCursos.get(i).getAnoCurso());
		}
	}
}
