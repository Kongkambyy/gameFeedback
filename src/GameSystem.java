import java.util.Scanner;
public class GameSystem {
    static Scanner keyboardInput = new Scanner(System.in);
    private Game[] gamesArray = new Game[10];
    private Player[] playersArray = new Player[10];
    public static int addPlayerCounter = 0; // counter til hvor mange Spillere der er
    public static int addGameCounter = 0; //counte til hvor mange spil der er

    public GameSystem() {}

    public void addGame(Game game) {
        if (addGameCounter < gamesArray.length) {
            int gameId = addGameCounter;
            Game newGame = new Game(game.titel, game.genre, game.price);
            gamesArray[addGameCounter] = newGame;
            addGameCounter++;
        }
    }
    public void displayAllGames(){

        for (int i = 0; i < gamesArray.length; i++){
            if (gamesArray[i] != null) {
                gamesArray[i].displayDetails();
                System.out.println(" ");
            }
        }
    }
    public Game findGameById(int gameID){
            for (int i = 0; i < gamesArray.length; i++){
                if (gamesArray[i].getGameID() == gameID){
                    return gamesArray[i];
                }
            }
        return null;
    }

    public void addPlayer(Player player) {
        if (addPlayerCounter < playersArray.length){
                int playerId = addPlayerCounter;
            Player newPlayer = new Player(player.name, player.age, player.score);
            playersArray[addPlayerCounter] = newPlayer;
            addPlayerCounter++;
        }

    }
    public void updatePlayerScore(int gameID, double newScore){
        Player player = findPlayerById(gameID);
            if (player != null){
                player.updateScore(newScore);
                System.out.println("Ny score for Player: " + gameID +  " = " + newScore );
            }else System.out.println("Player blev ikke fundet");

    }

    public Player findPlayerById(int playerId){
         for (int i = 0; i < addPlayerCounter ; i++){
                if (playersArray[i].getPlayerId() == playerId && playersArray[i] != null){
                     return playersArray[i];

                }
        }
        return null;
    }

    public void displayAllPlayers(){
        for (int i = 0; i < addPlayerCounter; i++){
            if (playersArray[i] != null){
                playersArray[i].displayDetails();
                System.out.println(" ");
        }   }
    }

    public void findTopScorePlayer(){
        int max = 0;

        for (int i = 0; i < addPlayerCounter; i++){
            if (playersArray[i].getScore() > playersArray[max].getScore()){
                max = i;
            }
        }
        System.out.println(" ");
        System.out.println("Den højeste scorende Player er:");
        playersArray[max].displayDetails();
        System.out.println(" ");
    }
    public void calculateTotalRevenue() {
        double thisWallet = 0;
        double[] profitArray = new double[gamesArray.length];

        for (int i = 0; i < gamesArray.length; i++) {
            if (gamesArray[i] != null) {
                System.out.println("hvor mange har du solgt af " + gamesArray[i].titel);
                int solgte = keyboardInput.nextInt();
                thisWallet = thisWallet + gamesArray[i].getPrice() * solgte;
            }
        }
        System.out.println(" ");
        System.out.println("din wallet er på: " + thisWallet);
        System.out.println(" ");


    }
}
