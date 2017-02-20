package DBManagement;

import Participants.EmailPasswordInfo;
import Participants.UserInfo;

/**
 * Created by yy on 15-Feb-17.
 */
public class DBManager {

    public UserInfo getParticipant(EmailPasswordInfo credentials){
        return new UserInfo("Pepe",25);
    }
}
