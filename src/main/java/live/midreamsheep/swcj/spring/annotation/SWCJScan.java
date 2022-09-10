package live.midreamsheep.swcj.spring.annotation;

import live.midreamsheep.swcj.spring.bean.SWCJImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(java.lang.annotation.ElementType.TYPE)
@Import(SWCJImportBeanDefinitionRegistrar.class)
public @interface SWCJScan {
    String value() default "";
}
