package org.auxiliares.dao;

import org.hibernate.Session;
import org.modelos.Frequencia;

public class FrequenciaDAO {
    Frequencia frequencia;
    Session session;

    public FrequenciaDAO(Frequencia frequencia, Session session) {
        this.frequencia = frequencia;
        this.session = session;
    }
    
    public void create(){
        this.session.beginTransaction();
        session.save( this.frequencia );
        session.getTransaction().commit();
    }
}
