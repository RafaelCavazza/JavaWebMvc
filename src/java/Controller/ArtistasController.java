package Controller;

import Database.SqlServer;
import WebSitesInfo.ArtistaInfo;
import WebSitesInfo.MusicasAtistaInfo;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArtistasController {

    private ArtistaInfo artistaInfo = new ArtistaInfo();
    private MusicasAtistaInfo musicasAtistaInfo = new MusicasAtistaInfo();
    private SqlServer dataBase;

    public ArtistasController() {
        try {
            dataBase = new SqlServer();
        } catch (Exception ex) {
        }
    }

    @RequestMapping("/Artistas/BuscaDados.htm")
    public ResponseEntity something() {
        iniciaDatabase();
        dataBase.DeletarTodosArtistas();
        dataBase.DeletarTodosMusicas();

        ArrayList<String> artistas = artistaInfo.getArtistas();
        dataBase.GravarArtista(artistas);
        for (int i = 0; i < artistas.size(); i++) {
            int id = dataBase.BuscarIdArtista(artistas.get(i));
            ArrayList<String> musicas = musicasAtistaInfo.getMusicasArtista(artistas.get(i));
            dataBase.GravarMusica(musicas, id);
        }
        return new ResponseEntity("", HttpStatus.OK);
    }

    private void iniciaDatabase() {
        try {
            dataBase = new SqlServer();
        } catch (Exception ex) {
        }
    }
}
