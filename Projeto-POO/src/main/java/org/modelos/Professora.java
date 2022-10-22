package org.modelos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.util.*;

@Entity
public class Professora extends Pessoa{

    @Id
    @GeneratedValue
    private Long id;

    protected String endereco;


    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "turma_Professora")	
    private List<Turma> turma = new ArrayList<Turma>();

    public Professora() {
    }

    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public List<Turma> getTurma() {
        return turma;
    }
    public void setTurma(List<Turma> turma) {
        this.turma = turma;
    }

    public void addTurma(Turma t) {
		if (turma == null) {
			turma = new ArrayList<Turma>();
		}
		turma.add(t);
    }

}
