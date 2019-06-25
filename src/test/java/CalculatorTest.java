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

    @Test
    public void sumOfThreeNumbers() {

        assertEquals(763, calculator.add("10,3,750"));
    }

    @Test
    public void sumOfFiveNumbers() {

        assertEquals(53, calculator.add("1,24,9,16,3"));
    }

    @Test
    public void handleNewLinesCharacterBetweenNumbers() {

        assertEquals(6, calculator.add("1\n2,3"));
    }
}