/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapping.Membro;
import hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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
            listaM=session.createQuery("From Membro").list();
            tx.commit();
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return listaM;
      
    }
    
    public List<Membro> showMembriNoCommento(){
        Session session = sessionFactory.openSession();
        Transaction tx=null;
        List listaM=null;
        try{
            tx=session.beginTransaction();
            listaM=session.createQuery("SELECT idMembro, nickname FROM Membro MINUS (SELECT idMembro FROM Recensione)").list();
            tx.commit();
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return listaM;
      
    }
    
    public Membro checkLogin(String nickname, String password)
    {        
        Session session = sessionFactory.openSession();
        
        String hql = "FROM Membro WHERE nickname = :nick";
        Query query = session.createQuery(hql);
        query.setString("nick", nickname);
        Membro registered = (Membro) query.uniqueResult();
        
        session.close();

        if (registered != null && (nickname.equals(registered.getNickname()) && password.equals(registered.getPassword())))
        {
            return registered;
        }
        return null;
    }

    public Membro register(String username, String password, String name, String surname, String mail)
    {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        
        Membro m = null;
        
        try
        {
            tx = session.beginTransaction();

            m = new Membro(username, password, name, surname, mail);
            
            session.save(m);

            tx.commit();
        } catch (HibernateException e)
        {
            tx.rollback();
            e.printStackTrace();
            return null;
        } finally
        {
            session.close();
        }

        return m;
    }
    
}