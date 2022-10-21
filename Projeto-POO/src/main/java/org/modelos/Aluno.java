package org.modelos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Aluno extends Pessoa {
    
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    @JoinColumn (name = "aluno_id")
    protected List<Responsavel> responsavel = new ArrayList<>();
    
    protected String tipoPag;
    protected String nivelEscolar;
    protected String observacao;

    public Aluno() {

    }
    
    public String getTipoPag() {
        return tipoPag;
    }
    public void setTipoPag(String tipoPag) {
        this.tipoPag = tipoPag;
    }

    
    public List<Responsavel> getResponsavel() {
        return responsavel;
    }
    public void setResponsavel(List<Responsavel> responsavel) {
        this.responsavel = responsavel;
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
