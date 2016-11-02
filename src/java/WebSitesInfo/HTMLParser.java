/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebSitesInfo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author rafael
 */
public class HTMLParser {
    
    private Document doc;
    private String site;
    
    public HTMLParser(String site)
    {
        this.site = site;
    }
}
