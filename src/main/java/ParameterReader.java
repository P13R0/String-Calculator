import java.util.ArrayList;

public class ParameterReader {

    private final static String declarationOfADelimiter = "//";

    public static ArrayList<String> getDelimiters(String parameters) {

        ArrayList<String> delimiters = new ArrayList<String>();

        delimiters.add(",");
        delimiters.add("\n");

        if (isDeclaredNewDelimiter(parameters, declarationOfADelimiter)) {

            int indexStartDelimiter = declarationOfADelimiter.length();
            int indexEndDelimiter = parameters.indexOf("\n");

            parameters = parameters.substring(indexStartDelimiter,indexEndDelimiter);

            while (parameters.contains("[")) {

                indexStartDelimiter = parameters.indexOf("[")+1;
                indexEndDelimiter = parameters.indexOf("]");

                delimiters.add(parameters.substring(indexStartDelimiter, indexEndDelimiter));
                parameters = parameters.substring(indexEndDelimiter+1);
            }

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
