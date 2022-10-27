package org.modelos;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Query;

import org.hibernate.Session;

@Entity
public class Turma {

    @Id
    @GeneratedValue
    private Long id;

    protected String data;
    protected String horario; 

    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "turma_aluno")	
    private List<Aluno> aluno = new ArrayList<Aluno>();

    public Turma() {
    }

    public String getData(){
        return data;
    }
    public void setData(String data){
        this.data = data;
    }

    public String getHorario(){
        return data;
    }
    public void setHorario(String horario){
        this.horario = horario;
    }

    public List<Aluno> getAluno() {
        return aluno;
    }
    public void setAluno(List<Aluno> aluno) {
        this.aluno = aluno;
    }

    public void addAluno(Aluno a) {
		if (aluno == null) {
			aluno = new ArrayList<Aluno>();
		}
		aluno.add(a);
	}

}
