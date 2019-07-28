import java.util.ArrayList;

public class NumericalOperations {


    public static int getSumNumbers(String numbers, ArrayList<String> delimiters) throws Exception {

        int sumNumbers = 0;
        final String standardDelimiter = ";";
        String[] separateNumbers;

        for (String delimiter:delimiters) {
            numbers = numbers.replace(delimiter, standardDelimiter);
        }

        separateNumbers = numbers.split(standardDelimiter);

        throwsAnExceptionIfNegativeNumbers(separateNumbers);

        for (String number:separateNumbers) {
            if (!isTooBigNumber(number)) {
                sumNumbers += Integer.parseInt(number);
            }
        }

        return sumNumbers;
    }


    private static void throwsAnExceptionIfNegativeNumbers(String[] numbers) throws Exception {

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


    private static boolean isTooBigNumber(String number) {
        return Integer.parseInt(number) > 1000;
    }

}
