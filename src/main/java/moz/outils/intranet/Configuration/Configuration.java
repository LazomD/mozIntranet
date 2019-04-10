package moz.outils.intranet.Configuration;

import moz.outils.intranet.Banque.Tools.Tools;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public Tools getTools(){
        return new Tools();
    }
}
