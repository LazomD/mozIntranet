package moz.outils.intranet.Banque.service;

import moz.outils.intranet.Banque.DTO.TypePatrimoineDTO;
import moz.outils.intranet.Banque.Entity.Classe;
import moz.outils.intranet.Banque.Entity.Eleve;
import moz.outils.intranet.Banque.Entity.TypePatrimoine;
import moz.outils.intranet.Banque.Repository.EleveRepository;
import moz.outils.intranet.Banque.Repository.TypePatrimoineRepository;
import moz.outils.intranet.Banque.Tools.DebugUtils;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BanqueService {

    @Autowired
    private EleveRepository eleveRepository;

    @Autowired
    private TypePatrimoineRepository typePatrimoineRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AutreService autreService;

    public List<TypePatrimoineDTO> getAllTypePatrimoine(){

        Eleve eleve = eleveRepository.findAll().get(0);

//        Classe classe = eleve.getClasse();

        String nomClasse = eleve.getClasse().getNom();


        List<TypePatrimoine> typePatrimoineList = typePatrimoineRepository.findAll();
        List<TypePatrimoineDTO> list = new ArrayList<>();
        for (TypePatrimoine tP : typePatrimoineList) {
            list.add(modelMapper.map(tP, TypePatrimoineDTO.class));
        }
        return list;
    }

    public Eleve getEleve(){
        DebugUtils.transactionRequired("WorkingMyClass.calledFirst");

        Eleve eleve = eleveRepository.findAll().get(0);
        return eleve;
    }
}
