package todo;

/**
 * Created by yy on 15-Feb-17.
 */
import persistance.BaseRepository;

import java.util.List;
import java.util.Optional;

interface TodoRepository extends BaseRepository<Todo, Long> {
    void delete(Todo deleted);

    List<Todo> findAll();

    Optional<Todo> findOne(Long id);

    Todo save(Todo persisted);
}
