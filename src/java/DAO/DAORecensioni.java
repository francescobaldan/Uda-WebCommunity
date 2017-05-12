/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapping.Evento;
import Mapping.Recensione;
import Mapping.RecensionePK;
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
    
    public void addRecensione(int idMembro, int idEvento, String commento, int voto){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            Recensione rec=new Recensione(idMembro, idEvento, commento, voto);
            session.save(rec);
            tx.commit();    
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return ;
    }
    
    public void deleteRecensione(int idM, int idE){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        List<Recensione> listaR=null;
        RecensionePK key= new RecensionePK(idM, idE);
        try{
            tx=session.beginTransaction();
            listaR=session.createQuery("From Recensione").list();
            for(int i=0; i<listaR.size(); i++){
                Recensione temp=listaR.get(i);
                if(temp.getRecensionePK().equals(key)==true){
                    session.delete(temp);
                }
            }
            tx.commit();    
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return ;
    }
    
    public void updateRecensione(int idMembro, int idEvento, String commento, int voto){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            Recensione rec=new Recensione(idMembro, idEvento, commento, voto);
            session.update(rec);
            tx.commit();    
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return ;
    }
    
    public List<Recensione> showRecensioniEvento(int idE){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        List<Recensione> listaR=null;
        List<Evento> event=null;
        try{
            tx=session.beginTransaction();
            event=session.createQuery("From Evento Where idEvento="+idE).list();
            listaR=session.createQuery("From Recensione Where evento="+event.get(0)).list();
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

