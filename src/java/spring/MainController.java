package spring;




import DAO.DAOEventi;
import Mapping.Evento;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Classe MainController
 *
 * @author 
 */
@Controller
public class MainController
{
    public MainController()
    {
        //
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap map)
    {
        
        DAOEventi de = new DAOEventi();
        
        List<Evento> lista = de.showEventi();
        map.put("lista", lista);
       /*Persona per = new Persona(10,"Nome Bello");

        PersoneDAO p = new PersoneDAO();
        //p.aggiungiPersona(per);
        List<Persona> pers = p.leggiPersone();

        map.put("pers", pers);

        */return "index";
    }
}
