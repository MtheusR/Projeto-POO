package org.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Professora extends Pessoa{

    @Id
    @GeneratedValue
    private Long id;

    protected String endereco;
    //<Turma> rsrs

    public Professora() {
    }

    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

}
