package moz.outils.intranet.Banque.Repository;

import moz.outils.intranet.Banque.Entity.Avoir;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AvoirRepository extends CrudRepository<Avoir, Integer> {

    List<Avoir> findAllByUserId(Integer userId);

}
