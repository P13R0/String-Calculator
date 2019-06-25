public class Calculator {

    public int add(String numbers) {

        if (numbers.isEmpty()) {
            return 0;
        }

        if (numbers.contains(",")) {
            int sum = 0;
            int comaPosition = numbers.indexOf(",");

            sum += Integer.parseInt(numbers.substring(0,comaPosition));
            numbers = numbers.substring(comaPosition+1);

            if (numbers.contains(",")) {
                comaPosition = numbers.indexOf(",");
                sum += Integer.parseInt(numbers.substring(0,comaPosition));
                numbers = numbers.substring(comaPosition+1);
            }
            sum += Integer.parseInt(numbers);

            return sum;
        }

        return Integer.parseInt(numbers);
    }
}
