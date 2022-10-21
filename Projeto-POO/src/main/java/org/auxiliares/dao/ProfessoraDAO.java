package org.auxiliares.dao;

import org.hibernate.Session;
import org.modelos.Professora;

public class ProfessoraDAO {
    Professora professora;
    Session session;

    public ProfessoraDAO(Professora professora, Session session) {

        this.professora = professora;
        this.session = session;

    }
    
    public void create(){
        this.session.beginTransaction();
        session.save( this.professora );
        session.getTransaction().commit();

    }
}
