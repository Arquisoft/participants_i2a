package Participants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Dax on 21-Feb-17.
 */
@Controller
public class WebController {

    private static final Logger LOG = LoggerFactory.getLogger(APIController.class);

    @Autowired
    private ParticipantRepository repository;

    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("credentials", new Credentials());
        return "login";
    }

//    @PostMapping("/login")
//    public ResponseEntity<Participant> updateInfo(Participant participant){
//        Participant participant1 = repository.save(participant);
//        return new ResponseEntity<Participant>(participant1, HttpStatus.OK);
//    }

    @PostMapping("/userInfo")
    public String showData(Credentials credentials,Model model){
        Participant participant = repository.findParticipantByEmailAndPassword(
                credentials.getEmail(),credentials.getPassword());
        model.addAttribute("participant",participant);
        return "update";
    }
}
