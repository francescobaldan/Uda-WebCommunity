/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapping.Categoria;
import Mapping.Evento;
import Mapping.Recensione;
import Mapping.RecensionePK;
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
            listaE=session.createQuery("From Evento Order by data").list();
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
        List<Evento> event=null;
        try{
            tx=session.beginTransaction();
            event=session.createQuery("From Evento Where idEvento="+idE).list();
            tx.commit();
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return event.get(0);
      
    }
    
    public List<Recensione> showRecensioniEvento(int idE){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        List<Recensione> listaR=null;
        List<Recensione> listaRC=null;
        try{
            tx=session.beginTransaction();
            /*listaRC=session.createQuery("From Recensione").list();
            for(int i=0; i<listaRC.size(); i++){
               if(listaRC.get(i).getEvento().getIdEvento()==idE){
                   listaR.add(listaRC.get(i));
               }
            }*/
            listaR=session.createQuery("Select recensioneCollection From Evento Where idEvento="+idE).list();
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
        List<Recensione> recensioni=null;
        Recensione rec=null;
        int somma=0;
        int votoMedio=0;
        try{
            tx=session.beginTransaction();
            recensioni=session.createQuery("Select recensioneCollection From Evento Where idEvento="+idE).list();
            for(int i=0; i<recensioni.size(); i++){
                rec=recensioni.get(i);
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