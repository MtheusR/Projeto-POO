package org.auxiliares.inputs;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.modelos.Turma;

public class Turma_in {
    public Turma createTurma(Session session){
        Turma turma = new Turma();

        Scanner c = new Scanner(System.in); 

        System.out.print("\nDia da Semana => [ SEGUNDA - TERÇA - QUARTA - QUINTA ]: ");
		String data = c.nextLine().toUpperCase();
		turma.setData(data);

		System.out.print("Horario => [TURMA 1] - 13H ÁS 14:30 | [TURMA 2] - 15H ÁS 16:30 | [TURMA 3] - 17H ÁS 18:30: ");
		String horario = c.nextLine().toUpperCase();
		turma.setHorario(horario);

        return turma;
	}

	public static void deleteTurma(Session session) {
		System.out.println("\n--- DELETE ---");
		session.beginTransaction();

		Scanner f = new Scanner(System.in);
		Query query = session.createQuery( "DELETE FROM Turma a WHERE a.id = :id");
		System.out.print("Digite o ID de quem você deseja pesquisar:");
		Long idfind = f.nextLong();
		Turma turma = session.find(Turma.class, idfind);
		// session.remove(turma);
		turma.setAluno(null);
		query.setParameter("id", idfind);
		query.executeUpdate();
		session.getTransaction().commit();
	}

	public static void readTurma(Session session){
		System.out.println("\n--- READ TURMA ---");
		List result = session.createQuery( "from Turma").list();
		
		for ( Turma turma : (List<Turma>) result ) {
			System.out.println( "\n" + turma.getId() + " - " + turma.getData() + " - " + turma.getHorario());
		}
	}

	public static void updateTurma(Session session) {
		Scanner a = new Scanner(System.in); //Long
		Scanner b = new Scanner(System.in); //Line
		Scanner c = new Scanner(System.in); 

		System.out.println("\n--- UPDATE ---");
		System.out.print("\nEscolha um atributo a ser modificado\n[1] - Data\n[2] - Horário\nEscolha uma das opções do nosso menu: ");

		int escolha = c.nextInt();

		switch (escolha) {
			case 1: //NOME
				session.beginTransaction();
				Query query = session.createQuery("UPDATE Turma a SET a.data = :data WHERE a.id = :id");
				
				System.out.print("\nPara o ID... : ");
				Long findId = a.nextLong();
				query.setParameter("id", findId);

				System.out.print("Digite o nome da data: ");
				String newdata = b.nextLine();
				query.setParameter("data", newdata);

				query.executeUpdate();
				session.flush();
				session.getTransaction().commit();	
				break;	

			case 2: //NOME
				session.beginTransaction();
				query = session.createQuery("UPDATE Turma a SET a.horario = :horario WHERE a.id = :id");
				
				System.out.print("\nPara o ID... : ");
				findId = a.nextLong();
				query.setParameter("id", findId);

				System.out.print("Digite o nome da data: ");
				String newhorario = b.nextLine();
				query.setParameter("horario", newhorario);

				query.executeUpdate();
				session.flush();
				session.getTransaction().commit();	
				break;	
			
			default:
				break;
		}
	}

	public static void findTurma(Session session){
		Scanner f = new Scanner(System.in);
		System.out.print("Digite o ID de quem você deseja pesquisar:");
		Long idfind = f.nextLong();

		Turma turma = session.find(Turma.class, idfind);
		System.out.println( "\n" + turma.getId() + " - " + turma.getData() + " - " + turma.getHorario());
	}
}