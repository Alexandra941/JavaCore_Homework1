public interface IAction {

    /**
     * Плавать.
     * @param energyCount количество затрачиваемой энергии.
     */
    void swim(int energyCount);

    /**
     * Бегать.
     * @param energyCount количество затрачиваемой энергии.
     */
    void run(int energyCount);

    /**
     * Прыгать.
     * @param energyCount количество затрачиваемой энергии.
     */
    void jump(int energyCount);
}
