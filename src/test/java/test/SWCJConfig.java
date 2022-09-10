package test;

import com.midream.sheep.swcj.Exception.ConfigException;
import com.midream.sheep.swcj.core.build.builds.effecient.EffecientCompiler;
import com.midream.sheep.swcj.core.factory.SWCJXmlFactory;
import com.midream.sheep.swcj.core.factory.xmlfactory.CoreXmlFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

@Configuration
public class SWCJConfig {
    @Bean
    public SWCJXmlFactory getSWCJXmlFactory(){
        SWCJXmlFactory coreXmlFactory = new CoreXmlFactory();
        coreXmlFactory.setCompiler(new EffecientCompiler());

        try {
            coreXmlFactory.parse(new File(SWCJConfig.class.getClassLoader().getResource("swcj/Efficient.xml").getFile()));
            coreXmlFactory.parse(new File(SWCJConfig.class.getClassLoader().getResource("swcj/2.xml").getFile()));
            return coreXmlFactory;
        } catch (IOException | SAXException | ConfigException | ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }
}
