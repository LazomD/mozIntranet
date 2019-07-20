package moz.outils.intranet.Banque.service;

import moz.outils.intranet.Banque.Entity.Eleve;
import org.springframework.stereotype.Service;

@Service
public class EleveService {

    public Eleve copy(Eleve source){
        Eleve destination = new Eleve();
        destination.setPrenom(source.getPrenom());
        destination.setClasse(source.getClasse());

        return destination;
    }
}
