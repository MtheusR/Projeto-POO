package org.auxiliares.inputs;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;

import org.modelos.Responsavel;

public class Responsavel_in {


	public Responsavel createResponsavel(Session session){
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

	public static void deleteResponsavel(Session session) {
		System.out.println("\n--- DELETE ---");
		session.beginTransaction();

		Scanner f = new Scanner(System.in);
		Query query = session.createQuery( "DELETE FROM Responsavel a WHERE a.id = :id" );
		System.out.print("Digite o ID do Responsável a ser Deletado:");
		Long idfind = f.nextLong();
		Responsavel responsavel = session.find(Responsavel.class, idfind);
		responsavel.setAluno(null);
		session.remove(responsavel);
		session.getTransaction().commit();
	}

}