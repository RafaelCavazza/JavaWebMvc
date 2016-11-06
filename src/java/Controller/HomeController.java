package Controller;

import Database.Artista;
import Database.SqlServer;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    
    private SqlServer dataBase;
    
    @RequestMapping("/Home/index.htm")
    public ModelAndView index(HttpServletRequest request)
    { 
        ModelAndView result = new ModelAndView("/Home/index");
        iniciaDatabase();
        ArrayList<Artista> artistas = dataBase.BuscarArtistas();
        result.addObject("artistas",artistas);
        
        return result;
    }
    
    @RequestMapping("/Home/Detalhes.htm")
    public ModelAndView Detalhes(@RequestParam("id") int id)
    { 
        ModelAndView result = new ModelAndView("/Home/detalhes");
        iniciaDatabase();
        ArrayList<String> musicas = dataBase.BuscarMusicas(id);
        result.addObject("musicas",musicas);
        
        return result;
    }
    
    
    private void iniciaDatabase()
    {
        try{
            this.dataBase = new SqlServer();
        }
        catch(SQLException ex)
        {   
        }
    }
}