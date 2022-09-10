package live.midreamsheep.swcj.spring.bean;

import live.midreamsheep.swcj.spring.annotation.SWCJScan;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class SWCJImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        //获取扫描器
        SWCJScanner scanner = new SWCJScanner(registry);
        scanner.addIncludeFilter((metadataReader, metadataReaderFactory) -> true);
        //扫描
        scanner.scan((String) importingClassMetadata.getAnnotationAttributes(SWCJScan.class.getName()).get("value"));

    }
}
