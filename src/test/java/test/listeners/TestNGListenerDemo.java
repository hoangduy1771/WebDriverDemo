package test.listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListeners.class)
public class TestNGListenerDemo {

    @Test
    public void test1() {
        System.out.println("I'm inside test 1");
    }

    @Test
    public void test2() {
        System.out.println("I'm inside test 2");
        Assert.assertTrue(false);
    }

    @Test
    public void test3() {
        System.out.println("I'm inside test 3");
        throw new SkipException("Skip this test");
    }


}
