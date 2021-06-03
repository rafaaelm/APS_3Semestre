package Visao;

import java.util.InputMismatchException;
import java.util.Scanner;
import Controle.Controle;

public class ProjetoAPS {

	public static void menu() {
		Controle ct = new Controle();
		CadastrarAluno ca = new CadastrarAluno(ct);
		CadastrarCurso cc = new CadastrarCurso(ct);
		CadastrarRendimento cr = new CadastrarRendimento(ct);
		ListarAlunos la = new ListarAlunos(ct);
		ListarCursos lc = new ListarCursos(ct);
		ListarHistoricoAluno lh = new ListarHistoricoAluno(ct);
		ListarRelatorioRendimento lr = new ListarRelatorioRendimento(ct);
		System.out.println("Bem Vindo! \n"
				+ "\n Turma: SI3P12\n"
				+ "\n Leonardo Slonzo Alvares Portes | F3079A-9\n"
				+ "\n Lucas Alves de Souza Marques Timoteo | N55569-6\n"
				+ "\n Nathan Duarte da Silva | N6188C-2\n"
				+ "\n Rafael Mascarenhas | F19DAD-3\n"
				+ "\n Vin\u00edcius de Campos da Silva | F206BA-7\n");
		ct.carregaCSV();
		int op = 0;
		while(op != 10) {
			Scanner sc = new Scanner(System.in);
			System.out.println("\nEscolha a op\u00e7\u00e3o desejada: \n"
					+ "1 - Incluir um novo aluno \n"
					+ "2 - Incluir um novo curso \n"
					+ "3 - Incluir um novo rendimento \n"
					+ "4 - Listar todos os alunos inscritos \n"
					+ "5 - Listar todos os cursos dados \n"
					+ "6 - Listar o hist\u00f3rico de um determinado aluno \n"
					+ "7 - Listar o relat\u00f3rio de rendimento de um determinado curso \n"
					+ "8 - Salvar modifica\u00e7\u00f5es \n"
					+ "9 - Recarregar arquivos \n"
					+ "10 - Sair");

			System.out.print("\nDigite a Op\u00e7\u00e3o desejada: ");
			try {
			op = sc.nextInt();
			} catch (InputMismatchException e) {
				op = -1;
			}
			System.out.println("\n==========================================================================================");
			switch(op) {
			case 1:
				ca.cadastrarAluno();
				break;
			case 2:
				cc.cadastrarCurso();
				break;
			case 3:
				cr.cadastrarRendimento();
				break;
			case 4:
				la.listarAlunos();
				break;
			case 5:
				lc.listarCursos();
				break;
			case 6:
				lh.listarHistorico();
				break;
			case 7:
				lr.listarRendimento();
				break;
			case 8:
				ct.salvarArquivos();
				System.out.println("\n Arquivos salvados com sucesso!");
				break;
			case 9:
				ct.recarregarArquivos();
				System.out.println("\n Arquivos recarregados com sucesso!");
				break;
			case 10:
				sc = new Scanner(System.in);
				System.out.println("\nDeseja salvar?");
				String opSalvar = sc.nextLine();
				if(opSalvar.equalsIgnoreCase("sim") || opSalvar.equalsIgnoreCase("s") || opSalvar.equalsIgnoreCase("y") || opSalvar.equalsIgnoreCase("yes") || opSalvar.equalsIgnoreCase("1")) {
					ct.salvarArquivos(); 
					System.out.println("\n Arquivos salvados com sucesso!");
				}
				System.out.println("\n Encerrando...");
				break;
			case -1:
				System.out.println("\n Por favor, digite um n\u00famero inteiro");
				break;
			default:
				System.out.println("\n Op\u00e7\u00e3o invalida");
				break;
			}
			System.out.println("\n==========================================================================================");
		}
	}
}
