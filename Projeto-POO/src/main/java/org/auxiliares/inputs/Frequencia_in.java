package org.auxiliares.inputs;

import java.util.Calendar;
import java.util.Scanner;

import javax.persistence.EntityManager;
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
}
