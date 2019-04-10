package moz.outils.intranet;

import moz.outils.intranet.Banque.Entity.Avoir;
import moz.outils.intranet.Banque.Entity.AvoirTimestamp;
import moz.outils.intranet.Banque.Repository.AvoirRepository;
import moz.outils.intranet.Banque.Repository.AvoirTimestampRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InitData {

    @Autowired
    private final AvoirRepository avoirRepository;

    @Autowired
    private final AvoirTimestampRepository avoirTimestampRepository;

    public InitData(AvoirRepository avoirRepository, AvoirTimestampRepository avoirTimestampRepository) {
        this.avoirRepository = avoirRepository;
        this.avoirTimestampRepository = avoirTimestampRepository;
    }

    @EventListener
    public void appReady(ApplicationReadyEvent event) {

        AvoirTimestamp avoirTimestamp = new AvoirTimestamp(1, 1528488279);
        /*avoirTimestampRepository.save(avoirTimestamp);
        avoirRepository.save(new Avoir(1, 2, avoirTimestamp, Double.valueOf(10000)));*/
        avoirTimestampRepository.save(avoirTimestamp);
        avoirRepository.save(new Avoir(1, 1, avoirTimestamp, Double.valueOf(458.5)));

        AvoirTimestamp avoirTimestamp2 = new AvoirTimestamp(1, 1531080279);
        avoirTimestampRepository.save(avoirTimestamp2);
        avoirRepository.save(new Avoir(1, 1, avoirTimestamp2, Double.valueOf(490)));

        AvoirTimestamp avoirTimestamp3 = new AvoirTimestamp(1, 1533758679);
        avoirTimestampRepository.save(avoirTimestamp3);
        avoirRepository.save(new Avoir(1, 1, avoirTimestamp3, Double.valueOf(590)));

        AvoirTimestamp avoirTimestamp4 = new AvoirTimestamp(1, 1536437079);
        avoirTimestampRepository.save(avoirTimestamp4);
        avoirRepository.save(new Avoir(1, 1, avoirTimestamp4, Double.valueOf(650)));

        AvoirTimestamp avoirTimestamp5 = new AvoirTimestamp(1, 1539029079);
        avoirTimestampRepository.save(avoirTimestamp5);
        avoirRepository.save(new Avoir(1, 1, avoirTimestamp5, Double.valueOf(800)));

        AvoirTimestamp avoirTimestamp6 = new AvoirTimestamp(1, 1541707479);
        avoirTimestampRepository.save(avoirTimestamp6);
        avoirRepository.save(new Avoir(1, 1, avoirTimestamp6, Double.valueOf(1500)));

        AvoirTimestamp avoirTimestamp7 = new AvoirTimestamp(1, 1544299479);
        avoirTimestampRepository.save(avoirTimestamp7);
        avoirRepository.save(new Avoir(1, 1, avoirTimestamp7, Double.valueOf(1900)));

        AvoirTimestamp avoirTimestamp8 = new AvoirTimestamp(1, 1546977879);
        avoirTimestampRepository.save(avoirTimestamp8);
        avoirRepository.save(new Avoir(1, 1, avoirTimestamp8, Double.valueOf(3000)));
    }
}
