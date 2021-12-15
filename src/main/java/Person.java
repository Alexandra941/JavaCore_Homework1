public class Person implements IAction {
    private String name;
    private int age;
    private int energy;
    private boolean swam;
    private boolean ran;
    private boolean jumped;

    public String getName() {
        return name;
    }

    public Person(String name, int age, int energy) {
        this.name = name;
        this.age = age;
        this.energy = energy;
    }

    public boolean allActionsFinished() {
        return this.swam && this.ran && this.jumped;
    }

    @Override
    public void swim(int energyCount) {
        if (gotEnergyForAction(energyCount)) {
          this.energy -= energyCount;
          this.swam = true;
        }
    }

    @Override
    public void run(int energyCount) {
        if (gotEnergyForAction(energyCount)) {
            this.energy -= energyCount;
            this.ran = true;
        }
    }

    @Override
    public void jump(int energyCount) {
        if (gotEnergyForAction(energyCount)) {
            this.energy -= energyCount;
            this.jumped = true;
        }
    }

    @Override
    public String toString() {
        return "Имя " + this.name +
                ",Осталось энергии " + this.energy +
                ", Преодоленные препятствия:" +
                " Плаванье " + getStringBoolValue(this.swam) + ";" +
                " Бег " + getStringBoolValue(this.ran) + ";" +
                " Прыжки " + getStringBoolValue(this.jumped) + ";";
    }

    private boolean gotEnergyForAction(int energyCount) {
        return this.energy >= energyCount;
    }

    private String getStringBoolValue(boolean val) {
        return val ? "Да" : "Нет";
    }
}
