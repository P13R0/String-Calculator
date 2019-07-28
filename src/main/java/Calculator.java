import java.util.ArrayList;

public class Calculator {


    public int add(String parameters) throws Exception {

        if (parameters.isEmpty()) {
            return 0;
        }

        ArrayList<String> delimiters = ParameterReader.getDelimiters(parameters);
        String numbers = ParameterReader.getNumbers(parameters);
        int sumNumbers = NumericalOperations.getSumNumbers(numbers, delimiters);

        return sumNumbers;
    }

}
