package WebSitesInfo;

import java.util.ArrayList;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ArtistaInfo {
    
    private String site = "https://pt.wikipedia.org/wiki/Os_100_Maiores_Artistas_da_M%C3%BAsica_Brasileira_pela_Rolling_Stone_Brasil";
    private HTMLParser htmlParser;
    private String tableFilter = "table";
            
    public ArtistaInfo()
    {
        htmlParser = new HTMLParser(site);
        htmlParser.Connect();
    }
    
    public ArrayList<String> getArtistas()
    {
        Elements tableArtist = getArtistTable();
        return getArtistsNames(tableArtist.first());
    }
    
    public ArrayList<String> getMusicas(String artista)
    {
        Elements tableArtist = getArtistTable();
        return getArtistsNames(tableArtist.first());
    }
    
    private Elements getArtistTable()
    {
        return htmlParser.getContent(tableFilter);
    }
    
    private ArrayList<String> getArtistsNames(Element table)
    {
        ArrayList<String> names = new ArrayList<String>();
        Elements trs = table.select("tr");
        
        for(int i =0; i< trs.size(); i++)
        {
            Element tr = trs.get(i);
            Elements tds = tr.select("td");
            if(tds.size() > 0)
            {
                Element td = tds.get(1);
                String name = td.text();
                names.add(name);
            }
        }
        return names;
    }
}
