import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void sumForAnEmptyStringReturnZero() {
        Calculator calculator = new Calculator();

        assertEquals(0, calculator.add(""));
    }
}