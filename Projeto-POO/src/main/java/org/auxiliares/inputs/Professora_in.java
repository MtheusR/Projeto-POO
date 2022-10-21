package org.auxiliares.inputs;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.modelos.Professora;

public class Professora_in {
    public Professora createProfessora(){
		Professora professora = new Professora();

		Scanner c = new Scanner(System.in); 
							
		System.out.print("\nNome: ");
		String nome = c.nextLine();
		professora.setNome(nome);

		System.out.print("CPF: ");
		String cpf = c.nextLine();
		professora.setCpf(cpf);

		System.out.print("Data de Nascimento: ");
		String dataNasci = c.nextLine();
		professora.setDataNascimento(dataNasci);

		System.out.print("Contato: ");
		String contato = c.nextLine();
		professora.setContato(contato);

		System.out.print("Endereço: ");
		String endereco = c.nextLine();
		professora.setEndereco(endereco);

        //<Turma> rsrs

        return professora;
	}

	public static void readProfessora(Session session){
		System.out.println("\n--- SELECT ---");
		List result = session.createQuery( "from Professora" ).list();
		for ( Professora professora : (List<Professora>) result) {
		System.out.println( "\n" + professora.getId() + " - " + professora.getNome() + " - " + professora.getCpf() + " - " + professora.getDataNascimento() + " - " + professora.getContato() + " - " + professora.getEndereco() + " - " + professora.getEndereco());
		}
	}
}
