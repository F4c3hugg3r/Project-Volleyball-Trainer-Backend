package htwberlin.webtech.persistence;

import htwberlin.webtech.model.Stat;
import htwberlin.webtech.model.StatId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatRepository extends CrudRepository<Stat, StatId> {

    Iterable<Stat> findById_Id(Integer id);
    Iterable<Stat> findById_Rating(Integer rating);

}
