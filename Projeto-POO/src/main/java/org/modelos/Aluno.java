package org.modelos;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;

import org.hibernate.property.access.spi.SetterFieldImpl;

@Entity
public class Aluno extends Pessoa {
    
    @Id
    @GeneratedValue
    private Long id;
    
    protected String tipoPag;
    protected String nivelEscolar;
    protected String observacao;

    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "aluno_frequencia")	
    private List<Frequencia> frequencia = new ArrayList<Frequencia>();

    public Aluno() {

    }

    
    public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

    
    public String getTipoPag() {
        return tipoPag;
    }
    public void setTipoPag(String tipoPag) {
        this.tipoPag = tipoPag;
    }
    
    public String getNivelEscolar() {
        return nivelEscolar;
    }
    public void setNivelEscolar(String nivelEscolar) {
        this.nivelEscolar = nivelEscolar;
    }
    
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    public List<Frequencia> getFrequencia() {
        return frequencia;
    }
    public void setFrequencia(List<Frequencia> aluno) {
        this.frequencia = aluno;
    }
    public void addFrequencia(Frequencia a){
		if (frequencia == null) {
			frequencia = new ArrayList<Frequencia>();
		}
		frequencia.add(a);
	}
}  