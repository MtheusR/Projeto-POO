package org.modelos;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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

    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    

    
    public List<Aluno> getAluno() {
        return aluno;
    }
    public void setAluno(List<Aluno> responsavel) {
        this.aluno = responsavel;
    }

    public void addAluno(Aluno r) {
		if (aluno == null) {
			aluno = new ArrayList<Aluno>();
		}
		aluno.add(r);
	}

}


