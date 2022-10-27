package org.auxiliares.inputs;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;

import org.modelos.Responsavel;

public class Responsavel_in {


	public Responsavel createResponsavel(Session session){
		Responsavel responsavel = new Responsavel();

		Scanner c = new Scanner(System.in); 
							
		System.out.print("\nNome: ");
		String nome = c.nextLine();
		responsavel.setNome(nome);

		System.out.print("CPF: ");
		String cpf = c.nextLine();
		responsavel.setCpf(cpf);

		System.out.print("Data de Nascimento: ");
		String dataNasci = c.nextLine();
		responsavel.setDataNascimento(dataNasci);

		System.out.print("Contato: ");
		String contato = c.nextLine();
		responsavel.setContato(contato);

		System.out.print("Endereço: ");
		String endereco = c.nextLine();
		responsavel.setEndereco(endereco);

        return responsavel;
	}

	public static void readResponsavel(Session session){
		System.out.println("\n--- SELECT ---");
		List result = session.createQuery( "from Responsavel" ).list();
		System.out.println("ID | Nome | CPF | Data de Nascimento | Contato | Endereço ");
		for ( Responsavel responsavel : (List<Responsavel>) result) {
		System.out.println( "\n" + responsavel.getId() + " - " + responsavel.getNome() + " - " + responsavel.getCpf() + " - " + responsavel.getDataNascimento() + " - " + responsavel.getContato() + " - " + responsavel.getEndereco());
		}
	}

	public static void deleteResponsavel(Session session) {
		System.out.println("\n--- DELETE ---");
		session.beginTransaction();

		Scanner f = new Scanner(System.in);
		Query query = session.createQuery( "DELETE FROM Responsavel a WHERE a.id = :id" );
		System.out.print("Digite o ID do Responsável a ser Deletado:");
		Long idfind = f.nextLong();
		Responsavel responsavel = session.find(Responsavel.class, idfind);
		responsavel.setAluno(null);
		session.remove(responsavel);
		session.getTransaction().commit();
	}

	public static void updateResponsavel(Session session) {
		Scanner a = new Scanner(System.in); //Long
		Scanner b = new Scanner(System.in); //Line
		Scanner c = new Scanner(System.in); 

		System.out.println("\n--- UPDATE ---");
		System.out.println("\nEscolha um atributo a ser modificado\n1 - Nome\n2 - data\n3 - Contato\n4 - CPF\n5 - Nivel Endereço\nESCOLHA: ");

		int escolha = c.nextInt();

		switch (escolha) {
			case 1: //NOME
				session.beginTransaction();
				Query query = session.createQuery("UPDATE Responsavel a SET a.nome = :nome WHERE a.id = :id");
				
				System.out.print("\nPara o ID... : ");
				Long findId = a.nextLong();
				query.setParameter("id", findId);

				System.out.print("Digite o nome: ");
				String newnome = b.nextLine();
				query.setParameter("nome", newnome);

				query.executeUpdate();
				session.flush();
				session.getTransaction().commit();	
				break;	

			case 2: // DATA NASCIMENTO
				session.beginTransaction();
				query = session.createQuery( "UPDATE Responsavel p SET p.datanascimento = :datanasci WHERE p.id = :id" );

				System.out.print("\nPara o ID... : ");
				findId = a.nextLong();
				query.setParameter("id", findId);

				System.out.print("Digite a data de nascimento: ");
				String newDatanasci = b.nextLine();
				query.setParameter("datanasci", newDatanasci);

				query.executeUpdate();
				session.getTransaction().commit();
				break;

			case 3: // CONTATO
				session.beginTransaction();
				query = session.createQuery( "UPDATE Responsavel p SET p.contato = :contato WHERE p.id = :id" );

				System.out.print("\nPara o ID... : ");
				findId = a.nextLong();
				query.setParameter("id", findId);

				System.out.print("Digite o contato: ");
				String newContato = b.nextLine();
				query.setParameter("contato", newContato);

				query.executeUpdate();
				session.getTransaction().commit();
			break;
			
			case 4: // CPF
				session.beginTransaction();
				query = session.createQuery( "UPDATE Responsavel p SET p.cpf = :cpf WHERE p.id = :id" );

				System.out.print("\nPara o ID... : ");
				findId = a.nextLong();
				query.setParameter("id", findId);

				System.out.print("Digite o CPF: ");
				String newCpf = b.nextLine();
				query.setParameter("cpf", newCpf);

				query.executeUpdate();
				session.getTransaction().commit();
				break;

			case 5:// Endereço
				session.beginTransaction(); 
				query = session.createQuery( "UPDATE Responsavel p SET p.endereco = :endereco WHERE p.id = :id" );

				System.out.print("\nPara o ID... : ");
				findId = a.nextLong();
				query.setParameter("id", findId);

				System.out.print("Digite nome do Endereço: ");
				String newEndereco = b.nextLine();
				query.setParameter("endereco", newEndereco);

				query.executeUpdate();
				session.getTransaction().commit();
				break;
			
			default:
				break;
		}
		
	}

	public static void findResponsavel(Session session){
		Scanner f = new Scanner(System.in);
		System.out.print("Digite o ID de quem você deseja pesquisar:");
		Long idfind = f.nextLong();

		Responsavel responsavel = session.find(Responsavel.class, idfind);
		System.out.println( "\n" + responsavel.getId() + " - " + responsavel.getNome() + " - " + responsavel.getCpf() + " - " + responsavel.getDataNascimento() + " - " + responsavel.getContato() + " - " + responsavel.getEndereco());
	}

}