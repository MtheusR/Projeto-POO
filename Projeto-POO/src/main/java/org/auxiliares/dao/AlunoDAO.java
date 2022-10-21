package org.auxiliares.dao;

import org.hibernate.Session;
import org.modelos.Aluno;

public class AlunoDAO {
    //Responsavel responsavel;
    Aluno aluno;
    Session session;

    public AlunoDAO(Aluno aluno, Session session) {
        this.aluno = aluno;
        this.session = session;
    }
    
    public void create(){

        this.session.beginTransaction();
		session.save( this.aluno );
		session.getTransaction().commit();

    }
}
