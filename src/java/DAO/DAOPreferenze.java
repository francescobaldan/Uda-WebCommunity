/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Sprizzetto
 */
public class DAOPreferenze {
    private final SessionFactory sessionFactory=hibernate.HibernateUtil.getSessionFactory();
    
    /*public Integer addPreferenza(Integer idCategoria, String nome, String descrizione){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        Integer idCat=null;

        try{
            tx=session.beginTransaction();
            Preferenza event=new Categoria(idCategoria, nome, descrizione);
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
*/
    
}
