public class Player {
    int playerId;
    String name;
    int age;
    double score;

    public Player(String name, int age, double score) {
        this.playerId = GameSystem.addPlayerCounter;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public int getPlayerId() {
        return playerId;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getScore() {
        return score;
    }
    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setScore(double score) {
        this.score = score;
    }
    public void displayDetails() {
        System.out.println("Player ID: " + playerId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Score: " + score);
    }
    public void updateScore(double newScore) {
        this.score = newScore;
    }
}
