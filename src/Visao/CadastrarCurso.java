package Visao;

import java.util.InputMismatchException;
import java.util.Scanner;
import Controle.Controle;

public class CadastrarCurso {
	private Controle ct;
	public CadastrarCurso(Controle ct) {
		this.ct = ct;
	}
	public void cadastrarCurso() {
		boolean ver = false;
		String nome;
		String tipo;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("\nEntre com o nome do curso: ");
			nome = sc.nextLine().toUpperCase();
			tipo = null;
			while(tipo == null) {
				try {
					System.out.print("\nEntre com 1 para Gradua\u00e7\u00e3o ou 2 para Pos Gradua\u00e7\u00e3o: ");
					int iTipo = sc.nextInt();
					if(iTipo == 1) {
						tipo = "GRADUACAO";
					} else if(iTipo == 2) {
						tipo = "POS_GRADUACAO";
					}
				} catch (InputMismatchException e) {
					System.out.println("\n Por favor, digite um n\u00famero inteiro");
				}
			}
			int ano = 0;
			ver = false;
			while(!ver) {
				sc = new Scanner(System.in);
				try {
					System.out.print("\nEntre com o ano do curso: ");
					ano = sc.nextInt();
					if(ano >= 1950 && ano <= 2200) {
						ver = true;
					} else {
						System.out.println("\n O ano tem que ser entre 1950 e 2200");
					}
				} catch (InputMismatchException e) {
					System.out.println("\n Por favor, digite um n\u00famero inteiro");
				}
			}
			ver = ct.veriricaCurso(nome, tipo, ano);
			if(!ver) {
				System.out.println("Esse curso j\u00e1 existe.");
			} else {
				ct.cadastrarCurso(nome, tipo, ano);
				System.out.println("Curso cadastrado");
			}
		}while(!ver);
	}
}