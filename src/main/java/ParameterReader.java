public class ParameterReader {


    public static String getDelimiters(String parameters) {

        String delimiters = ",|\n";

        if (isChangedStandardDelimiter(parameters)) {
            int indexStartDelimiter = 2;
            int indexEndDelimiter = parameters.indexOf("\n");
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


    private static boolean isChangedStandardDelimiter(String parameters) {

        String declarationOfADelimiter = "//";
        boolean isLongEnough = parameters.length() > declarationOfADelimiter.length();
        boolean isDeclaredADelimiter = false;

        if (isLongEnough) {
            String declarationInParameters = parameters.substring(0,declarationOfADelimiter.length());
            isDeclaredADelimiter = declarationInParameters.equals(declarationOfADelimiter);
        }

        return isDeclaredADelimiter;
    }

}
