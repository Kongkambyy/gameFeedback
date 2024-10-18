public class Game {
    int gameID;
    String titel;
    String genre;
    double price;

    public Game (String titel, String genre, double price) {
        this.gameID = GameSystem.addGameCounter;
        this.titel = titel;
        this.genre = genre;
        this.price = price;
    }
    public int getGameID() {
        return gameID;
    }
    public String getTitel() {
        return titel;
    }
    public String getGenre() {
        return genre;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }
    public void setTitel(String titel) {
        this.titel = titel;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void displayDetails() {
        System.out.println("Game ID: " + gameID);
        System.out.println("Titel: " + titel);
        System.out.println("Genre: " + genre);
        System.out.println("Price: " + price);
    }
}

