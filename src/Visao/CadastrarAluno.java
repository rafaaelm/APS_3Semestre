package Visao;

import java.util.Scanner;

import Controle.Controle;

public class CadastrarAluno {

	private Controle ct;
	public CadastrarAluno(Controle ct) {
		this.ct = ct;
	}

	public void cadastrarAluno() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEntre com o ID do aluno: ");
		String id = sc.nextLine().toLowerCase();
		boolean ver = ct.veriricaAluno(id);
		while(ver == false) {
			System.out.print("\nEsse ID ja existe, entre com o outro ID: ");
			id = sc.nextLine();
			ver = ct.veriricaAluno(id);
		} 
		System.out.print("\nEntre com o nome do aluno: ");
		String nome = sc.nextLine();
		ct.cadastrarAluno(id, nome);
		System.out.println("\nAluno cadastrado \n");
	}
}
