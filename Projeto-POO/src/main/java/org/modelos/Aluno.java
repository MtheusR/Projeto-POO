package org.modelos;

//import java.util.*;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/*import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;*/

@Entity
public class Aluno extends Pessoa {
    
    @Id
    @GeneratedValue
    private Long id;
    
    protected String tipoPag;
    protected String nivelEscolar;
    protected String observacao;

    /*@OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "aluno_responsavel")	
    private List<Responsavel> responsavel = new ArrayList<Responsavel>();*/

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
    
    /*public List<Responsavel> getResponsavel() {
        return responsavel;
    }
    public void setResponsavel(List<Responsavel> responsavel) {
        this.responsavel = responsavel;
    }
    public void addResponsavel(Responsavel r) {
		if (responsavel == null) {
			responsavel = new ArrayList<Responsavel>();
		}
		responsavel.add(r);
	}*/

}
