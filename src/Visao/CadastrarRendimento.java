package Visao;

import java.util.InputMismatchException;
import java.util.Scanner;
import Controle.Controle;
import Modelo.AlunosVO;
import Modelo.CursoVO;
import Modelo.NotasVO;

public class CadastrarRendimento {

	private Controle ct;
	public CadastrarRendimento(Controle ct) {
		this.ct = ct;
	}

	public void cadastrarRendimento() {

		ListarAlunos la = new ListarAlunos(ct);
		ListarCursos lc = new ListarCursos(ct);
		Scanner sc = new Scanner(System.in);
		AlunosVO aluno = null;
		CursoVO curso = null;
		NotasVO nota = null;
		boolean ver = true;

		while(aluno == null) {	//Aluno
			la.listarAlunos();
			System.out.print("\nEntre com o ID do aluno desejado: ");
			String id_aluno = sc.nextLine();
			aluno = ct.retornaAluno(id_aluno);
			if(aluno == null)
				System.out.println("ID incorreto");
		}

		ver = true;
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
				curso = new CursoVO(nomeCurso, tipoCurso, anoCurso);
			}
		}
		ver = false;
		do {
			boolean aprovacao;
			sc = new Scanner(System.in);
			try {
				System.out.println("\nAs notas devem ser entre 0 e 10! ");
				System.out.print("\nEntre com a nota da primeira prova da mat\u00e9ria: ");
				double np1 = sc.nextDouble();

				System.out.print("\nEntre com a nota da segunda prova da mat\u00e9ria: ");
				double np2 = sc.nextDouble();

				System.out.print("\nEntre com a nota da prova substitutiva da mat\u00e9ria: ");
				double rep = sc.nextDouble();

				System.out.print("\nEntre com a nota do exame final da mat\u00e9ria: ");
				double exame = sc.nextDouble();

				if(np1 >= 0 && np1 <= 10 && np2 >= 0 && np2 <= 10 && rep >= 0 && rep <= 10 && exame >= 0 && exame <= 10) {
					aprovacao = ct.verificaAprovacao(curso.getTipoCurso(), np1, np2, rep, exame);
					nota = new NotasVO(np1, np2, rep, exame);
					ver = ct.cadastrarRendimento(aprovacao, nota, curso, aluno);
				} 
			} catch (InputMismatchException e) {
				System.out.println("\n Por favor, digite um n\u00famero entre 0 e 10");
			}

		} while(!ver);
	}
}
