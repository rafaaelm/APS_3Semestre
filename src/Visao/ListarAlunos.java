package Visao;

import java.util.ArrayList;
import Controle.Controle;
import Modelo.AlunosVO;

public class ListarAlunos {
	private Controle ct;
	private ArrayList<AlunosVO> listaAlunos;
	public ListarAlunos(Controle ct) {
		this.ct = ct;
	}

	public void listarAlunos() {
		System.out.println("\nLista de alunos inscrito:");
		listaAlunos = ct.listarAlunos();
		for(int i = 0; i < listaAlunos.size(); i++) {
			System.out.println("\n\tID: " + listaAlunos.get(i).getId()
					+"\tNome: " + listaAlunos.get(i).getNomeAluno());
		}
	}
}
