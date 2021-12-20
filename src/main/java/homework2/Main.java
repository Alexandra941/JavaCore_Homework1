package homework2;

public class Main {
    public static void main(String[] args) {
        int sum;
        try {
            sum = arraySum(new String[][]
                    {
                            {"1", "2", "3", "4"},
                            {"5", "6", "7", "8"},
                            {"9", "10", "3s", "12"},
                            {"13", "14", "15", "16"}
                    });
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Произошла ошибка при попытке вычислить сумму всех элементов массива");
            System.out.println(e.getMessage());
            return;
        }

        System.out.printf("Сумма всех элементов массива равна = %d", sum);
    }

    private static int arraySum(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr == null || arr.length != 4)
            throw new MyArraySizeException("Размер массива не может быть отличным от 4х4");

        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null || arr[i].length != 4) {
                throw new MyArraySizeException("Размер массива не может быть отличным от 4х4");
            }
            for (int j = 0; j < arr[i].length; j++) {
                int currentValue;
                try {
                    currentValue = Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException(String.format("Не верные данные в ячейке [%d , %d]", i, j));
                }
                result += currentValue;
            }
        }

        return result;
    }
}
