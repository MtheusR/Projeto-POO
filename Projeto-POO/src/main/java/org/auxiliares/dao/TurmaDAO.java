package org.auxiliares.dao;

import org.hibernate.Session;

import org.modelos.Turma;

public class TurmaDAO {

    Turma turma;
    Session session;

    public TurmaDAO(Turma turma, Session session) {
        this.turma = turma;
        this.session = session;
    }
    
    public void create(){
        this.session.beginTransaction();
        session.save( this.turma );
        session.getTransaction().commit();
    }
}
