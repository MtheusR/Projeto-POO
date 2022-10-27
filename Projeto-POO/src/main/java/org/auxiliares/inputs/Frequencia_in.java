package org.auxiliares.inputs;

import java.util.Calendar;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.modelos.Aluno;
import org.modelos.Frequencia;

public class Frequencia_in {
    public Frequencia createFrequencia(EntityManager session){
        Frequencia frequencia = new Frequencia();

        Scanner c = new Scanner(System.in); 

        System.out.print("\n[TRUE] - Presente | [FALSE] - Falta: ");
		boolean presenca = c.nextBoolean();
		frequencia.setPresenca(presenca);

        Calendar Cal = Calendar.getInstance();
        frequencia.setData(Cal);

		Scanner g = new Scanner(System.in);
		System.out.print("ID do Aluno:");
		Long idFindAdd = g.nextLong();
		Aluno aluno = session.find(Aluno.class, idFindAdd);
		aluno.addFrequencia(frequencia);
        return frequencia;
	}

	public static void deleteFrequencia(Session session) {
		System.out.println("\n--- DELETE ---");
		session.beginTransaction();

		Scanner f = new Scanner(System.in);
		Query query = session.createQuery( "DELETE FROM Frequencia a WHERE a.id = :id" );
		System.out.print("Digite o ID do Aluno a ser Deletado:");
		Long idfind = f.nextLong();
		Frequencia frequencia = session.find(Frequencia.class, idfind);
		//aluno.setFrequencia(null);
		query.setParameter("id", idfind);
		query.executeUpdate();
		session.getTransaction().commit();
	}
}
