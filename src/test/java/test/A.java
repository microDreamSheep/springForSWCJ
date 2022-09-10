package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {

    @Autowired
    B b;
    @Autowired
    C c;
    public void print()
    {
        for (String s : b.name()) {
            System.out.println(s);
        }
        for (String s : c.name()) {
            System.out.println(s);
        }
    }
}
