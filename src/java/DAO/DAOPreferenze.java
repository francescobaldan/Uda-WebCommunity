/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapping.Categoria;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Sprizzetto
 */
public class DAOPreferenze {
    private final SessionFactory sessionFactory=hibernate.HibernateUtil.getSessionFactory();
    
    public void addPreferenza(int idM, int idC){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        List<Categoria> categorie=null;
        List<Categoria> preferenze=null;
        try{
            tx=session.beginTransaction();
            categorie=session.createQuery("From Categoria").list();
            preferenze=session.createQuery("Select categoriaCollection From Membro Where idMembro="+idM).list();
            for(int i=0; i<categorie.size(); i++){
                Categoria temp=categorie.get(i);
                if(temp.getIdCategoria().equals(idC)==true){
                    preferenze.add(temp);
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
    
    public void deletePreferenza(int idM, int idC){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        List<Categoria> preferenze=null;
        try{
            tx=session.beginTransaction();
            preferenze=session.createQuery("Select categoriaCollection From Membro Where idMembro="+idM).list();
            for(int i=0; i<preferenze.size(); i++){
                Categoria temp=preferenze.get(i);
                if(temp.getIdCategoria().equals(idC)==true){
                    preferenze.remove(temp);
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
    
    public List<Categoria> showPreferenze(int idM){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        List<Categoria> listaP=null;
        try{
            tx=session.beginTransaction();
            listaP=session.createQuery("Select categoriaCollection From Membro Where idMembro="+idM).list();
            tx.commit();
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return listaP;
      
    }

    
}
