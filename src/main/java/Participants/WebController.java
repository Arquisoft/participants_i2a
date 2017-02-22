package Participants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Dax on 21-Feb-17.
 */
@Controller
public class WebController extends WebMvcConfigurerAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(APIController.class);

    @Autowired
    private ParticipantRepository repository;

    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("credentials", new Credentials());
        return "login";
    }

    @PostMapping("/update")
    public String updateInfo(Participant participant,Model model){
        model.addAttribute("participant",repository.save(participant));
        return "update";
    }

    @PostMapping("/userInfo")
    public String showData(Credentials credentials,Model model){
        Participant participant = repository.findParticipantByEmailAndPassword(
                credentials.getEmail(),credentials.getPassword());
        model.addAttribute("participant",participant);
        return "update";
    }

    @PostMapping("/changePassword")
    public String showData(Participant participant,Model model){
        model.addAttribute("participant",repository
                .findParticipantByEmailAndPassword(participant.getEmail(),participant.getPassword()));
        return "changePassword";
    }
}
