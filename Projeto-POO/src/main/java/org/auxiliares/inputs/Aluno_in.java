package org.auxiliares.inputs;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;

import org.modelos.Aluno;
import org.modelos.Responsavel;
import org.modelos.Turma;

public class Aluno_in {
    public Aluno createAluno(EntityManager session){
		Aluno aluno = new Aluno();

		Scanner c = new Scanner(System.in); 
							
		System.out.print("\nNome: ");
		String nome = c.nextLine();
		aluno.setNome(nome);

		System.out.print("CPF: ");
		String cpf = c.nextLine();
		aluno.setCpf(cpf);

		System.out.print("Data de Nascimento: ");
		String dataNasci = c.nextLine();
		aluno.setDataNascimento(dataNasci);

		System.out.print("Contato: ");
		String contato = c.nextLine();
		aluno.setContato(contato);

		System.out.print("TipoPagamento - H/M (Hora/Aula)/(Mensalidade): ");
		String tipoPag = c.nextLine();
		aluno.setTipoPag(tipoPag);

        System.out.print("Nivel Escolar: ");
		String nivelEscolar = c.nextLine();
		aluno.setNivelEscolar(nivelEscolar);

        System.out.print("Obs.: ");
		String observacao = c.nextLine();
		aluno.setObservacao(observacao);

		Scanner g = new Scanner(System.in);
		System.out.print("ID do Responsavel:");
		Long idFindAdd = g.nextLong();
		Responsavel responsavel = session.find(Responsavel.class, idFindAdd);
		responsavel.addAluno(aluno);

		Scanner t = new Scanner(System.in);
		System.out.print("ID do Turma:");
		idFindAdd = t.nextLong();
		Turma turma = session.find(Turma.class, idFindAdd);
		turma.addAluno(aluno);

        return aluno;
	}

	public static void readAluno(Session session){
		System.out.println("\n--- SELECT ---");
		List result = session.createQuery( "from Aluno").list();
		for ( Aluno aluno : (List<Aluno>) result ) {
		System.out.println( "\n" + aluno.getId() + " - " + aluno.getNome() + " - " + aluno.getCpf() + " - " + aluno.getDataNascimento() + " - " + aluno.getContato() + " - " + aluno.getTipoPag() + " - " + aluno.getNivelEscolar() + " - " + aluno.getObservacao());
		}
	}

	public static void deleteAluno(Session session) {
		System.out.println("\n--- DELETE ---");
		session.beginTransaction();

		Scanner f = new Scanner(System.in);
		Query query = session.createQuery( "DELETE FROM Aluno a WHERE a.id = :id" );
		System.out.print("Digite o ID do Aluno a ser Deletado:");
		Long idfind = f.nextLong();
		Aluno aluno = session.find(Aluno.class, idfind);
		session.remove(aluno);
		session.getTransaction().commit();
	}

	public static void selectAluno(Session session) {
		System.out.println("\n--- SELECT ---");
		session.clear();
		List result = session.createQuery( "from Pessoa" ).list();
		for ( Aluno aluno : (List<Aluno>) result ) {
			System.out.println( aluno.getId() + " - " + aluno.getNome() + " - " + aluno.getCpf());
		}
	}

	public static void updateAluno(Session session) {
		Scanner uS = new Scanner(System.in);
		Scanner find = new Scanner(System.in); //Long
		Query query_U = null;

		System.out.println("\n--- UPDATE ---");
		System.out.println("\nEscolha um atributo a ser modificado\nN - ome\nD - data\nC - ontato\nNI - vel Escolar\nO - bservação\nT - ipo de pagamento\nTU - urma\nR - esponsavel");

		Scanner f = new Scanner(System.in);
		String escolha = f.nextLine().toUpperCase();


		switch (escolha) {
			case "N": //NOME
				query_U = session.createQuery( "UPDATE Aluno p SET p.nome = :nome WHERE p.id = :id" );

				System.out.print("\nPara o ID... : ");
				Long findId = find.nextLong();
				query_U.setParameter("id", findId);
				
				System.out.print("Digite o nome: ");
				String newnome = find.nextLine();
				query_U.setParameter("nome", newnome);

				query_U.executeUpdate();
				session.getTransaction().commit();	
			break;	
				
			// 	case "D": // DATA NASCIMENTO
			// 	query_U = session.createQuery( "UPDATE Pessoa p SET p.datanascimento = :datanasci WHERE p.id = :id" );

			// 	System.out.print("Digite a data de nascimento: ");
			// 	String newdatanasci = uS.nextLine();
			// 	query_U.setParameter("datanasci", newdatanasci);

			// 	query_U.executeUpdate();
			// 	session.getTransaction().commit();
			// 	break;

			// case "C": // CONTATO
			// 	query_U = session.createQuery( "UPDATE Pessoa p SET p.contato = :contato WHERE p.id = :id" );

			// 	System.out.print("Digite o contato: ");
			// 	String newcontato = uS.nextLine();
			// 	query_U.setParameter("contato", newcontato);

			// 	query_U.executeUpdate();
			// 	session.getTransaction().commit();
			// 	break;
			
			// case "NI": // NÍVEL ESCOLAR
			// 	query_U = session.createQuery( "UPDATE Pessoa p SET p.contato = :contato WHERE p.id = :id" );

			// 	System.out.print("Digite o contato: ");
			// 	String newcontato = uS.nextLine();
			// 	query_U.setParameter("contato", newcontato);

			// 	query_U.executeUpdate();
			// 	session.getTransaction().commit();
			// 	break;

			// case "O": // OBSERVACAO
			// 	query_U = session.createQuery( "UPDATE Pessoa p SET p.contato = :contato WHERE p.id = :id" );

			// 	System.out.print("Digite o contato: ");
			// 	String newcontato = uS.nextLine();
			// 	query_U.setParameter("contato", newcontato);

			// 	query_U.executeUpdate();
			// 	session.getTransaction().commit();
			// 	break;

			// case "T": // TipoPagamento
			// 	query_U = session.createQuery( "UPDATE Pessoa p SET p.contato = :contato WHERE p.id = :id" );

			// 	System.out.print("Digite o contato: ");
			// 	String newcontato = uS.nextLine();
			// 	query_U.setParameter("contato", newcontato);

			// 	query_U.executeUpdate();
			// 	session.getTransaction().commit();
			// 	break;
			
			// case "TU": // Turma
			// 	query_U = session.createQuery( "UPDATE Pessoa p SET p.contato = :contato WHERE p.id = :id" );

			// 	System.out.print("Digite o contato: ");
			// 	String newcontato = uS.nextLine();
			// 	query_U.setParameter("contato", newcontato);

			// 	query_U.executeUpdate();
			// 	session.getTransaction().commit();
			// 	break;

			// case "R": // Responsavel
			// 	query_U = session.createQuery( "UPDATE Pessoa p SET p.contato = :contato WHERE p.id = :id" );

			// 	System.out.print("Digite o contato: ");
			// 	String newcontato = uS.nextLine();
			// 	query_U.setParameter("contato", newcontato);

			// 	query_U.executeUpdate();
			// 	session.getTransaction().commit();
			// 	break;
			
			default:
				break;
		}
		
	}


}

