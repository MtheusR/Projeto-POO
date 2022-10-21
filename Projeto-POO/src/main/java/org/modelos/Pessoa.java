package org.modelos;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class Pessoa implements Serializable {

	protected Long id;
	protected String cpf;
	protected String nome;
	protected String dt_nascimento;
	protected String contato;
	
	@Id
    @GeneratedValue(generator="increment")
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNascimento(){
		return dt_nascimento;
	}
	public void setDataNascimento(String dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}
	public String getContato(){
		return contato;
	}
	public void setContato(String contato){
		this.contato = contato;
	}

	// @Override
	// public void createPessoa(Pessoa pessoa, Session session){
	// 	session.beginTransaction();
	// 	Scanner c = new Scanner(System.in); 

							
	// 	System.out.print("\nNome: ");
	// 	String nome = c.nextLine();
	// 	pessoa.setNome(nome);

	// 	System.out.print("CPF: ");
	// 	String cpf = c.nextLine();
	// 	pessoa.setCpf(cpf);

	// 	System.out.print("Data de Nascimento: ");
	// 	String dataNasci = c.nextLine();
	// 	pessoa.setDataNascimento(dataNasci);

	// 	System.out.print("Contato: ");
	// 	String contato = c.nextLine();
	// 	pessoa.setContato(contato);

	// 	session.save( pessoa );
	// 	session.getTransaction().commit();
	// }

	// @Override
	// public void selectPessoa(Session session) {
	// 	System.out.println("\n--- SELECT ---");
	// 	session.clear();
	// 	List result = session.createQuery( "from Pessoa" ).list();
	// 	for ( Pessoa pessoa : (List<Pessoa>) result ) {
	// 		System.out.println( pessoa.getId() + " - " + pessoa.getNome() + " - " + pessoa.getCpf() + " - " + pessoa.getDataNascimento() + " - " + pessoa.getContato());
	// 	}
	// }

	// @Override
	// public void updatePessoa(Session session) {
	// 	Query query_U = null;
	// 	Long findId;
		
	// 	Scanner a = new Scanner(System.in); 
	// 	Scanner uL = new Scanner(System.in);
	// 	Scanner uS = new Scanner(System.in);

	// 	System.out.println("\n--- UPDATE com WHERE ---");
	// 	session.beginTransaction();
	// 	System.out.println("\sN - ome\n D - ata de Nascimento\n C - ontato");
		
	// 	System.out.print("Escolha a opção do atributo que deseja alterar: ");
	// 	String attribute = a.nextLine().toUpperCase();

	// 	switch (attribute) {
	// 		case "N": //NOME
	// 			selectPessoa(session);
	// 			query_U = session.createQuery( "UPDATE Pessoa p SET p.nome = :nome WHERE p.id = :id" );

	// 			System.out.print("\nPara o ID... : ");
	// 			findId = uL.nextLong();
	// 			query_U.setParameter("id", findId);
				
	// 			System.out.print("Digite o nome: ");
	// 			String newnome = uS.nextLine();
	// 			query_U.setParameter("nome", newnome);

	// 			query_U.executeUpdate();
	// 			session.getTransaction().commit();	
	// 			break;
				
	// 		case "D": // DATA NASCIMENTO
	// 			selectPessoa(session);
	// 			query_U = session.createQuery( "UPDATE Pessoa p SET p.datanascimento = :datanasci WHERE p.id = :id" );

	// 			System.out.print("Para o ID... : ");
	// 			findId = uL.nextLong();
	// 			query_U.setParameter("id", findId);

	// 			System.out.print("Digite a data de nascimento: ");
	// 			String newdatanasci = uS.nextLine();
	// 			query_U.setParameter("datanasci", newdatanasci);

	// 			query_U.executeUpdate();
	// 			session.getTransaction().commit();
	// 			break;

	// 		case "C": // CONTATO
	// 			selectPessoa(session);
	// 			query_U = session.createQuery( "UPDATE Pessoa p SET p.contato = :contato WHERE p.id = :id" );
				
	// 			System.out.print("Para o ID... : ");
	// 			findId = uL.nextLong();
	// 			query_U.setParameter("id", findId);

	// 			System.out.print("Digite o contato: ");
	// 			String newcontato = uS.nextLine();
	// 			query_U.setParameter("contato", newcontato);

	// 			query_U.executeUpdate();
	// 			session.getTransaction().commit();
	// 			break;
		
	// 		default:
	// 			break;
	// 	}
		
	// }

	// @Override
	// public void deletePessoa(Session session) {
		
	// 	Scanner d = new Scanner(System.in);

	// 	System.out.println("\n--- DELETE ---");
	// 	session.beginTransaction();
	// 	Query query_D = session.createQuery( "DELETE FROM Pessoa p WHERE p.id = :id" );

	// 	System.out.print("Digite o ID que deseja deletar: ");
	// 	Long findId = d.nextLong();

	// 	query_D.setParameter("id", findId);
	// 	query_D.executeUpdate();
	// 	session.getTransaction().commit();
	// }

	// @Override
	// public void findPessoa(Session session) {
	// 	Scanner f = new Scanner(System.in);

	// 	System.out.println("\n--- DELETE ---");
	// 	System.out.print("Digite o ID que deseja pesquisar: ");
	// 	Long findId = f.nextLong();
	// 	Aluno aluno = session.find( Aluno.class, findId );

	// }
}
