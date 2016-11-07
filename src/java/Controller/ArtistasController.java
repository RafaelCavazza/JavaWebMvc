package Controller;

import Database.SqlServer;
import WebSitesInfo.ArtistaInfo;
import WebSitesInfo.MusicasAtistaInfo;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArtistasController {

    @RequestMapping("/Artistas/BuscaDados.htm")
    public ResponseEntity something() {
        try{
            ArtistaInfo artistaInfo = new ArtistaInfo();
            MusicasAtistaInfo musicasAtistaInfo;
            SqlServer dataBase = new SqlServer();

            dataBase.DeletarTodosArtistas();
            dataBase.DeletarTodosMusicas();

            ArrayList<String> artistas = artistaInfo.getArtistas();
            dataBase.GravarArtista(artistas);
            for (int i = 0; i < artistas.size(); i++) {
                musicasAtistaInfo = new MusicasAtistaInfo();
                int id = dataBase.BuscarIdArtista(artistas.get(i));
                ArrayList<String> musicas = musicasAtistaInfo.getMusicasArtista(artistas.get(i));
                dataBase.GravarMusica(musicas, id);
            }
            return new ResponseEntity("", HttpStatus.OK);
        }
        catch(Exception Ex)
        {
            return new ResponseEntity("", HttpStatus.EXPECTATION_FAILED);
        }
    }
}
