/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import DAO.DAOEventi;
import Mapping.Evento;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author FSEVERI\sbrizza3331
 */
public class HibernateMain {
    public static void main(String[]args){
        DAOEventi daoE=new DAOEventi();
        Calendar d = Calendar.getInstance();
        d.set(03, 04, 2017);
        Integer EventoId1=daoE.addEvento(1, "Evento 1", "Padova", d);
        d.set(10, 05, 2017);
        EventoId1=daoE.addEvento(2, "Evento 2", "Padova", d);
        d.set(28, 07, 2017);
        EventoId1=daoE.addEvento(3, "Evento 3", "Padova", d);
        List listaE=null;
        listaE=daoE.showEventi();
        
        for(Iterator iterator=listaE.iterator();
            iterator.hasNext();){
            
            Evento p=(Evento)iterator.next();
            System.out.print("Id: "+p.getIdEvento());
            System.out.print("  Nome: "+p.getTitolo());
            System.out.print("  Luogo: "+p.getLuogo());
            System.out.print("  Data: "+p.getData());
        }
    }
}
