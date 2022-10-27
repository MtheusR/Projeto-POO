package org.auxiliares.inputs;

import java.util.*;

import javax.persistence.Query;

import org.hibernate.Session;

import org.modelos.*;

public class Aluno_in {
    public Aluno createAluno(Session session){

		System.out.println("! ------------------------------------------------------------------------------ !");
		System.out.println("! -- Certifique-se de já haver criado um responsavel antes de criar um aluno  -- !");
		System.out.println("! ---                Assim como as turmas que deverão existir                --- !");
		System.out.println("! ------------------------------------------------------------------------------ !");

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
		System.out.println("\n--- READ ALUNO ---");
		List result = session.createQuery( "from Aluno").list();
		System.out.println("ID | Nome | CPF | Data de Nascimento | Contato | Tipo de Pagamento | Nivel Escolar | Observação ");
		for ( Aluno aluno : (List<Aluno>) result ) {
			System.out.println( "\n" + aluno.getId() + " - " + aluno.getNome() + " - " + aluno.getCpf() + " - " + aluno.getDataNascimento() + " - " + aluno.getContato() + " - " + aluno.getTipoPag() + " - " + aluno.getNivelEscolar() + " - " + aluno.getObservacao());
		}
	}

	public static void findAluno(Session session){
		Scanner f = new Scanner(System.in);
		System.out.print("Digite o ID de quem você deseja pesquisar:");
		Long idfind = f.nextLong();

		Aluno aluno = session.find(Aluno.class, idfind);
		System.out.println( "\n" + aluno.getId() + " - " + aluno.getNome() + " - " + aluno.getCpf() + " - " + aluno.getDataNascimento() + " - " + aluno.getContato() + " - " + aluno.getTipoPag() + " - " + aluno.getNivelEscolar() + " - " + aluno.getObservacao());
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

	public static void updateAluno(Session session) {
		Scanner a = new Scanner(System.in); //Long
		Scanner b = new Scanner(System.in); //Line
		Scanner c = new Scanner(System.in); 

		System.out.println("\n--- UPDATE ---");
		System.out.print("\nEscolha um atributo a ser modificado\nN - Nome\nDT - Data Nascimento\nCT - Contato\nC - CPF\nNE - Nivel Escolar\nO - Observação\nTP - Tipo de pagamento\nT - Turma\nR - esponsavel\nEscolha uma opção do nosso menu: ");

		String escolha = c.nextLine().toUpperCase();

		switch (escolha) {
			case "N": //NOME
				session.beginTransaction();
				Query query = session.createQuery("UPDATE Aluno a SET a.nome = :nome WHERE a.id = :id");
				
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

			case "DT": // DATA NASCIMENTO
				session.beginTransaction();
				query = session.createQuery( "UPDATE Aluno p SET p.datanascimento = :datanasci WHERE p.id = :id" );

				System.out.print("\nPara o ID... : ");
				findId = a.nextLong();
				query.setParameter("id", findId);

				System.out.print("Digite a data de nascimento: ");
				String newDatanasci = b.nextLine();
				query.setParameter("datanasci", newDatanasci);

				query.executeUpdate();
				session.getTransaction().commit();
				break;

			case "CT": // CONTATO
				session.beginTransaction();
				query = session.createQuery( "UPDATE Aluno p SET p.contato = :contato WHERE p.id = :id" );

				System.out.print("\nPara o ID... : ");
				findId = a.nextLong();
				query.setParameter("id", findId);

				System.out.print("Digite o contato: ");
				String newContato = b.nextLine();
				query.setParameter("contato", newContato);

				query.executeUpdate();
				session.getTransaction().commit();
			break;
			
			case "C": // CPF
				session.beginTransaction();
				query = session.createQuery( "UPDATE Aluno p SET p.cpf = :cpf WHERE p.id = :id" );

				System.out.print("\nPara o ID... : ");
				findId = a.nextLong();
				query.setParameter("id", findId);

				System.out.print("Digite o CPF: ");
				String newCpf = b.nextLine();
				query.setParameter("cpf", newCpf);

				query.executeUpdate();
				session.getTransaction().commit();
				break;
			
			case "NE": // NÍVEL ESCOLAR
				session.beginTransaction();
				query = session.createQuery( "UPDATE Aluno p SET p.nivelEscolar = :nivelescolar WHERE p.id = :id");

				System.out.print("\nPara o ID... : ");
				findId = a.nextLong();
				query.setParameter("id", findId);

				System.out.print("Digite o Nível Escolar: ");
				String newNivel = b.nextLine();
				query.setParameter("nivelEscolar", newNivel);

				query.executeUpdate();
				session.getTransaction().commit();
			break;

			case "O":// OBSERVACAO
				session.beginTransaction(); 
				query = session.createQuery( "UPDATE Aluno p SET p.observacao = :observacao WHERE p.id = :id" );

				System.out.print("\nPara o ID... : ");
				findId = a.nextLong();
				query.setParameter("id", findId);

				System.out.print("Digite uma Observação do Aluno(a), se houver: ");
				String newobservacao = b.nextLine();
				query.setParameter("observacao", newobservacao);

				query.executeUpdate();
				session.getTransaction().commit();
				break;

			case "TP": // TipoPagamento
				session.beginTransaction(); 
				query = session.createQuery( "UPDATE Aluno p SET p.tipoPag = :tipopag WHERE p.id = :id" );

				System.out.print("\nPara o ID... : ");
				findId = a.nextLong();
				query.setParameter("id", findId);

				System.out.print("Digite o Tipo de Pagamento: ");
				String newPagamento = b.nextLine();
				query.setParameter("tipopag", newPagamento);

				query.executeUpdate();
				session.getTransaction().commit();
				break;
			
			case "T": // Turma
				session.beginTransaction();
				query = session.createQuery( "UPDATE Aluno p SET p.turma_aluno = :turma_aluno WHERE p.id = :id" );

				System.out.print("\nPara o ID... : ");
				findId = a.nextLong();
				query.setParameter("id", findId);

				System.out.print("Digite o ID da Turma: ");
				String newTurma = b.nextLine();
				query.setParameter("turma", newTurma);

				query.executeUpdate();
				session.getTransaction().commit();
				break;

			case "R":// Responsavel
				session.beginTransaction(); 
				query = session.createQuery( "UPDATE Aluno p SET p.aluno.responsavel = :responsavel_aluno WHERE p.id = :id" );

				System.out.print("\nPara o ID... : ");
				findId = a.nextLong();
				query.setParameter("id", findId);

				System.out.print("Digite nome do Responsável: ");
				String newResponsavel = b.nextLine();
				query.setParameter("aluno.responsavel", newResponsavel);

				query.executeUpdate();
				session.getTransaction().commit();
				break;
			default:
				break;
		}
		
	}


}

