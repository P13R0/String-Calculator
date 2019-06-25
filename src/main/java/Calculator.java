public class Calculator {

    public int add(String numbers) {

        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiters = ",|\n";
        if (numbers.length() > 1 && numbers.substring(0,2).equals("//")) {
            delimiters = numbers.substring(2,numbers.indexOf("\n"));
            numbers = numbers.substring(numbers.indexOf("\n")+1);
        }
        int sum = 0;
        String[] separateNumbers = numbers.split(delimiters);
        for (String number:separateNumbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
