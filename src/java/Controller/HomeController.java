package Controller;

import Database.Artista;
import Database.SqlServer;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
        result.addObject(artistas);
        
        return result;
    }
    
    private void iniciaDatabase()
    {
        try{
            dataBase = new SqlServer();
        }
        catch(Exception ex)
        {
        }
    }
}