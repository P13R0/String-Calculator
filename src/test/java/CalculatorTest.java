import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void sumForAnEmptyStringReturnZero() {
        Calculator calculator = new Calculator();

        assertEquals(0, calculator.add(""));
    }

    @Test
    public void sumForASingleNumberReturnTheSameNumber() {
        Calculator calculator = new Calculator();

        assertEquals(1, calculator.add("1"));
    }
}