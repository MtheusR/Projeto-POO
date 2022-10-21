package org.modelos;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.auxiliares.dao.AlunoDAO;
import org.auxiliares.inputs.Aluno_in;
import org.auxiliares.inputs.Responsavel_in;

@Entity
public class Responsavel extends Pessoa{

    @Id
    @GeneratedValue
    private Long id;

    protected String endereco;

    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name = "responsavel_aluno")	
	private List<Aluno> aluno = new ArrayList<Aluno>();

    public Responsavel() {

    }

    public List<Aluno> getAluno() {
        return aluno;
    }
    public void setAluno(List<Aluno> aluno) {
        this.aluno = aluno;
    }

    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    protected void addAluno(Aluno a) {
		if (aluno == null) {
			aluno = new ArrayList<Aluno>();
		}

		this.aluno.add(a);
	}

}


