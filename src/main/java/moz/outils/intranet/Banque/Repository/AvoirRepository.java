package moz.outils.intranet.Banque.Repository;

import moz.outils.intranet.Banque.DTO.MesureDTO;
import moz.outils.intranet.Banque.Entity.Avoir;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AvoirRepository extends CrudRepository<Avoir, Integer> {

    List<Avoir> findAllByUserId(Integer userId);

    @Query("select new moz.outils.intranet.Banque.DTO.MesureDTO(sum(a.montant), a.avoirTimestamp.timestamp) from Avoir a where a.userId = ?1 group by a.avoirTimestamp")
    List<MesureDTO> findAllByUserIdIgnoringTypes(Integer userId);

}
