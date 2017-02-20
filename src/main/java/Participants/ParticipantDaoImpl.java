package Participants;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by yy on 20-Feb-17.
 */

@Transactional
public class ParticipantDaoImpl {

    @PersistenceContext
    private EntityManager em;

    public Long save(Participant person) {
        em.persist(person);
        return person.getId();
    }

    public List<Participant> getAll() {
        return em.createQuery("SELECT p FROM Participants p", Participant.class).getResultList();
    }

    public Participant getUser(String email, String password){
        return em.createQuery("SELECT p FROM Participants p ", Participant.class).getSingleResult();
    }

}