public class Calculator {


    public int add(String parameters) throws Exception {

        if (parameters.isEmpty()) {
            return 0;
        }

        String delimiters = ParameterReader.getDelimiters(parameters);
        String numbers = ParameterReader.getNumbers(parameters);
        int sumNumbers = NumericalOperations.getSumNumbers(numbers, delimiters);

        return sumNumbers;
    }

}
