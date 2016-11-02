package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
        
    @RequestMapping("/Home/index.htm")
    public ModelAndView index()
    {
        return new ModelAndView("/Home/index");
    }
    
    @RequestMapping("/Home/results.htm")
    public ModelAndView results()
    {
        return new ModelAndView("/Home/result");
    }
}