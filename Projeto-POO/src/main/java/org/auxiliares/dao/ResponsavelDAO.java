package org.auxiliares.dao;

import org.hibernate.Session;
import org.modelos.Responsavel;

public class ResponsavelDAO {
    Responsavel responsavel;
    Session session;

    public ResponsavelDAO(Responsavel responsavel, Session session) {

        this.responsavel = responsavel;
        this.session = session;

    }
    
    public void create(){
        this.session.beginTransaction();
        session.save( this.responsavel );
        session.getTransaction().commit();

    }
}
