public class Course {
    private Obstacle[] obstacles;

    public Course(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    public void overcomeObstacles(Team team) {
        for (Obstacle obstacle : obstacles) {
            team.overcomeObstacles(obstacle);
        }
    }
}
