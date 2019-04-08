package moz.outils.intranet;

import moz.outils.intranet.Banque.Entity.Avoir;
import moz.outils.intranet.Banque.Repository.AvoirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InitData {

    @Autowired
    private final AvoirRepository avoirRepository;

    public InitData(AvoirRepository avoirRepository) {
        this.avoirRepository = avoirRepository;
    }

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        avoirRepository.save(new Avoir(1, 1, 1554753879, Double.valueOf(458.5)));
        avoirRepository.save(new Avoir(1, 1, 1554753879, Double.valueOf(490)));
        avoirRepository.save(new Avoir(1, 1, 1554753879, Double.valueOf(590)));
        avoirRepository.save(new Avoir(1, 1, 1554753879, Double.valueOf(650)));
        avoirRepository.save(new Avoir(1, 1, 1554753879, Double.valueOf(800)));
        avoirRepository.save(new Avoir(1, 1, 1554753879, Double.valueOf(1500)));
        avoirRepository.save(new Avoir(1, 1, 1554753879, Double.valueOf(1900)));
        avoirRepository.save(new Avoir(1, 1, 1554753879, Double.valueOf(3000)));
    }
}
