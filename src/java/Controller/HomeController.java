package Controller;

import Database.Artista;
import Database.MusicaInfo;
import Database.SqlServer;
import WebSitesInfo.MusicasAtistaInfo;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private SqlServer dataBase;

    @RequestMapping("/Home/index.htm")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView result = new ModelAndView("/Home/index");
        iniciaDatabase();
        ArrayList<Artista> artistas = dataBase.BuscarArtistas();
        result.addObject("artistas", artistas);

        return result;
    }

    @RequestMapping("/Home/Detalhes.htm")
    public ModelAndView Detalhes(@RequestParam("id") int id) {
        ModelAndView result = new ModelAndView("/Home/detalhes");
        iniciaDatabase();
        ArrayList<MusicaInfo> musicas = dataBase.BuscarMusicas(id);
        result.addObject("musicas", musicas);
        return result;
    }
    
    @RequestMapping("/Home/Letra.htm")
    @ResponseBody
    public String Letra(@RequestParam("id") int id, HttpServletResponse response) throws UnsupportedEncodingException {
        iniciaDatabase();
        MusicaInfo musica = dataBase.MusicaInfo(id);
        MusicasAtistaInfo musicasAtistaInfo = new MusicasAtistaInfo();
        
        response.setContentType("text/html;charset=UTF-8");
        return  musicasAtistaInfo.GetLetra(musica);
    }

    private void iniciaDatabase() {
        try {
            this.dataBase = new SqlServer();
        } catch (SQLException ex) {
        }
    }
}
