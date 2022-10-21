package org.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Aluno extends Pessoa {
    

    private Long id;
    
    protected String tipoPag;
    protected String nivelEscolar;
    protected String observacao;

    public Aluno() {

    }

    @Id
    @GeneratedValue
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

}
