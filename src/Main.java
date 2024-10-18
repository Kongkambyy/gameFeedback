import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    static GameSystem gameSystem = new GameSystem();
    static Scanner input = new Scanner(System.in);

    //Metode til at tilføje et Spil
    public static void opretNytSpil(){
        System.out.println("Hvad er spillets Titel?");
        String thisTitel = input.next();
        System.out.println("Hvilken genre?");
        String thisGenre = input.next();
        System.out.println("Hvad er prisen?");
        double thisPrisen = input.nextDouble();             //Brugeren indtaster værdier som skal bruges til at oprette et spil

        Game game = new Game(thisTitel, thisGenre, thisPrisen);         //Opretter et spil "game" (brugeren har ikke nogen "gameNr" endnu)

        gameSystem.addGame(game);           // tilføjer "game" til systemet gennem classen Game og metoden addGame
    }
    public static void opretGamesAutomatisk(){

        //Denne metode er kun til test. Den opretter bare nogle Games Som man kan bruge i programmet


        Game game = new Game( "minecraft", "Sandbox", 12.99);
        Game game1 = new Game("Call Of Duty", "FPS", 19.99);
        Game game2 = new Game( "Counter Strike", "FPS", 0);
        Game game3 = new Game( "Euro Truck Simulator 2", "Simulation", 19.99);

        gameSystem.addGame(game);
        gameSystem.addGame(game1);
        gameSystem.addGame(game2);
        gameSystem.addGame(game3);
    }
    public static void opretBrugerAutomatisk(){

        //denne metode er kun til test. Den opretter bare nogle brugere som man kan bruge i prgrammet

        Player user = new Player("Shillerx", 23, 23.3);
        Player user1 = new Player("Candi2", 15, 40.2);
        Player user2 = new Player("LungiDlon", 34, 20.3);
        Player user3 = new Player("HippieTrippieB", 23, 48);

        gameSystem.addPlayer(user);
        gameSystem.addPlayer(user1);
        gameSystem.addPlayer(user2);
        gameSystem.addPlayer(user3);
    }
    public static void showGameInfo(){
        gameSystem.displayAllGames();           //Kalder metoden displayAllGames() i gameSystem  (Udskriver alle indformationer til consol)
    }
    public static void topScorePlayerUdskriv(){
        gameSystem.findTopScorePlayer();            //Kalder metoden findTopScorePlayer() i gameSystem (finder og udskriver den bruger med den højeste score)
    }
    public static void updatePlayersScore(){
        showPlayerInfo();                           //udskriver en liste med alle spillere så man ved hvad man skal redigere

        System.out.println("hvilke spilId vil du redigere?");
        int thisGameID = input.nextInt();                           //Brugeren indtaster SpilId på den spiller de vil redigere

        System.out.println("Hvad skal den nye score være?");
        double thisNewScore = input.nextDouble();                 // Brugeren indtaster den værdi de vil redigere scoren til på den spiller de lige har valg

        gameSystem.updatePlayerScore(thisGameID, thisNewScore);     //kalder metoden updatePlayerScore() med parameterne som brugeren lige har indtasted


    }
    public static void showPlayerInfo(){
        gameSystem.displayAllPlayers();
    }                                           //kalder metoden displayAllPlayers som udskriver alle Players

    public static void addPlayer(){

        System.out.println("Indtast dit navn/Nametag");
        String thisName = input.next();

        System.out.println("Indtast din alder");
        int thisAge = input.nextInt();
        double thisScore = 0.0;                             //Brugeren indtaster først værdierne på en spiller (minus playerId)

        Player player = new Player(thisName, thisAge, thisScore);         //der bliver oprettet en spiller med navnet player
        gameSystem.addPlayer(player);                                   //player bruger så addPlayer (skabelon) til at oprette en spiller i systemet
    }


    public static void spillerMenu() {
        int loop = 1;
        while (loop != 0) {                                             //dette er menuen man ser når man vælger spiller i hovedmenuen
            System.out.println("SpillerMenu");
            System.out.println("1:  Opret ny spiller");
            System.out.println("2:  opdatere spillere score");
            System.out.println("3:  vis info om alle spillere");
            System.out.println("4:  vis topScore");
            System.out.println("20: opret brugere automatisk (test)");
            System.out.println(" ");
            System.out.println("0: gå tilbage til hovedmenu");

            int valg = input.nextInt();
            switch (valg){
                case 1:
                    addPlayer();
                    break;
                case 2:
                    updatePlayersScore();
                    break;
                case 3:{
                    showPlayerInfo();
                    break;
                }
                case 4:{
                    topScorePlayerUdskriv();
                    break;
                }
                case 0:{
                    start();
                    loop = 0;
                    break;
                }
                case 20:{
                    opretBrugerAutomatisk();
                    break;
                }
            }
        }
    }

    public static void gamesMenu(){
        int startLoopGames = 1;
        //Dette er menuen man ser når man vælger games i hovedmenuen
        while (startLoopGames != 0) {
            System.out.println("Hvilken funktion vil du bruge?");
            System.out.println("denne funktion virker ikke endnu!!!");
            System.out.println("1:  Opret spil");
            System.out.println("2:  list alle spil");
            System.out.println("3:  total Revenue");
            System.out.println("20: Opret test spil");
            System.out.println(" ");
            System.out.println("0: afslut program");
            int valg = input.nextInt();
            switch (valg){
                case 1:
                    opretNytSpil();
                    break;

                case 2:
                    showGameInfo();
                    break;

                case 3:
                    gameSystem.calculateTotalRevenue();
                    break;

                case 20:
                    opretGamesAutomatisk();
                    break;
                case 0:
                    startLoopGames = 0;
            }

        }
    }


    public static void start(){
        //Det her er den første menu man ser når man starter programmet. Her fra kan man komme ind i de 2 andre menuer der er.
        int startLoop = 0;

        System.out.println("Hvilken funktion vil du bruge?");
        System.out.println("1. Spiller funktion");
        System.out.println("2. Games funktion");

        startLoop = input.nextInt();
        if (startLoop == 1) {
            spillerMenu();
        }else if (startLoop == 2) {
            gamesMenu();
        } else {
            System.out.println("forkert indtastning");
            start();
        }


    }

    public static void main(String[] args) {

        start();
    }
}