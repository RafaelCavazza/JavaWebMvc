
package Controller;

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
        return new ModelAndView("/Home/index");
    }
}