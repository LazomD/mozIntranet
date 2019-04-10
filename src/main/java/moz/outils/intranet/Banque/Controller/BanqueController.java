package moz.outils.intranet.Banque.Controller;

import moz.outils.intranet.Banque.DTO.MesureDTO;
import moz.outils.intranet.Banque.Entity.Avoir;
import moz.outils.intranet.Banque.Repository.AvoirRepository;
import moz.outils.intranet.Banque.Tools.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BanqueController {

    @Autowired
    Tools tools;

    @Autowired
    AvoirRepository avoirRepository;

    public BanqueController() {
    }

    @RequestMapping(value = "/banque/patrimoine/{userId}" , method = RequestMethod.GET)
    public @ResponseBody
    Object getUserPatrimoineTotal(@PathVariable("userId") Integer userId){
        List<MesureDTO> mesureDTOList = avoirRepository.findAllByUserIdIgnoringTypes(userId);
        return tools.convertMesureDTOtoTab(mesureDTOList);
    }
}
