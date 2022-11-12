import java.util.Objects;
import java.util.Random;

public class GameEngine {

    public static void main(String[] args) {

        int year = 0;
        int starved = 0;
        int priceOfLand = 19;

        Hammurabi newGame = new Hammurabi();

        String userName = Console.getStringInput("Hello welcome to a new game of Hammurabi, please enter your name to continue");

        while (year < 10 && starved < 45  ) { //happy kingdom check && (newGame.getbushelsOwned() > (newGame.getPopulation()*20) )

            year = year + 1;
            int acrePurchaseBushels = Console.getIntegerInput("O great " + userName + "!\n" +
                    "    You are in year "+ year +" of your ten year rule.\n" +
                    "    In the previous year 0 people starved to death.\n" +
                    "    In the previous year 5 people entered the kingdom.\n" +
                    "    The population is now 100.\n" +
                    "    We harvested 3000 bushels at 3 bushels per acre.\n" +
                    "    Rats destroyed 200 bushels, leaving 2800 bushels in storage.\n" +
                    "    The city owns 1000 acres of land.\n" +
                    "At the current price of " + priceOfLand + " bushels per acre, how many bushels worth of land would you like?");

            newGame.askHowManyAcresToBuy(priceOfLand,acrePurchaseBushels);

            int random = (int) ((Math.random() * (50)) + 1 );
            priceOfLand = random;
        }
    }
}