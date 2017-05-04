/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapping.Recensione;
import java.util.Calendar;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Sprizzetto
 */
public class DAORecensioni {
    
    private final SessionFactory sessionFactory=hibernate.HibernateUtil.getSessionFactory();
    
    public Integer addRecensione(int idMembro, int idEvento, String commento, int voto){
        Session session = sessionFactory.openSession();
        Transaction tx=null;
        Integer idRecensione=null;

        try{
            tx=session.beginTransaction();
            Recensione rec=new Recensione(idMembro, idEvento, commento, voto);
            idRecensione=(Integer) session.save(rec);
            tx.commit();    
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return idRecensione;
    }
    
    public List<Recensione> showRecensioni(){
        Session session = sessionFactory.openSession();
        Transaction tx=null;
        List listaR=null;
        try{
            tx=session.beginTransaction();
            listaR=session.createQuery("From RECENSIONI").list();
            tx.commit();
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return listaR;
      
    }
}

