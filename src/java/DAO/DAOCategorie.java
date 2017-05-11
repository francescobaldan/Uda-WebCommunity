/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapping.Categoria;
import Mapping.Evento;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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
    
    public Categoria cercaCategoria(int idC){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        Categoria cat=null;
        try{
            tx=session.beginTransaction();
            cat=(Categoria) session.createQuery("From Categoria Where idCategoria="+idC);
            tx.commit();
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return cat;
    }
    
        public Categoria cercaCategoria(String nome){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        Categoria cat=null;
        try{
            tx=session.beginTransaction();
            cat=(Categoria) session.createQuery("From Categoria Where nome="+nome);
            tx.commit();
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return cat;
    }
    
    public List<Evento> eventiCategoria(int idC){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        List<Evento> listaE=null;
        try{
            tx=session.beginTransaction();
            listaE=session.createQuery("Select eventiCollection From Categoria Where idCategoria="+idC+" Order by data").list();
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
        List<Evento> listaProv=null;
        ArrayList<Evento> listaE=new ArrayList<Evento>();
        try{
            tx=session.beginTransaction();
            listaProv=session.createQuery("Select eventiCollection From Categoria Where idCategoria="+idC+" Order by data").list();
            for(int i=0; i<listaProv.size(); i++){
                Evento temp=listaProv.get(i);
                if(temp.getLuogo().equals(luogo)==true){
                    listaE.add(temp);
                }
            }
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
