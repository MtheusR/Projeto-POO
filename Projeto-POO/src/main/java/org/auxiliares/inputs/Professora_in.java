package org.auxiliares.inputs;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;

import org.modelos.Professora;
import org.modelos.Turma;

public class Professora_in {
    public Professora createProfessora(Session session){

		System.out.println("\n ! ------------------------------------------------------------------------------ !");
		System.out.println(" ! ---  Certifique-se já haver criado uma turma antes de criar uma Professora --- !");
		System.out.println(" ! ------------------------------------------------------------------------------ !");

		Professora professora = new Professora();

		Scanner c = new Scanner(System.in); 
							
		System.out.print("\nNome: ");
		String nome = c.nextLine();
		professora.setNome(nome);

		System.out.print("CPF: ");
		String cpf = c.nextLine();
		professora.setCpf(cpf);

		System.out.print("Data de Nascimento: ");
		String dataNasci = c.nextLine();
		professora.setDataNascimento(dataNasci);

		System.out.print("Contato: ");
		String contato = c.nextLine();
		professora.setContato(contato);

		System.out.print("Endereço: ");
		String endereco = c.nextLine();
		professora.setEndereco(endereco);

		Scanner g = new Scanner(System.in);
		System.out.print("ID da Turma: ");
		Long idFindAdd = g.nextLong();
		Turma turma = session.find(Turma.class, idFindAdd);
		professora.addTurma(turma);

        return professora;
	}

	public static void findProfessora(Session session){
		Scanner f = new Scanner(System.in);
		System.out.print("Digite o ID de quem você deseja pesquisar:");
		Long idfind = f.nextLong();

		Professora professora = session.find(Professora.class, idfind);
		System.out.println( "\n" + professora.getId() + " - " + professora.getNome() + " - " + professora.getCpf() + " - " + professora.getDataNascimento() + " - " + professora.getContato() + " - " + professora.getEndereco());
	}

	public static void readProfessora(Session session){
		System.out.println("\n--- SELECT ---");
		List result = session.createQuery( "from Professora" ).list();
		System.out.println("ID | Nome | CPF | Data de Nascimento | Contato | Endereço ");
		for ( Professora professora : (List<Professora>) result) {
		System.out.println( "\n" + professora.getId() + " - " + professora.getNome() + " - " + professora.getCpf() + " - " + professora.getDataNascimento() + " - " + professora.getContato() + " - " + professora.getEndereco());
		}
	}

	public static void deleteProfessora(Session session) {
		System.out.println("\n--- DELETE ---");
		session.beginTransaction();

		Scanner f = new Scanner(System.in);
		Query query = session.createQuery( "DELETE FROM Professora a WHERE a.id = :id" );
		System.out.print("Digite o ID da Professora a ser deletada: ");
		Long idfind = f.nextLong();
		Professora professora = session.find(Professora.class, idfind);
		professora.setTurma(null);
		session.remove(professora);
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
				Query query = session.createQuery("UPDATE Professora a SET a.nome = :nome WHERE a.id = :id");
				
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
				query = session.createQuery( "UPDATE Professora p SET p.datanascimento = :datanasci WHERE p.id = :id" );

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
				query = session.createQuery( "UPDATE Professora p SET p.contato = :contato WHERE p.id = :id" );

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
				query = session.createQuery( "UPDATE Professora p SET p.cpf = :cpf WHERE p.id = :id" );

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
				query = session.createQuery( "UPDATE Professora p SET p.endereco = :endereco WHERE p.id = :id" );

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

}
