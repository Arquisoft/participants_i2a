package Participants;

import Participants.Participant;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by yy on 20-Feb-17.
 */
public interface ParticipantRepository extends CrudRepository<Participant,Long>{

    Participant findParticipantByEmailAndPassword(String email, String password);
}
