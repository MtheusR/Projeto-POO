package org.auxiliares.inputs;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.modelos.Turma;

public class Turma_in {
    public Turma createTurma(EntityManager session){
        Turma turma = new Turma();

        Scanner c = new Scanner(System.in); 

        System.out.print("\nDia da Semana: SEGUNDA - TERÇA - QUARTA - QUINTA: ");
		String data = c.nextLine();
		turma.setData(data);

		System.out.print("Horario: [TEMPO 1] - 13H ÁS 14:30 | [TEMPO 2] - 15H ÁS: ");
		String horario = c.nextLine();
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
}