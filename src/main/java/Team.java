public class Team {
    private String teamName;
    private Person[] members;

    public Team(String teamName, Person[] members) {
        this.teamName = teamName;
        this.members = members;
    }

    public void printAllMembersInfo() {
        System.out.println("Информация о всех участниках команды \"" + this.teamName + "\"");
        for (Person person: this.members) {
            System.out.println(person);
        }
        System.out.println();
    }

    public void printAllFinishCourseMembersInfo() {
        System.out.println("Информация о участниках команды \"" + this.teamName + "\", успешно прошедших дистанцию");
        for (Person person: this.members) {
            if (person.allActionsFinished())
                System.out.println(person);
        }
        System.out.println();
    }

    public void overcomeObstacles(Obstacle obstacle) {
        for (Person member : this.members) {
            switch (obstacle.getAction()){
                case Swim: {
                    member.swim(obstacle.getEnergyCount());
                    break;
                }
                case Run: {
                    member.run(obstacle.getEnergyCount());
                    break;
                }
                case Jump: {
                    member.jump(obstacle.getEnergyCount());
                    break;
                }
            }
        }
    }

    public void showResults() {
        printAllMembersInfo();
        printAllFinishCourseMembersInfo();
    }
}
