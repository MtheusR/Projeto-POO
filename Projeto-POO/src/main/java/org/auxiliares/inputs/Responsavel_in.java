package org.auxiliares.inputs;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import org.modelos.Responsavel;

public class Responsavel_in {
    public Responsavel createResponsavel(){
		Responsavel responsavel = new Responsavel();

		Scanner c = new Scanner(System.in); 
							
		System.out.print("\nNome: ");
		String nome = c.nextLine();
		responsavel.setNome(nome);

		System.out.print("CPF: ");
		String cpf = c.nextLine();
		responsavel.setCpf(cpf);

		System.out.print("Data de Nascimento: ");
		String dataNasci = c.nextLine();
		responsavel.setDataNascimento(dataNasci);

		System.out.print("Contato: ");
		String contato = c.nextLine();
		responsavel.setContato(contato);

		System.out.print("Endereço: ");
		String endereco = c.nextLine();
		responsavel.setEndereco(endereco);

        return responsavel;
	}

	public static void readResponsavel(Session session){
		System.out.println("\n--- SELECT ---");
		List result = session.createQuery( "from Responsavel" ).list();
		for ( Responsavel responsavel : (List<Responsavel>) result) {
		System.out.println( "\n" + responsavel.getId() + " - " + responsavel.getNome() + " - " + responsavel.getCpf() + " - " + responsavel.getDataNascimento() + " - " + responsavel.getContato() + " - " + responsavel.getEndereco() + " - " + responsavel.getEndereco());
		}
	}

}
