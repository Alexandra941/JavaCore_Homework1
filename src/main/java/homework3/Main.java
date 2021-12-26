package homework3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] swapArray = new String[] { "one", "two", "three", "four", "five" };
        System.out.println(Arrays.toString(swapArray));
        swapElements(swapArray, 1, 5);
        System.out.println(Arrays.toString(swapArray));

        Box<Apple> firstBox = new Box<>();
        Box<Orange> secondBox = new Box<>();

        System.out.printf("Вес коробки с %s %f \n", firstBox.getFruitName(), firstBox.getWeight());
        System.out.printf("Вес коробки с %s %f \n", firstBox.getFruitName(), firstBox.getWeight());
        System.out.printf("Коробки равны: %s \n", (firstBox.compare(secondBox) ? "да" : "нет"));

        firstBox.addFruitToBox(new Apple());
        firstBox.addFruitToBox(new Apple());
        secondBox.addFruitToBox(new Orange());
        secondBox.addFruitToBox(new Orange());
        System.out.printf("Вес коробки с %s %f \n", firstBox.getFruitName(), firstBox.getWeight());
        System.out.printf("Вес коробки с %s %f \n", secondBox.getFruitName(), secondBox.getWeight());
        System.out.printf("Коробки равны: %s \n", (firstBox.compare(secondBox) ? "да" : "нет"));

        firstBox.addFruitToBox(new Apple());
        System.out.printf("Вес коробки с %s %f \n", firstBox.getFruitName(), firstBox.getWeight());
        System.out.printf("Вес коробки с %s %f \n", secondBox.getFruitName(), secondBox.getWeight());
        System.out.printf("Коробки равны: %s \n", (firstBox.compare(secondBox) ? "да" : "нет"));

        firstBox.swapFruits(secondBox);
        System.out.printf("Вес коробки с %s %f \n", firstBox.getFruitName(), firstBox.getWeight());
        System.out.printf("Вес коробки с %s %f \n", secondBox.getFruitName(), secondBox.getWeight());
        System.out.printf("Коробки равны: %s \n", (firstBox.compare(secondBox) ? "да" : "нет"));
    }

    private static <T> void swapElements(T[] arr, int firstIndex, int secondIndex) {
        if (arr.length <= firstIndex || arr.length <= secondIndex)
            return;

        T temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
