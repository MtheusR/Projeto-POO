package org.modelos;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PreRemove;


@Entity
public class Frequencia{

    @Id
    @GeneratedValue
    private Long id;

    protected Calendar data;
    protected Boolean presenca;

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


