public class Calculator {

    public int add(String numbers) {

        if (numbers.isEmpty()) {
            return 0;
        }

        int sum = 0;
        String[] separateNumbers = numbers.split(",|\n");
        for (String number:separateNumbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
