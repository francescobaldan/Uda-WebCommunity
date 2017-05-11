/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapping.Categoria;
import Mapping.Evento;
import Mapping.Recensione;
import java.util.Calendar;
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
public class DAOEventi {
    
    private final SessionFactory sessionFactory=hibernate.HibernateUtil.getSessionFactory();
    
    public Integer addEvento(int id, String titolo, String luogo, Date data, Categoria cat){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        Integer idEvento=null;

        try{
            tx=session.beginTransaction();
            Evento event=new Evento(id, titolo, luogo, data, cat);
            idEvento=(Integer) session.save(event);
            tx.commit();    
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return idEvento;
    }
    
    public void deleteEvento(int idE){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        List<Evento> listaE=null;
        try{
            tx=session.beginTransaction();
            listaE=session.createQuery("From Evento").list();
            for(int i=0; i<listaE.size(); i++){
                Evento temp=listaE.get(i);
                if(temp.getIdEvento().equals(idE)==true){
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
        
        
    public List<Evento> showEventi(){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        List<Evento> listaE=null;
        try{
            tx=session.beginTransaction();
            listaE=session.createQuery("From Evento").list();
            tx.commit();
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return listaE;
      
    }
    
    public List<Evento> showEventiSvolti(){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        List<Evento> listaE=null;
        
        try{
            tx=session.beginTransaction();
            listaE=session.createQuery("From Evento Where data<current_date() Order by luogo").list();
            tx.commit();
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return listaE;
    }
    
    public Evento showEvento(int idE){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        Evento event=null;
        try{
            tx=session.beginTransaction();
            event=(Evento) session.createQuery("From Evento Where idEvento="+idE);
            tx.commit();
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return event;
      
    }
    
    public List<Recensione> showRecensioniEvento(int idE){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        List<Recensione> listaR=null;
        try{
            tx=session.beginTransaction();
            listaR=session.createQuery("Select recensioniCollection From Evento where idEvento="+idE).list();
            tx.commit();
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return listaR;
    }
        
    public int votoMedio (int idE){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        List recensioni=null;
        Recensione rec=null;
        int somma=0;
        int votoMedio=0;
        try{
            tx=session.beginTransaction();
            recensioni=session.createQuery("Select recensioniCollection From Evento where idEvento="+idE).list();
            for(int i=0; i<recensioni.size(); i++){
                rec=(Recensione)recensioni.get(i);
                somma+=rec.getVoto();
            }
            votoMedio=somma/recensioni.size();
            tx.commit();
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return votoMedio;
        
    }
}