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
        return esempio(parameters, declarationOfALongDelimiter);
    }

    private static boolean esempio(String parameters, String declarationOfALongDelimiter) {
        boolean isLongEnough = parameters.length() > declarationOfALongDelimiter.length();
        boolean isDeclaredALongDelimiter = false;

        if (isLongEnough) {
            String declarationInParameters = parameters.substring(0,declarationOfALongDelimiter.length());
            isDeclaredALongDelimiter = declarationInParameters.equals(declarationOfALongDelimiter);
        }

        return isDeclaredALongDelimiter;
    }

    private static boolean isChangedStandardDelimiter(String parameters) {


        String declarationOfADelimiter = "//";
        return esempio(parameters, declarationOfADelimiter);
    }

}
