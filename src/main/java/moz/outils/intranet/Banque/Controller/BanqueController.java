package moz.outils.intranet.Banque.Controller;

import moz.outils.intranet.Banque.DTO.MesureDTO;
import moz.outils.intranet.Banque.DTO.TypePatrimoineDTO;
import moz.outils.intranet.Banque.Entity.TypePatrimoine;
import moz.outils.intranet.Banque.Repository.AvoirRepository;
import moz.outils.intranet.Banque.Repository.TypePatrimoineRepository;
import moz.outils.intranet.Banque.Tools.Tools;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BanqueController {

    @Autowired
    private Tools tools;

    @Autowired
    private AvoirRepository avoirRepository;

    @Autowired
    private TypePatrimoineRepository typePatrimoineRepository;

    @Autowired
    private ModelMapper modelMapper;

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
        List<TypePatrimoine> typePatrimoineList = typePatrimoineRepository.findAll();
        List<TypePatrimoineDTO> list = new ArrayList<>();
        for (TypePatrimoine tP : typePatrimoineList) {
            list.add(modelMapper.map(tP, TypePatrimoineDTO.class));
        }
        return list;
    }

}
