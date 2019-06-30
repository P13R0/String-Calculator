public class NumericalOperations {


    public static int getSumNumbers(String numbers, String delimiters) throws Exception {

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
