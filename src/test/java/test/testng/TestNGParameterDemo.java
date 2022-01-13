package test.testng;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParameterDemo {

    @Test
    @Parameters({"MyName"})
    public void test(@Optional String name) {
        System.out.println("My name is: " + name);
    }

}
