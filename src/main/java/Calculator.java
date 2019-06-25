public class Calculator {

    public int add(String numbers) {

        int sum = 0;
        int delimiterPosition;

        if (numbers.isEmpty()) {
            return 0;
        }

        while (numbers.contains(",") || numbers.contains("\n")) {

            delimiterPosition = 0;

            if (numbers.contains(",") && numbers.contains("\n")) {
                if (numbers.indexOf(",") < numbers.indexOf("\n")) {
                    delimiterPosition = numbers.indexOf(",");
                }
                else {
                    delimiterPosition = numbers.indexOf("\n");
                }
            }
            else {
                if (numbers.contains(",")) {
                    delimiterPosition = numbers.indexOf(",");
                }
                if (numbers.contains("\n")) {
                    delimiterPosition = numbers.indexOf("\n");
                }
            }

            sum += Integer.parseInt(numbers.substring(0, delimiterPosition));
            numbers = numbers.substring(delimiterPosition + 1);
        }

        sum += Integer.parseInt(numbers);

        return sum;
    }
}
