package moz.outils.intranet.Banque.Repository;

import moz.outils.intranet.Banque.Entity.Classe;
import moz.outils.intranet.Banque.Entity.Eleve;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EleveRepository extends CrudRepository<Eleve, Integer> {

    @Transactional
    List<Eleve> findAll();
}
