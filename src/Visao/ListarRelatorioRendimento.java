package Visao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import Controle.Controle;
import Modelo.RendimentoVO;

public class ListarRelatorioRendimento {

	private Controle ct;
	private ArrayList<RendimentoVO> listaRendimento;
	public ListarRelatorioRendimento(Controle ct) {
		this.ct = ct;
	}
	public void listarRendimento() {
		ListarCursos lc = new ListarCursos(ct);
		Scanner sc = new Scanner(System.in);
		boolean ver = true;
		while(ver) {	//Curso
			lc.listarCursos();
			sc = new Scanner(System.in);
			System.out.print("\nEntre com o nome do curso: ");
			String nomeCurso = sc.nextLine().toUpperCase();
			String tipoCurso = null;
			while(tipoCurso == null) {
				try {
					System.out.print("\nEntre com 1 para Gradua\u00e7\u00e3o ou 2 para Pos Gradua\u00e7\u00e3o: ");
					int iTipo = sc.nextInt();
					if(iTipo == 1) {
						tipoCurso = "GRADUACAO";
					} else if(iTipo == 2) {
						tipoCurso = "POS_GRADUACAO";
					}
				} catch (InputMismatchException e) {
					System.out.println("\n Por favor, digite um n\u00famero inteiro");
				}
			}
			int anoCurso = 0;
			ver = false;
			while(!ver) {
				sc = new Scanner(System.in);
				try {
					System.out.print("\nEntre com o ano do curso: ");
					anoCurso = sc.nextInt();
					if(anoCurso >= 1950 && anoCurso <= 2200) {
						ver = true;
					} else {
						System.out.println("\n O ano tem que ser entre 1950 e 2200");
					}
				} catch (InputMismatchException e) {
					System.out.println("\n Por favor, digite um n\u00famero inteiro");
				}
			}
			ver = ct.veriricaCurso(nomeCurso, tipoCurso, anoCurso);
			if(ver) {
				System.out.println("\nEsse curso n\u00e3o existe");
			} else {
				listaRendimento = ct.retornaRendimentosCurso(nomeCurso, tipoCurso, anoCurso);
				System.out.println("\n Curso - \tNome: " + nomeCurso
						+"\tTipo: " + tipoCurso
						+"\tAno: " + anoCurso);
			}
		}
		for(int i = 0; i < listaRendimento.size(); i++) {
			System.out.println("\n Aluno - \tID: " + listaRendimento.get(i).getAluno().getId() 
					+"\tNome: " + listaRendimento.get(i).getAluno().getNomeAluno()
					+"\n Media -  \tNota 1: " + listaRendimento.get(i).getMedia().getNp1()
					+" Nota 2: " + listaRendimento.get(i).getMedia().getNp2() 
					+" Reposicao: " + listaRendimento.get(i).getMedia().getReposicao() 
					+" Exame: " + listaRendimento.get(i).getMedia().getExame()
					+"\n Aprovado: \t" + listaRendimento.get(i).isAprovado());
		}
	}
}
