package org.modelos;

import java.io.IOException;

import org.auxiliares.dao.AlunoDAO;
import org.auxiliares.inputs.Aluno_in;
import org.auxiliares.dao.ResponsavelDAO;
import org.auxiliares.dao.TurmaDAO;
import org.auxiliares.inputs.Responsavel_in;
import org.auxiliares.inputs.Turma_in;
import org.auxiliares.inputs.Professora_in;
import org.auxiliares.dao.ProfessoraDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws InterruptedException, IOException {
		String key = " ";
		HibernateUtil hu = new HibernateUtil();
		SessionFactory sessionFactory = hu.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		do {
			limpaConsole();
			menu();
			Scanner k = new Scanner(System.in); 
			System.out.print("Escolha uma das opções do nosso menu: ");
			key = k.nextLine().toUpperCase();
			
			switch (key) {
				
				case "C": //CREATE - C
					menuCreate();
					System.out.print("Escolha uma das opções do nosso menu: ");
					key = k.nextLine().toUpperCase();

					switch (key) {
						case "A":						
							Aluno_in aluno_in = new Aluno_in();

							AlunoDAO daoA = new AlunoDAO(aluno_in.createAluno(session), session); 

							daoA.create();
							break;

						case "R":
							Responsavel_in responsavel_in = new Responsavel_in();

							ResponsavelDAO daoR = new ResponsavelDAO(responsavel_in.createResponsavel(session), session);

							daoR.create();
							break;
							
						case "P":
							Professora_in professora_in = new Professora_in();

							ProfessoraDAO daoP = new ProfessoraDAO(professora_in.createProfessora(session), session);

							daoP.create();
							break;

						case "T":
							Turma_in turma_in = new Turma_in();

							TurmaDAO daoT = new TurmaDAO(turma_in.createTurma(session), session);

							daoT.create();
							break;

						case "F":
							break;


						
						default:
					}
					break;
	
				case "R": //READ - R
					menuCreate();
					System.out.print("Escolha uma das opções do nosso menu: ");
					key = k.nextLine().toUpperCase();

					switch (key) {
						case "A":
							Aluno_in.readAluno(session);
						break;

						case "R":
							Responsavel_in.readResponsavel(session);
							
						break;

						case "P":
							Professora_in.readProfessora(session);
						break;
					}
					break;
	
				case "U": //UPDATE - U
					// pessoa.updatePessoa(session);
					break;
	
				case "D": //DELETE - D
					break;

				case "F": //FIND - F
						Scanner f = new Scanner(System.in);
						System.out.print("Digite o ID de quem você deseja pesquisar:");
						Long idfind = f.nextLong();

						Responsavel responsavel = session.find(Responsavel.class, idfind);
						System.out.println( "\n" + responsavel.getId() + " - " + responsavel.getNome() + " - " + responsavel.getCpf() + " - " + responsavel.getDataNascimento() + " - " + responsavel.getContato() + " - " + responsavel.getEndereco() + " - " + responsavel.getEndereco());
					break;
					default:
					break;
			}
		}
		while (!key.equals("0"));
		session.close();
		sessionFactory.close();
	}


	public static void menu(){
		System.out.println("\n--- Cia do Saber Reforço Escolar ---");
		System.out.println("\sC - reate\n R - ead\n U - pdate\n D - elete\n F - ind");
	}
	public static void menuCreate(){
		System.out.println("\n--- Cia do Saber Reforço Escolar ---");
		System.out.println("\sA - luno\n R - esponsavel\n P - rofessora\n T - urma");
	}

	public static void limpaConsole() throws InterruptedException, IOException{
		Scanner s = new Scanner(System.in);

		System.out.print("\nPressione enter para continuar...");
		s.nextLine();

		if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
	}
}
