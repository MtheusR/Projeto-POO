package org.auxiliares.inputs;

import java.util.Calendar;
import java.util.Scanner;

import javax.persistence.EntityManager;

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

		/*Scanner g = new Scanner(System.in);
		System.out.print("ID da Turma que ela irá participar:");
		Long idFindAdd = g.nextLong();
		Responsavel responsavel = session.find(Responsavel.class, idFindAdd);
		responsavel.addAluno(aluno);
		
		/*Scanner g = new Scanner(System.in);
		System.out.print("ID da Professora: ");
		Long idFindAdd = g.nextLong();
		Professora professora = session.find(Professora.class, idFindAdd);
		turma.addProfessora(professora);*/


        return frequencia;
	}
}
