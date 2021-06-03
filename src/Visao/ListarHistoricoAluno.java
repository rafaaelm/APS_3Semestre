package Visao;

import java.util.ArrayList;
import java.util.Scanner;
import Controle.Controle;
import Modelo.RendimentoVO;

public class ListarHistoricoAluno {
	private ArrayList<RendimentoVO> listaRendimento;
	private Controle ct;
	public ListarHistoricoAluno(Controle ct) {
		this.ct = ct;
	}
	public void listarHistorico() {
		ListarAlunos la = new ListarAlunos(ct);
		Scanner sc = new Scanner(System.in);
		boolean ver = true;
		while(ver) {	//Aluno
			la.listarAlunos();
			System.out.print("\nEntre com o ID do aluno desejado: ");
			String id_aluno = sc.nextLine();
			ver = ct.veriricaAluno(id_aluno);
			if(ver){
				System.out.println("ID incorreto");
			}else{
				listaRendimento = ct.retornaHistorico(id_aluno);
				System.out.println("Listando cursos... ");
				for(int i = 0; i < listaRendimento.size(); i++) {

					System.out.println("\n\n Curso - \tNome: " + listaRendimento.get(i).getCurso().getNomeCurso()
							+"\tTipo: " + listaRendimento.get(i).getCurso().getTipoCurso()
							+"\tAno: " + listaRendimento.get(i).getCurso().getAnoCurso()
							+"\n Media -  \tNota 1: " + listaRendimento.get(i).getMedia().getNp1()
							+" Nota 2: " + listaRendimento.get(i).getMedia().getNp2() 
							+" Reposicao: " + listaRendimento.get(i).getMedia().getReposicao() 
							+" Exame: " + listaRendimento.get(i).getMedia().getExame()
							+"\n Aprovado: \t" + listaRendimento.get(i).isAprovado());
				}
			}
		}
	}
}