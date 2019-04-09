package moz.outils.intranet.Banque.Controller;

import moz.outils.intranet.Banque.Entity.Avoir;
import moz.outils.intranet.Banque.Repository.AvoirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BanqueController {

    @Autowired
    AvoirRepository avoirRepository;

    public BanqueController() {
    }

    @RequestMapping(value = "/banque/patrimoine/{userId}" , method = RequestMethod.GET)
    public @ResponseBody
    List<Avoir> getUserPatrimoine(@PathVariable("userId") Integer userId){
        return avoirRepository.findAllByUserId(userId);
    }
}
