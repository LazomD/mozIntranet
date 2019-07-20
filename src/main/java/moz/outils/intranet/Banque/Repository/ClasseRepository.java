package moz.outils.intranet.Banque.Repository;

import moz.outils.intranet.Banque.Entity.Classe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ClasseRepository extends CrudRepository<Classe, Integer> {

    List<Classe> findAll();

}
