package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {

    @Autowired
    B b;
    public void print()
    {
        for (String s : b.name()) {
            System.out.println(s);
        }
    }
}
