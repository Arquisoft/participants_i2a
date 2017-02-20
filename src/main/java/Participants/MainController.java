package Participants;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String landing(Model model) {
    	model.addAttribute("nombre", "Friend!");
        return "saludo";
    }
    
    @RequestMapping("/hola")
    public String hola(Model model) {
    	model.addAttribute("nombre", "Luis");
        return "saludo";
    }

}