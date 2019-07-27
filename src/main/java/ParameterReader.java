public class ParameterReader {


    public static String getDelimiters(String parameters) {

        String delimiters = ",|\n";

        if (isChangedStandardDelimiter(parameters)) {
            int indexStartDelimiter = 2;
            int indexEndDelimiter = parameters.indexOf("\n");
            if (isALongDelimiter(parameters)) {
                indexStartDelimiter = 3;
                indexEndDelimiter = parameters.indexOf("]\n");
            }
            delimiters = parameters.substring(indexStartDelimiter,indexEndDelimiter);
        }

        return delimiters;
    }


    public static String getNumbers(String parameters) {

        String numbers = parameters;

        if (isChangedStandardDelimiter(parameters)) {
            int indexEndDelimiter = parameters.indexOf("\n");
            int indexStartNumbers = indexEndDelimiter + 1;
            numbers = parameters.substring(indexStartNumbers);
        }

        return numbers;
    }

    private static boolean isALongDelimiter(String parameters) {

        String declarationOfALongDelimiter = "//[";
        return isDeclaredNewDelimiter(parameters, declarationOfALongDelimiter);
    }

    private static boolean isChangedStandardDelimiter(String parameters) {

        String declarationOfADelimiter = "//";
        return isDeclaredNewDelimiter(parameters, declarationOfADelimiter);
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
