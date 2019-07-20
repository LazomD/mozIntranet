package moz.outils.intranet.Banque.Controller;

import moz.outils.intranet.Banque.DTO.MesureDTO;
import moz.outils.intranet.Banque.DTO.TypePatrimoineDTO;
import moz.outils.intranet.Banque.Entity.*;
import moz.outils.intranet.Banque.Repository.*;
import moz.outils.intranet.Banque.Tools.DebugUtils;
import moz.outils.intranet.Banque.Tools.Tools;
import moz.outils.intranet.Banque.service.AutreService;
import moz.outils.intranet.Banque.service.BanqueService;
import moz.outils.intranet.Banque.service.EleveService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BanqueController {

    @Autowired
    Tools tools;

    @Autowired
    AvoirRepository avoirRepository;

    @Autowired
    TypePatrimoineRepository typePatrimoineRepository;

    @Autowired
    ClasseRepository classeRepository;

    @Autowired
    EleveRepository eleveRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BanqueService banqueService;

    @Autowired
    private AutreService autreService;

    @Autowired
    private MatchRemplaRepository matchRemplaRepository;

    @Autowired
    private EleveService eleveService;

    public BanqueController() {
    }

    @RequestMapping(value = "/banque/patrimoine/{userId}" , method = RequestMethod.GET)
    @ResponseBody
    public Object getUserPatrimoineTotal(@PathVariable("userId") Integer userId){
        List<MesureDTO> mesureDTOList = avoirRepository.findAllByUserIdIgnoringTypes(userId);
        return tools.convertMesureDTOtoTab(mesureDTOList);
    }

    @RequestMapping(value = "/banque/patrimoine/saveType" , method = RequestMethod.POST)
    public ResponseEntity<TypePatrimoineDTO> saveTypePatrimoine(@RequestBody TypePatrimoineDTO typePatrimoineDTO){

        TypePatrimoine typePatrimoine = modelMapper.map(typePatrimoineDTO, TypePatrimoine.class);
        TypePatrimoine savedTypePatrimoine = typePatrimoineRepository.save(typePatrimoine);
        TypePatrimoineDTO savedTypePatrimoineDTO = modelMapper.map(savedTypePatrimoine, TypePatrimoineDTO.class);

        return new ResponseEntity<TypePatrimoineDTO>(savedTypePatrimoineDTO , new HttpHeaders(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/banque/patrimoine/allType" , method = RequestMethod.GET)
    @ResponseBody
    public List<TypePatrimoineDTO> getAllTypePatrimoine(){
        DebugUtils.transactionRequired("WorkingMyClass.calledFirst");
        Eleve eleve = banqueService.getEleve();


        Eleve copy = eleveService.copy(eleve);


        MatchRempla match = new MatchRempla();
        eleve.setPrenom("albert");
        match.setEleve1(copy);
        match.setNom("Match1");
        matchRemplaRepository.save(match);


        /*DebugUtils.transactionRequired("WorkingMyClass.calledFirst");
        autreService.test(eleve);

        String nom = eleve.getClasse().getNom();*/

        return banqueService.getAllTypePatrimoine();
    }
}
