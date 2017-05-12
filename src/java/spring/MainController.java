package spring;




import DAO.DAOCategorie;
import DAO.DAOEventi;
import DAO.DAORecensioni;
import Mapping.Categoria;
import Mapping.Evento;
import Mapping.Recensione;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        DAOEventi dao = new DAOEventi();
        
        List<Evento> lista = dao.showEventi();
        map.put("lista", lista);
        
        return "index";
    }
    
    @RequestMapping(value = "/categorie", method = RequestMethod.GET)
    public String categorie(ModelMap map)
    {
        DAOCategorie dao = new DAOCategorie();
        
        List<Categoria> listaCat = dao.showCategorie();
        map.put("listaCat", listaCat);
        
        return "categorie";
    }
    
    /*
    @RequestMapping(value = "/artisti", method = RequestMethod.GET)
    public String artisti(ModelMap map)
    {
        DAOCategorie dao = new DAOCategorie();
        
        List<Categoria> listaCat = dao.showCategorie();
        map.put("listaCat", listaCat);
        
        return "categorie";
    }*/
    
    @RequestMapping(value = "/categoria", params = {"idC"}, method = RequestMethod.GET)
    public String categoria(ModelMap map, @RequestParam(value="idC") int idC)
    {
        DAOCategorie dao = new DAOCategorie();
        
        List<Categoria> listaCat = dao.showCategorie();
        List<Evento> eventiCategoria = dao.eventiCategoria(idC);
        map.put("listaCat", listaCat);
        map.put("categoria", listaCat.get(idC-1));
        map.put("eventiCategoria", eventiCategoria);
        map.put("idCat", idC);
        
        return "specCategoria";
    }
    
    @RequestMapping(value = "/filtroEventi", method = RequestMethod.GET)
    public String categoria(ModelMap map, @RequestParam(value="idCat") int idC, @RequestParam(value="luogo") String luogo)
    {
        DAOCategorie dao = new DAOCategorie();
        
        List<Categoria> listaCat = dao.showCategorie();
        List<Evento> eventiCategoria = dao.eventiLuogoCategoria(idC, luogo);        
        map.put("categoria", listaCat.get(idC-1));
        map.put("eventiCategoria", eventiCategoria);
        map.put("idCat", idC);
        
        return "specCategoria";
    }
    
    @RequestMapping(value = "/evento", params = {"idE"}, method = RequestMethod.GET)
    public String recensioniEvento(ModelMap map, @RequestParam(value="idE") int idE)
    {
        DAOEventi dao = new DAOEventi();
        DAORecensioni daor = new DAORecensioni();
        
        int mediaVoto=dao.votoMedio(idE);
        map.put("mediaVoto", mediaVoto);
        Evento event= dao.showEvento(idE);
        map.put("event", event);
        List<Recensione> listaRec = dao.showRecensioniEvento(idE);
        map.put("listaRec", listaRec);

        return "recensioniEvento";
    }
    
    @RequestMapping(value = "/forwardAddEvento", method = RequestMethod.GET)
    public String forwardAddEvento(ModelMap map)
    {
        return "addEvento";
    }
    
    @RequestMapping(value = "/forwardAddEventoCat", method = RequestMethod.GET)
    public String forwardAddEvento(ModelMap map, @RequestParam(value="nomeC") String nomeC)
    {
        map.put("nomeC", nomeC);
        return "addEvento";
    }
    
    @RequestMapping(value = "/addEvento", method = RequestMethod.GET)
    public String addEvento(ModelMap map, @RequestParam(value="titolo") String titolo, @RequestParam(value="luogo") String luogo, @RequestParam(value="data") String data, @RequestParam(value="categoria") String categoria)
    {
        DAOEventi daoe = new DAOEventi();
        DAOCategorie daoc = new DAOCategorie();
        
        Date d =null;
        try{
            DateFormat df = new SimpleDateFormat ("yyyy/MM/dd");
            df.setLenient (false);
            d = df.parse (data);
        }catch(ParseException e){ }
        List<Evento> eventi=daoe.showEventi();
        Categoria cat=daoc.cercaCategoria(categoria);
        daoe.addEvento(eventi.size(), titolo, luogo, d, cat);
        eventi=daoe.showEventi();
        map.put("lista", eventi);
        
        return "index";
    }
    
    @RequestMapping(value = "/deleteEvento", method = RequestMethod.GET)
    public String deleteEvento(ModelMap map, @RequestParam(value="idE") int idE, @RequestParam(value="idC") int idC)
    {
        DAOEventi daoe = new DAOEventi();
        DAOCategorie dao = new DAOCategorie();
        
        daoe.deleteEvento(idE);
        List<Categoria> listaCat = dao.showCategorie();
        List<Evento> eventiCategoria = dao.eventiCategoria(idC);
        map.put("listaCat", listaCat);
        map.put("categoria", listaCat.get(idC-1));
        map.put("eventiCategoria", eventiCategoria);
        map.put("idCat", idC);
        
        return "specCategoria";
    }
    
    @RequestMapping(value = "/addRecensione", method = RequestMethod.GET)
    public String addRecensione(ModelMap map, @RequestParam(value="idMembro") int idMembro, @RequestParam(value="idEvento") int idEvento, @RequestParam(value="commento") String commento, @RequestParam(value="voto") int voto)
    {
        DAORecensioni daor=new DAORecensioni();
        DAOEventi daoe = new DAOEventi();
        
        int mediaVoto=daoe.votoMedio(idEvento);
        map.put("mediaVoto", mediaVoto);
        Evento event= daoe.showEvento(idEvento);
        map.put("event", event);
        List<Recensione> listaRec = daoe.showRecensioniEvento(idEvento);
        map.put("listaRec", listaRec);
        
        daor.addRecensione(idMembro, idEvento, commento, voto);
        List<Evento> lista = daoe.showEventi();
        map.put("lista", lista);
        
        return "recensioniEvento";
    }
    
    @RequestMapping(value = "/deleteRecensione", method = RequestMethod.GET)
    public String deleteRecensione(ModelMap map, @RequestParam(value="idM") int idM, @RequestParam(value="idE") int idE)
    {
        DAORecensioni daor = new DAORecensioni();
        DAOEventi daoe = new DAOEventi();
        
        daor.deleteRecensione(idM, idE);
        List<Evento> lista = daoe.showEventi();
        map.put("lista", lista);
        
        return "index";
    }  
    
    @RequestMapping(value = "/forwardAddRecensione", method = RequestMethod.GET)
    public String forwardAddRecensione(ModelMap map, @RequestParam(value="idE") int idE)
    {
        map.put("idE", idE);
        return "addRecensione";
    }
}
