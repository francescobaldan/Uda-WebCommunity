/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import Mapping.Artista;
import Mapping.Categoria;
import Mapping.Evento;
import Mapping.Membro;
import Mapping.Recensione;
import Mapping.RecensionePK;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author FSEVERI\sbrizza3331
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration()
                    .addPackage("Mapping")
                    .addAnnotatedClass(Artista.class)
                    .addAnnotatedClass(Categoria.class)
                    .addAnnotatedClass(Evento.class)
                    .addAnnotatedClass(Membro.class)
                    .addAnnotatedClass(Recensione.class)
                    .addAnnotatedClass(RecensionePK.class)
                    .configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
