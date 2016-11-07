package WebSitesInfo;

import Database.MusicaInfo;
import java.text.Normalizer;
import java.util.ArrayList;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MusicasAtistaInfo {
    
    private String site = "https://www.vagalume.com.br/";
    private String siteBusca = "https://www.vagalume.com.br/";
    private HTMLParser htmlParser;
    
    public ArrayList<String> getMusicasArtista(String nomeArtista)
    {
        nomeArtista = formatarNome(nomeArtista);
        if(Connect(site + nomeArtista))
        {
            return getMusicas();
        }
        else
        {
            return new ArrayList<>();
        }
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
    
    private boolean Connect(String site)
    {
        htmlParser = new HTMLParser(site);
        return htmlParser.Connect();
    }
    
    private String formatarNome(String nomeArtista)
    {
        String convertedString = Normalizer.normalize(nomeArtista, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        return remove(convertedString.replace(' ', '-').replace(',','-').replace('.','-'));
    }
    
    public String remove(String texto) 
    {
        while(texto.contains("--"))
        {
            texto = texto.replace("--","-");
        }
        return texto.replaceAll("[-+.^:,]$#%*!+=<>","").replace("\"", "");
    }

    public String GetLetra(MusicaInfo musica) {
        String pesquisa = siteBusca + formatarNome(musica.NomeArtista) + "/" + formatarNome(musica.NomeMusica) + ".html";
        pesquisa = pesquisa.toLowerCase();
        if(!Connect(pesquisa))
            return "";
        
        return GetLetra();
    }
    
    private String GetLetra()
    {
        return htmlParser.getContent("#lyr_original").first().html();
    }
}
