public class Main {
    public static void main(String[] args) {
        Team team = new Team(
                "Рыбоньки",
                new Person[] {
                        new Person("Карась", 10, 58),
                        new Person("Лосось", 10, 154),
                        new Person("Вобла", 10, 68),
                        new Person("Щука", 10, 100)
                });

        Course course = new Course(new Obstacle[] {
                new Obstacle(Action.Swim, 15),
                new Obstacle(Action.Run, 25),
                new Obstacle(Action.Jump, 35)
        });

        course.overcomeObstacles(team);

        team.showResults();
    }
}
