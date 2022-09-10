package live.midreamsheep.swcj.spring.bean;

import com.midream.sheep.swcj.core.factory.SWCJXmlFactory;
import live.midreamsheep.swcj.spring.annotation.SWCJMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class SWCJFactoryBean implements FactoryBean {
    private final Class<?> aClass;
    private SWCJXmlFactory swcjXmlFactory;

    public SWCJFactoryBean(Class<?> aClass) {
        this.aClass = aClass;
    }
    @Autowired
    public void setSWCJXmlFactory(SWCJXmlFactory swcjXmlFactory){
        this.swcjXmlFactory = swcjXmlFactory;
    }
    @Override
    public Object getObject() throws Exception {
        SWCJMapper annotation = aClass.getAnnotation(SWCJMapper.class);
        //获取注解value值
        if(annotation==null){
            return null;
        }
        return swcjXmlFactory.getWebSpiderById(annotation.value());
    }

    @Override
    public Class<?> getObjectType() {
        return aClass;
    }
}
