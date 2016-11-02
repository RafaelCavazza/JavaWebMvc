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
    
    public void Connect()
    {
        try
        {
            doc = Jsoup.connect(site).get();
        }
        catch(Exception ex)
        {
        }
    }
       
    public Elements getContent(String selector)
    {
        return doc.select(selector);
    }
}
