package spring;




import DAO.DAOCategorie;
import DAO.DAOEventi;
import Mapping.Categoria;
import Mapping.Evento;
import Mapping.Recensione;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "index";
    }
    
    @RequestMapping(value = "/categoria", params = {"idC"}, method = RequestMethod.GET)
    public String categoria(ModelMap map, @RequestParam(value="idC") int idC)
    {
        DAOCategorie de = new DAOCategorie();
        
        List<Categoria> listaCat = de.showCategorie();
        List<Evento> eventiCategoria = de.eventiCategoria(idC);
        map.put("listaCat", listaCat);
        map.put("categoria", listaCat.get(idC-1));
        map.put("eventiCategoria", eventiCategoria);
        return "specCategoria";
    }
    
    @RequestMapping(value = "/recensioniEvento", params = {"idE"}, method = RequestMethod.GET)
    public String recensioniEvento(ModelMap map, @RequestParam(value="idE") int idE)
    {
        DAOEventi de = new DAOEventi();
        
        List<Recensione> listaRec = de.showRecensioniEvento(idE);
        map.put("listaRec", listaRec);;
        return "recensioniEvento";
    }
}
