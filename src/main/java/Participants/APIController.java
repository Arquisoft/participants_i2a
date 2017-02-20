package Participants;



import DBManagement.DBManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {

    private static final Logger LOG = LoggerFactory.getLogger(APIController.class);

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public ResponseEntity<UserInfo> getParticipantInfo(
            @RequestBody  EmailPasswordInfo credentials) {
        LOG.info("Email trying to log-in:  " + credentials.getEmail());
        DBManager dbm = new DBManager();
        UserInfo user = dbm.getParticipant(credentials);

        if(user != null)
            return new ResponseEntity<UserInfo>(user,
                    HttpStatus.OK);
        else
            return new ResponseEntity<UserInfo>(HttpStatus.NOT_FOUND);
    }

}