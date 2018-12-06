package cz.speedygonzales.demo;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author vondracek
 * @since 25.10.2015 15:15
 */
@Ignore
public class TestDemo {

    @Test(expected = ArithmeticException.class)
    public void testNull() {

        int i = 1/0;
    }

    @Ignore("Test ignores method testIgnoring()")
    @Test
    public void testIgnoring() {}

    @Test(timeout = 1000)
    public void testTimeout() {
        while (true);
    }
}
