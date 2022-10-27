package org.modelos;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Frequencia{

    @Id
    @GeneratedValue
    private Long id;

    protected Date data;
    protected String presenca;

    public Frequencia() {

    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public Date getData(){
        return data;
    }
    public void setData(Date data){
        this.data = data;
    }


    public String getPresenca(){
        return presenca;
    }
    public void setPresenca(String presenca){
        this.presenca = presenca;
    }





}


