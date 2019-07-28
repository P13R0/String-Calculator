public class ParameterReader {

    private static String declarationOfADelimiter = "//";
    private static String declarationOfALongDelimiter = "//[";

    public static String getDelimiters(String parameters) {

        String delimiters;
        String standardDelimiters = ",|\n";

        delimiters = standardDelimiters;

        if (isDeclaredNewDelimiter(parameters, declarationOfADelimiter)) {

            int indexStartDelimiter = declarationOfADelimiter.length();
            int indexEndDelimiter = parameters.indexOf("\n");

            if (isDeclaredNewDelimiter(parameters, declarationOfALongDelimiter)) {

                indexStartDelimiter = declarationOfALongDelimiter.length();
                indexEndDelimiter = parameters.indexOf("]\n");
            }
            delimiters = parameters.substring(indexStartDelimiter,indexEndDelimiter);
        }

        return delimiters;
    }

    public static String getNumbers(String parameters) {

        String numbers = parameters;

        if (isDeclaredNewDelimiter(parameters, declarationOfADelimiter)) {
            int indexEndDelimiter = parameters.indexOf("\n");
            int indexStartNumbers = indexEndDelimiter + 1;
            numbers = parameters.substring(indexStartNumbers);
        }

        return numbers;
    }

    private static boolean isDeclaredNewDelimiter(String parameters, String declarationOfADelimiter) {

        boolean isLongEnough = parameters.length() > declarationOfADelimiter.length();
        boolean isDeclaredANewDelimiter = false;

        if (isLongEnough) {
            String declarationInParameters = parameters.substring(0,declarationOfADelimiter.length());
            isDeclaredANewDelimiter = declarationInParameters.equals(declarationOfADelimiter);
        }

        return isDeclaredANewDelimiter;
    }

}
