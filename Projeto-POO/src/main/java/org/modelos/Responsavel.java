package org.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Responsavel extends Pessoa{

    @Id
    @GeneratedValue
    private Long id;

    protected String endereco;

    public Responsavel() {

    }

    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public static Aluno find(Class<Aluno> class1, long l) {
        return null;
    }

}


