import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class ArrayManiplator {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        int[] numbers = Arrays.stream(scann.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();

        String[] command = scann.nextLine().split("\\s+");

        while (!command[0].equals("end")) {

            if (command[0].equals("exchange")) {
                int indexExchange = Integer.parseInt(command[1]);
                numbers = exchangeArray(indexExchange, numbers);

            } else if (command[0].equals("max") || command[0].equals("min")) {
                System.out.println(getMaxOrMinIndex(command[0], command[1], numbers));
            } else if (command[0].equals("first") || command[0].equals("last")) {
                System.out.println(getFirstOrLastElementsNtimes(command[0], command[2], numbers, Integer.parseInt(command[1])));
            }

            command = scann.nextLine().split("\\s+");
        }

        System.out.print("[");
        System.out.print(Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
        System.out.print("]");
    }

    private static String getFirstOrLastElementsNtimes(String commandType, String numberType, int[] numbers, int n) {
        if (n > numbers.length) return "Invalid count";

        int[] filteredNumbers;

        if (numberType.equals("even")) {
            filteredNumbers = Arrays.stream(numbers).filter(e -> e % 2 == 0).toArray();
        } else {
            filteredNumbers = Arrays.stream(numbers).filter(e -> e % 2 != 0).toArray();
        }

        StringBuilder output = new StringBuilder();

        if (filteredNumbers.length == 0) return "[" + "]";
        else if (filteredNumbers.length == 1) {
            output.append("[");
            output.append(filteredNumbers[0]);
            output.append("]");
            return output.toString();
        }
        else if(n>filteredNumbers.length){
            output.append("[");
            output.append(Arrays.stream(filteredNumbers).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
            output.append("]");
            return  output.toString();
        }

        output.append("[");
        if (commandType.equals("first")) {
            output.append(Arrays.stream(filteredNumbers, 0, n).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
        } else if (commandType.equals("last")) {
            output.append(Arrays.stream(filteredNumbers, filteredNumbers.length-n , filteredNumbers.length).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
        }
        output.append("]");
        return output.toString();
    }

    private static String getMaxOrMinIndex(String commandType, String numberType, int[] numbers) {
        int[] filteredNumbers;
        if (numberType.equals("even")) {
            filteredNumbers = Arrays.stream(numbers).filter(e -> e % 2 == 0).toArray();
        } else {
            filteredNumbers = Arrays.stream(numbers).filter(e -> e % 2 != 0).toArray();
        }

        Integer index = -1;
        if (commandType.equals("max")) {
            index = getIndex(numbers, Arrays.stream(filteredNumbers).max());
        } else if (commandType.equals("min")) {
            index = getIndex(numbers, Arrays.stream(filteredNumbers).min());
        }

        return index == -1 ? "No matches" : index.toString();
    }

    private static int getIndex(int[] numbers, OptionalInt element) {

        if (!element.isPresent()) return -1;

        for (int i = numbers.length - 1; i >= 0; i--) {
            if (element.getAsInt() == numbers[i]) {
                return i;
            }
        }

        return -1;
    }

    private static int[] exchangeArray(int indexExchange, int[] numbers) {

        if (indexExchange < 0 || indexExchange >= numbers.length) {
            System.out.println("Invalid index");
            return numbers;
        } else {
            int[] newNumbers = new int[numbers.length];
            int indexCopy = indexExchange + 1;//to get the right side of the original array like iter

            int indexNewArray = 0;
            //copy right side of the original array
            while (indexCopy < newNumbers.length) {
                newNumbers[indexNewArray] = numbers[indexCopy++];
                indexNewArray++;
            }
            indexCopy = indexExchange + 1;
            //copy left side of the original array
            for (int i = 0; indexNewArray < newNumbers.length; i++) {
                newNumbers[indexNewArray++] = numbers[i];
            }
            return newNumbers;
        }
    }
}