package org.modelos;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Frequencia{

    @Id
    @GeneratedValue
    private Long id;

    protected Calendar data;
    protected Boolean presenca;

    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name = "responsavel_aluno")	
	private List<Aluno> aluno = new ArrayList<Aluno>();

    public Frequencia() {

    }


    public Calendar getData(){
        return data;
    }
    public void setData(Calendar data){
        this.data = data;
    }


    public Boolean getPresenca(){
        return presenca;
    }
    public void setPresenca(Boolean presenca){
        this.presenca = presenca;
    }

}


