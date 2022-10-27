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
}
