package org.modelos;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private SessionFactory sessionFactory;

    public synchronized SessionFactory getSessionFactory() {
        if ( sessionFactory == null ) {

            // exception handling omitted for brevity

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml")
                    .build();

            sessionFactory = new MetadataSources( serviceRegistry )
                    .buildMetadata()
                    .buildSessionFactory();
        }
        return sessionFactory;
    }

    protected void desligar(SessionFactory sessionFactory) throws Exception {
        if ( sessionFactory != null ) {
            sessionFactory.close();
        }
    }
}
