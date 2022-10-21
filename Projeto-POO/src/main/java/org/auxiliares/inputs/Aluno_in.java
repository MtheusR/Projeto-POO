package org.auxiliares.inputs;

import java.util.Scanner;
import java.util.List;

import org.hibernate.Session;

import org.modelos.Aluno;

public class Aluno_in {
    public Aluno createAluno(){
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
        
        //Turmas
        //Frequencia
        
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
