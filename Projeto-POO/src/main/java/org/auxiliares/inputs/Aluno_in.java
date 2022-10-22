package org.auxiliares.inputs;

import java.util.Scanner;

import javax.persistence.EntityManager;

import java.util.*;

import org.hibernate.Session;


import org.modelos.Aluno;
import org.modelos.Responsavel;
import org.modelos.Turma;

public class Aluno_in {
    public Aluno createAluno(EntityManager session){
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

		//CREAT TURMA    
		
        return aluno;
	}

	public static void readAluno(Session session){
		System.out.println("\n--- SELECT ---");
		List result = session.createQuery( "from Aluno").list();
		for ( Aluno aluno : (List<Aluno>) result ) {
		System.out.println( "\n" + aluno.getId() + " - " + aluno.getNome() + " - " + aluno.getCpf() + " - " + aluno.getDataNascimento() + " - " + aluno.getContato() + " - " + aluno.getTipoPag() + " - " + aluno.getNivelEscolar() + " - " + aluno.getObservacao());
		}
	}
	
}
