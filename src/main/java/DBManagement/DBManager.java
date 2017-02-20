package DBManagement;

import Participants.EmailPasswordInfo;
import Participants.Participant;
import Participants.ParticipantRepository;

/**
 * Created by yy on 15-Feb-17.
 */
public class DBManager {

    public Participant getParticipant(ParticipantRepository rep, EmailPasswordInfo credentials){
        return rep.findParticipantByEmailAndPassword(credentials.getEmail(),credentials.getPassword());
    }
}
