public class Calculator {

    public int add(String parameters) throws Exception {

        if (parameters.isEmpty()) {
            return 0;
        }

        String delimiters = getDelimiters(parameters);
        String numbers = getNumbers(parameters);

        return getNumbersSum(numbers, delimiters);
    }


    private String getDelimiters(String text) {

        String delimiters = ",|\n";

        if (hasChangedStandardDelimiter(text)) {
            delimiters = text.substring(2,text.indexOf("\n"));
        }

        return delimiters;
    }


    private boolean hasChangedStandardDelimiter(String text) {
        return text.length() > 1 && text.substring(0,2).equals("//");
    }


    private String getNumbers(String text) {

        String numbers = text;

        if (hasChangedStandardDelimiter(numbers)) {
            numbers = numbers.substring(numbers.indexOf("\n")+1);
        }

        return numbers;
    }


    private int getNumbersSum(String numbers, String delimiters) throws Exception {

        int sum = 0;

        String[] separateNumbers = numbers.split(delimiters);
        for (String number:separateNumbers) {
            throwsAnExceptionIfNegativeNumber(number);
            sum += Integer.parseInt(number);
        }

        return sum;
    }

    private void throwsAnExceptionIfNegativeNumber(String number) throws Exception {
        if (number.contains("-")) {
            throw new Exception("negatives not allowed: -1");
        }
    }
}
