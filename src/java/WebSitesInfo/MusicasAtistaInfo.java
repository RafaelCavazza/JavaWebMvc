package WebSitesInfo;

import java.util.ArrayList;
import org.jsoup.select.Elements;

public class MusicasAtistaInfo {
    
    private String site = "https://www.vagalume.com.br/";
    private HTMLParser htmlParser;
    
    public ArrayList<String> getMusicasArtista(String nomeArtista)
    {
        nomeArtista = formatarNome(nomeArtista);
        Connect(site + nomeArtista);
        getMusicas();
        return null;
    }
    
    private ArrayList<String> getMusicas()
    {
         ArrayList<String> musicasArray = new ArrayList<String>();
         Elements musicas = filtraUl(htmlParser.getContent("ul"));
         for(int i=0; i< musicas.size(); i++)
         {
             musicasArray.add(musicas.get(i).text());
         }
         return musicasArray;
    }
    
    private Elements filtraUl(Elements ul)
    {
        Elements ulTracks = ul.select(".tracks");
        return ulTracks.select("li").select("a").select("span");
    }
    
    private void Connect(String site)
    {
        htmlParser = new HTMLParser(site);
        htmlParser.Connect();
    }
    
    private String formatarNome(String nomeArtista)
    {
        String vogalA = "ÃãÂâÁáÀà";
        String vogalE = "ẼẽÊêÉéÈè";
        String vogalI = "ĨĩÎîÍíÌì";
        String vogalO = "ÕõÔôÍíÌì";
        String vogalU = "ŨũÛûÚúÙù";
        String c = "Çç";
        
        nomeArtista = nomeArtista.replace(vogalA, "a");
        nomeArtista = nomeArtista.replace(vogalE, "e");
        nomeArtista = nomeArtista.replace(vogalI, "i");
        nomeArtista = nomeArtista.replace(vogalO, "o");
        nomeArtista = nomeArtista.replace(vogalU, "u");
        nomeArtista = nomeArtista.replace(c, "c");
        nomeArtista = nomeArtista.replace(" ", "-");
        
        return nomeArtista;
    }
}
