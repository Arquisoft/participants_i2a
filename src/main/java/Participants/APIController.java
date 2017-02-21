package Participants;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class APIController {

    private static final Logger LOG = LoggerFactory.getLogger(APIController.class);

    @Autowired
    private ParticipantRepository repository;

    @PostMapping("/user")
    public ResponseEntity<Participant> getParticipantInfo(
            @RequestBody Credentials credentials) {
        LOG.info("Email trying to log-in:  " + credentials.getEmail());
        Participant participant = repository.findParticipantByEmailAndPassword(credentials.getEmail()
                                        ,credentials.getPassword());

        if(participant != null)
            return new ResponseEntity<>(participant,
                    HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}