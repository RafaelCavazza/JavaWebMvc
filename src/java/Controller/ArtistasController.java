package Controller;

import Database.SqlServer;
import WebSitesInfo.ArtistaInfo;
import WebSitesInfo.MusicasAtistaInfo;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArtistasController {
    
    private ArtistaInfo artistaInfo = new ArtistaInfo();
    private MusicasAtistaInfo musicasAtistaInfo = new MusicasAtistaInfo();
    private SqlServer dataBase;
    
    public ArtistasController() {
        try{
            dataBase = new SqlServer();
        }
        catch(Exception ex)
        {
        }
    }
    
    @RequestMapping("/Artistas/BuscaDados.htm")
    public ModelAndView BuscaDados()
    {
        iniciaDatabase();
        dataBase.DeletarTodosArtistas();
        dataBase.DeletarTodosMusicas();
        
        ArrayList<String> artistas = artistaInfo.getArtistas();   
        for(int i=0; i<artistas.size(); i++)
        {
           dataBase.GravarArtista(artistas.get(i));
           int id = dataBase.BuscarIdArtista(artistas.get(i));
           ArrayList<String> musicas = musicasAtistaInfo.getMusicasArtista(artistas.get(i));
           for(int m =0; m<musicas.size(); m++)
            dataBase.GravarMusica(musicas.get(m),id);
        }
        
        return null;
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