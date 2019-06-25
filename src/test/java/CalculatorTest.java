import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void sumForAnEmptyStringReturnZero() {

        assertEquals(0, calculator.add(""));
    }

    @Test
    public void sumForASingleNumberReturnTheSameNumber() {

        assertEquals(1, calculator.add("1"));
    }

    @Test
    public void sumOfFiftyFiveIsFiftyFive() {

        assertEquals(55, calculator.add("55"));
    }

    @Test
    public void sumOfOneAndTwoIsTree() {

        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    public void sumOfFiveAndTwoIsSeven() {

        assertEquals(7, calculator.add("5,2"));
    }
}