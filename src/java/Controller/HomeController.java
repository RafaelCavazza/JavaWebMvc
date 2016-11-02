
package Controller;

import WebSitesInfo.ArtistaInfo;
import WebSitesInfo.MusicasAtistaInfo;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
    
    public HomeController() {
    }
    
    @RequestMapping("/Home/index.htm")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
        ArtistaInfo af = new ArtistaInfo();
        ArrayList<String> arl = af.getArtistas();
        
        MusicasAtistaInfo maf = new MusicasAtistaInfo();
        maf.getMusicasArtista(arl.get(0));
        
        return new ModelAndView("/Home/index");
    }
    
    @RequestMapping("/Home/results.htm")
    public ModelAndView results()
    {
        return new ModelAndView("/Home/result");
    }
    
    @RequestMapping("/Home/welcome.htm")
    public ModelAndView welcome()
    {
        return new ModelAndView("/Home/welcome");
    }
}