package org.auxiliares.inputs;

import java.util.Calendar;
import java.util.*;

import javax.persistence.Query;

import org.hibernate.Session;
import org.modelos.Aluno;
import org.modelos.Frequencia;

public class Frequencia_in {
	public Frequencia createFrequencia(Session session) {
		Frequencia frequencia = new Frequencia();

		Scanner c = new Scanner(System.in);

		System.out.print("\n[P] - Presente | [F] - Falta: ");
		String presenca = c.nextLine();
		frequencia.setPresenca(presenca);

		Date data = new Date();
		frequencia.setData(data);

		Scanner g = new Scanner(System.in);
		System.out.print("ID do Aluno:");
		Long idFindAdd = g.nextLong();
		Aluno aluno = session.find(Aluno.class, idFindAdd);
		aluno.addFrequencia(frequencia);
		return frequencia;
	}

	public static void readFrequencia(Session session){
		System.out.println("\n--- READ FREQUENCIA---");
		List result = session.createQuery( "from Frequencia").list();
		
		for ( Frequencia frequencia : (List<Frequencia>) result ) {
			System.out.println( "\n" + frequencia.getId() + " - " + frequencia.getData() + " - " + frequencia.getPresenca());
		}
	}

	public static void deleteFrequencia(Session session) {
		System.out.println("\n--- DELETE ---");
		session.beginTransaction();

		Scanner f = new Scanner(System.in);
		Query query = session.createQuery("DELETE FROM Frequencia a WHERE a.id = :id");
		System.out.print("Digite o ID do Aluno a ser Deletado:");
		Long idfind = f.nextLong();
		Frequencia frequencia = session.find(Frequencia.class, idfind);
		query.setParameter("id", idfind);
		query.executeUpdate();
		session.getTransaction().commit();
	}

	public static void updateFrequencia(Session session) {
		Scanner a = new Scanner(System.in); //Long
		Scanner b = new Scanner(System.in); //Line
		Scanner c = new Scanner(System.in); 

		System.out.println("\n--- UPDATE ---");
		System.out.print("\n[1] - Presença\n[3] - Aluno\nESCOLHA: ");

		int escolha = c.nextInt();

		switch (escolha) {
			case 1: //NOME
				session.beginTransaction();
				Query query = session.createQuery("UPDATE Frequencia a SET a.presenca = :presenca WHERE a.id = :id");
				
				System.out.print("\nPara o ID... : ");
				Long findId = a.nextLong();
				query.setParameter("id", findId);

				System.out.print("Atualize a presença: ");
				Boolean newpresenca = b.nextBoolean();
				query.setParameter("presenca", newpresenca);

				query.executeUpdate();
				session.flush();
				session.getTransaction().commit();	
			break;	

			case 2: //NOME
				session.beginTransaction();
				query = session.createQuery("UPDATE Frequencia a SET a.presenca = :presenca WHERE a.id = :id");
				
				System.out.print("\nPara o ID... : ");
				findId = a.nextLong();
				query.setParameter("id", findId);

				System.out.print("Atualize a presença: ");
				Boolean newaluno = b.nextBoolean();
				query.setParameter("presenca", newaluno);

				query.executeUpdate();
				session.flush();
				session.getTransaction().commit();	
			break;	
		}
	}
}
