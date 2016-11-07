package WebSitesInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class HTMLParser {
    
    private Document doc;
    private String site;
    
    public HTMLParser(String site)
    {
        this.site = site;
    }
    
    public boolean Connect()
    {
        try
        {
            doc = Jsoup.connect(site).get();
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }
       
    public Elements getContent(String selector)
    {
        return doc.select(selector);
    }
}
