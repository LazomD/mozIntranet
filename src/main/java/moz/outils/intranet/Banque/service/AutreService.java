package moz.outils.intranet.Banque.service;

import moz.outils.intranet.Banque.Entity.Eleve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutreService {

    @Autowired
    private BanqueService banqueService;

    public void test(Eleve eleve){

        String classe = eleve.getClasse().getNom();

        String sdfds = "";
    }
}
