package homework1;

public class Obstacle {
    private Action action;
    private int energyCount;

    public Obstacle(Action action, int energyCount) {
        this.action = action;
        this.energyCount = energyCount;
    }

    public Action getAction() {
        return action;
    }

    public int getEnergyCount() {
        return energyCount;
    }
}
