public class Calculator {


    public int add(String parameters) throws Exception {

        if (parameters.isEmpty()) {
            return 0;
        }

        String delimiters = getDelimiters(parameters);
        String numbers = getNumbers(parameters);

        return getSumNumbers(numbers, delimiters);
    }


    private String getDelimiters(String parameters) {

        String delimiters = ",|\n";

        if (isChangedStandardDelimiter(parameters)) {
            int indexStartDelimiter = 2;
            int indexEndDelimiter = parameters.indexOf("\n");
            delimiters = parameters.substring(indexStartDelimiter,indexEndDelimiter);
        }

        return delimiters;
    }


    private boolean isChangedStandardDelimiter(String parameters) {

        String declarationOfADelimiter = "//";
        boolean isLongEnough = parameters.length() > declarationOfADelimiter.length();
        boolean isDeclaredADelimiter = false;

        if (isLongEnough) {
            String declarationInParameters = parameters.substring(0,declarationOfADelimiter.length());
            isDeclaredADelimiter = declarationInParameters.equals(declarationOfADelimiter);
        }

        return isDeclaredADelimiter;
    }


    private String getNumbers(String parameters) {

        String numbers = parameters;

        if (isChangedStandardDelimiter(parameters)) {
            int indexEndDelimiter = parameters.indexOf("\n");
            int indexStartNumbers = indexEndDelimiter + 1;
            numbers = parameters.substring(indexStartNumbers);
        }

        return numbers;
    }


    private int getSumNumbers(String numbers, String delimiters) throws Exception {

        int sum = 0;

        String[] separateNumbers = numbers.split(delimiters);
        throwsAnExceptionIfNegativeNumbers(separateNumbers);

        for (String number:separateNumbers) {
            if (!isTooBigNumber(number)) {
                sum += Integer.parseInt(number);
            }
        }

        return sum;
    }


    private void throwsAnExceptionIfNegativeNumbers(String[] numbers) throws Exception {

        String messageError = "negatives not allowed:";

        for (String number:numbers) {
            if (number.contains("-")) {
                messageError += " " + number;
            }
        }

        if (!messageError.equals("negatives not allowed:")) {
            throw new Exception(messageError);
        }
    }


    private boolean isTooBigNumber(String number) {
        return Integer.parseInt(number) > 1000;
    }
}
