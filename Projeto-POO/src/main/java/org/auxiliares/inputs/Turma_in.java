package org.auxiliares.inputs;

import java.util.Scanner;

import javax.persistence.EntityManager;

//import org.modelos.Professora;
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


        return turma;
	}
}