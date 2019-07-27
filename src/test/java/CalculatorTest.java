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
    public void sumForAnEmptyStringReturnZero() throws Exception {

        assertEquals(0, calculator.add(""));
    }

    @Test
    public void sumForASingleNumberReturnTheSameNumber() throws Exception {

        assertEquals(1, calculator.add("1"));
    }

    @Test
    public void sumOfFiftyFiveIsFiftyFive() throws Exception {

        assertEquals(55, calculator.add("55"));
    }

    @Test
    public void sumOfOneAndTwoIsTree() throws Exception {

        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    public void sumOfFiveAndTwoIsSeven() throws Exception {

        assertEquals(7, calculator.add("5,2"));
    }

    @Test
    public void sumOfThreeNumbers() throws Exception {

        assertEquals(763, calculator.add("10,3,750"));
    }

    @Test
    public void sumOfFiveNumbers() throws Exception {

        assertEquals(53, calculator.add("1,24,9,16,3"));
    }

    @Test
    public void handleNewLinesCharacterBetweenNumbers() throws Exception {

        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    public void supportDifferentDelimiters() throws Exception {

        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test
    public void supportDelimiterLongThreeCharacters() throws Exception {

        assertEquals(6, calculator.add("//[***]\n1***2***3"));
    }

    @Test
    public void negativeNumbersThrowAnException() throws Exception {

        try {
            int sum = calculator.add("1,4,-1");
        } catch (Exception e){
            assertEquals("negatives not allowed: -1", e.getMessage());
        }
    }

    @Test
    public void multipleNegativeNumbersThrowAnException() throws Exception {

        try {
            int sum = calculator.add("-20,7,-16,13,-4");
            fail();
        } catch (Exception e){
            assertEquals("negatives not allowed: -20 -16 -4", e.getMessage());
        }
    }

    @Test
    public void ignoreNumbersBiggerThan1000() throws Exception {

        assertEquals(2, calculator.add("2,1001"));
    }

    @Test
    public void ignoreMultipleNumbersBiggerThan1000() throws Exception {

        assertEquals(1022, calculator.add("1000,5,1200,3000,17"));
    }
}