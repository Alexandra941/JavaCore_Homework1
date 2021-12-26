package homework3;

import java.util.ArrayList;
import java.util.Collection;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits;

    public Box() {
    }

    public Box(ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public void clearBox() {
        this.fruits.clear();
    }

    public void addFruitToBox(T fruit) {
        if (this.fruits == null) {
            this.fruits = new ArrayList<T>();
            this.fruits.add(fruit);
            return;
        }

        this.fruits.add(fruit);
    }

    public double getWeight() {
        return this.fruits == null || this.fruits.isEmpty()
            ? 0d
            : this.fruits.stream().mapToDouble(f -> f.getWeight()).sum();
    }

    public boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }

    public void swapFruits (Box box){
        ArrayList<? super T> tempFruitBox = new ArrayList<>(box.getFruits());
        box.clearBox();
        box.fruits.addAll(this.fruits);

        this.clearBox();
        this.fruits.addAll((Collection<? extends T>) tempFruitBox);
    }

    public String getFruitName() {
        if (this.fruits == null || this.fruits.isEmpty())
            return new Fruit().getFruitName();

        return this.fruits.stream().findFirst().get().getFruitName();
    }
}
