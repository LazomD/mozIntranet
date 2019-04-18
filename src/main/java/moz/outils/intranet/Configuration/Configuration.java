package moz.outils.intranet.Configuration;

import moz.outils.intranet.Banque.Tools.Tools;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public Tools getTools(){
        return new Tools();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
