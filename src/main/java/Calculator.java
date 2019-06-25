public class Calculator {

    public int add(String numbers) {

        int sum = 0;
        int comaPosition;

        if (numbers.isEmpty()) {
            return 0;
        }

        while (numbers.contains(",")) {
            comaPosition = numbers.indexOf(",");
            sum += Integer.parseInt(numbers.substring(0, comaPosition));
            numbers = numbers.substring(comaPosition + 1);
        }

        sum += Integer.parseInt(numbers);

        return sum;
    }
}
