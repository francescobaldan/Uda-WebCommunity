/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapping.Categoria;
import Mapping.Evento;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author FSEVERI\sbrizza3331
 */
public class DAOCategorie {
    private final SessionFactory sessionFactory=hibernate.HibernateUtil.getSessionFactory();
    
    public Integer addCategoria(Integer idCategoria, String nome, String descrizione){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        Integer idCat=null;

        try{
            tx=session.beginTransaction();
            Categoria event=new Categoria(idCategoria, nome, descrizione);
            idCat=(Integer) session.save(event);
            tx.commit();    
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return idCat;
    }
        
        
    public List<Categoria> showCategorie(){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        List<Categoria> listaC=null;
        try{
            tx=session.beginTransaction();
            listaC=session.createQuery("From Categoria").list();
            tx.commit();
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return listaC;
      
    }
    
    public List<Evento> eventiCategoria(int idC){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        List<Evento> listaE=null;
        try{
            tx=session.beginTransaction();
            listaE=session.createQuery("From Evento Where idCategoria="+idC).list();
            tx.commit();
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return listaE;
      
    }
    
    public List<Evento> eventiLuogoCategoria(int idC, String luogo){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        List<Evento> listaE=null;
        try{
            tx=session.beginTransaction();
            listaE=session.createQuery("From Evento Where idCategoria="+idC+" and luogo="+luogo).list();
            tx.commit();
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return listaE;
      
    }
}
