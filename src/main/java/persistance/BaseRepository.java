package persistance;

/**
 * Created by yy on 15-Feb-17.
 */
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {

        void delete(T deleted);

        List<T> findAll();

        Optional<T> findOne(ID id);

        T save(T persisted);
}
