/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapping.Membro;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Sprizzetto
 */
public class DAOMembri {
    
    private final SessionFactory sessionFactory=hibernate.HibernateUtil.getSessionFactory();
    
    public Integer addMembro(Integer id, String nickname, String password, String nome, String cognome, String mail){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        Integer idMembro=null;

        try{
            tx=session.beginTransaction();
            Membro m=new Membro(id, nickname, password, nome, cognome, mail);
            idMembro=(Integer) session.save(m);
            tx.commit();    
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return idMembro;
    }
    
    public List<Membro> showMembri(){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        List listaM=null;
        try{
            tx=session.beginTransaction();
            listaM=session.createQuery("From MEMBRI").list();
            tx.commit();
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return listaM;
      
    }
    
    public List<Membro> showNoCommento(){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        List listaM=null;
        try{
            tx=session.beginTransaction();
            listaM=session.createQuery("SELECT IdMembro, Nickname FROM MEMBRI MINUS (SELECT IdMembro FROM RECENSIONI)").list();
            tx.commit();
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return listaM;
      
    }
    
    
    
}