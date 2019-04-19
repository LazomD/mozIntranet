package moz.outils.intranet.Banque.Repository;

import moz.outils.intranet.Banque.Entity.TypePatrimoine;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TypePatrimoineRepository extends CrudRepository<TypePatrimoine, Integer> {

    TypePatrimoine save(TypePatrimoine typePatrimoine);

    List<TypePatrimoine> findAll();
}
