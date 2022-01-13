package test.testng;

import org.junit.Before;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase {

    @BeforeTest
    void setUp() {
        System.out.println("This is set up");
    }

    @Test
    void testStep() {
        System.out.println("Test steps are running...");
    }

    @AfterTest
    void tearDown() {
        System.out.println("Tearing down");
    }


}
