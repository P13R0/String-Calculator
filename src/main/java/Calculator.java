public class Calculator {

    public int add(String numbers) {

        int argumentOne;
        int argumentTwo;

        if (numbers.isEmpty()) {
            return 0;
        }

        if (numbers.contains(",")) {
            argumentOne = Integer.parseInt(numbers.substring(0,numbers.indexOf(",")));
            argumentTwo = Integer.parseInt(numbers.substring(numbers.indexOf(",")+1));
            return argumentOne + argumentTwo;
        }

        return Integer.parseInt(numbers);
    }
}
