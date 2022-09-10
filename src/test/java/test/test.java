package test;

import live.midreamsheep.swcj.spring.annotation.SWCJScan;
import live.midreamsheep.swcj.spring.bean.SWCJFactoryBean;
import org.junit.Test;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("test")
@SWCJScan(value = "test")
public class test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(test.class);
        A a = (A) context.getBean("a");
        a.print();
    }
}
