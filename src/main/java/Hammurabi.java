import java.util.Random;
import java.util.Scanner;

public class Hammurabi { //Hammurabi Class

    // Object Fields
    private int bushelsOwned;
    private int acresOwned;
    private int population;
    private int totalDeaths;
    private int percentDied;
    private int year;
    private int immigrants;
    private int harvest;
    private int starved;
    private int priceOfLand;
    private int priceOfBushels;
    private static String userName;
    static boolean plague = false;


    // ALL METHODS

        //Main method to run new game

    public static void main(String[] args) {
        new Hammurabi().playGame();
    }


        //Play Game Method

    void playGame() {

        setUserName(getStringInput("Hello welcome to a new game of Hammurabi, please enter your name to continue"));

        while (year < 10 && starved < 45){
            year = year + 1;

            //NEW YEAR SUMMARY
            int userInput = getIntegerInput("HELLO " + getUserName() + "!\n" +
                    "    Welcome to year "+ getYear() +" of your ten year rule.\n" +
                    "    Last year: "+ getStarved() + " people starved to death.\n" +
                    "               "+ getImmigrants() +" people entered the kingdom.\n" +
                    "    This year: The population is now "+ getPopulation() +".\n" +
                    "               We harvested "+ getHarvest() + " bushels.\n" +
                    "               Rats destroyed "+ 0 +" bushels, leaving " + getbushelsOwned() + " bushels in storage.\n" +
                    "               The city owns " + getAcresOwned() + " acres of land.\n" +
                    "At the current price of " + getPriceOfLand() + " bushels per acre, would you like to buy or sell land this year?" +
                    "\nTo Buy: Enter 1\nTo Sell: Enter 2\nPress any other key to skip");

            //BUY OR SELL LAND THIS YEAR?
            if(userInput == 1 ){
                int buy = getIntegerInput("At the current price of " + priceOfLand + " bushels per acre, how many bushels worth of land would you like to buy?");
                askHowManyAcresToBuy(priceOfLand,buy);
            } else if (userInput == 2) {
                int sell = getIntegerInput("At the current price of " + priceOfLand + " bushels per acre, how many bushels worth of land would you like to sell?");
                askHowManyAcresToSell(acresOwned);
            } else {
                System.out.println("Fine we'll do what we did last year");
            }

            //FEED POPULATION
            int bushelsToFeedPopulation = getIntegerInput("Oh " + userName + ", don't forget to feed your people! \nHow many bushels of grain should we allocate?");
            askHowMuchGrainToFeedPeople(bushelsToFeedPopulation);

            //PLANT GRAIN FOR NEXT YEAR
            int howManyAcresToPlant = getIntegerInput("How many acres to plant with grain?, We must have enough acres, enough grain, and enough people to do the planting. Any grain left over will go into storage for next year");

            //END OF YEAR OPERATIONS
            setPriceOfLand(newCostOfLand());
        }

        if(getYear() == 10) {
            System.out.println("Thank you for your great service to the Kingdom! The people are happy and your legacy secured! Enjoy retirement " + getUserName());
        } else {
            System.out.println("The people are furious and you've been overthrown!");
        }
    }

        // IO Methods

    public static void print(String output, Object... args) {
        System.out.printf(output, args);
    }
    public static void println(String output, Object... args) {
        print(output + "\n", args);
    }
    public static String getStringInput(String prompt) {
        Scanner scanner = null;
        String userInput;
        do
            try {
                scanner = new Scanner(System.in);
                println(prompt);
                userInput = String.valueOf(scanner.nextLine());
                return userInput;
            } catch (Exception e) {
                System.out.println("Have you gone mad?! Please come to your senses!");
                boolean error = true;
            }
        while (true);
    }
    public static Integer getIntegerInput(String prompt) {
        Scanner scanner = null;
        int userInput;
        do
            try {
                scanner = new Scanner(System.in);
                println(prompt);
                userInput = Integer.parseInt(scanner.nextLine());
                return userInput;
            } catch (Exception e) {
                System.out.println("Have you gone mad?! Please come to your senses!");
                boolean error = true;
            }
        while (true);
    }


        //Setters and Getters

    public int getbushelsOwned() {
        return bushelsOwned;
    }
    public void setbushelsOwned(int bushelsOwned) {
        this.bushelsOwned = bushelsOwned;
    }
    public int getPopulation() {
        return population;
    }
    public void setPopulation(int population) {
        this.population = population;
    }
    public int getAcresOwned() {
        return acresOwned;
    }
    public void setAcresOwned(int acresOwned) {
        this.acresOwned = acresOwned;
    }
    public int getTotalDeaths() {
        return totalDeaths;
    }
    public void setTotalDeaths(int totalDeaths) {
        this.totalDeaths = totalDeaths;
    }
    public int getPercentDied() {
        return percentDied;
    }
    public void setPercentDied(int percentDied) {
        this.percentDied = percentDied;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getStarved() {
        return starved;
    }
    public void setStarved(int starved) {
        this.starved = starved;
    }
    public int getPriceOfLand() {
        return priceOfLand;
    }
    public void setPriceOfLand(int priceOfLand) {
        this.priceOfLand = priceOfLand;
    }
    public static String getUserName() {
        return userName;
    }
    public static void setUserName(String userName) {
        Hammurabi.userName = userName;
    }
    public static boolean isPlague() {
        return plague;
    }
    public static void setPlague(boolean plague) {
        Hammurabi.plague = plague;
    }
    public static void setRand(Random rand) {
        Hammurabi.rand = rand;
    }
    public int getImmigrants() {
        return immigrants;
    }
    public void setImmigrants(int immigrants) {
        this.immigrants = immigrants;
    }
    public int getHarvest() {
        return harvest;
    }
    public void setHarvest(int harvest) {
        this.harvest = harvest;
    }

        // GamePlay Methods
    static Random rand = new Random();
    public Hammurabi(int priceOfLand, int bushelsOwned, int population, int acresOwned) {
        this.priceOfLand = priceOfLand;
        this.bushelsOwned = bushelsOwned;
        this.population = population;
        this.acresOwned = acresOwned;
    }
    public Hammurabi() {
        this.bushelsOwned = 2800;
        this.population = 100;
        this.acresOwned = 1000;
        this.priceOfLand = 19;
    }
    public int askHowManyAcresToBuy(int price, int acresWantToBuy){
        int total=acresWantToBuy*price;  //Total Bushels needed to buy land
        if (total<this.bushelsOwned){
            this.bushelsOwned -= total;    //He paid bushels to purchase
            this.acresOwned += acresWantToBuy;  //Increase the acres as Player bought more Acres
            this.priceOfBushels = price;   //Random price generated each year
        }
        return acresOwned;
    }
    public int askHowManyAcresToSell(int acresOwned){
        if(acresOwned < this.acresOwned){
            this.acresOwned -= acresOwned; //Player sold the land
            this.bushelsOwned += acresOwned*priceOfBushels; //Get bushels as currency for selling land
        }
        return this.acresOwned;
    }
    public int askHowMuchGrainToFeedPeople(int bushels){
        int fedPopulation=bushels/20;//Each person needs at least 20 bushels of grain per year to survive
        if(bushels<this.bushelsOwned) this.bushelsOwned-=bushels;
        return fedPopulation;
    }
    public int askHowManyAcresToPlant(int acresOwned, int population, int bushels){
        //Ask the player how many acres to plant with grain, and returns that number.
        //
        // You must have enough acres,
        // enough grain, and
        // enough people to do the planting.
        // Any grain left over goes into storage for next year.
      /*  if(this.acresOwned>acresOwned && (this.population*10)>population && (this.bushelsOwned < numberofAcerstoPlant*2){
            this.bushelsOwned-=numberofAcerstoPlant * 2;
        }
        return acresOwned;*/


        //Check the player has enough acres to harvest
        //Chcek enough persons are there(Each person can farm at most 10 acres of land)
        //Check bushels(It takes 2 bushels of grain to farm an acre of land)
        if(this.acresOwned>acresOwned && (this.population*10)>population && (this.bushelsOwned/2)>bushels){
           this.bushelsOwned-=bushels/2;
        }
        return acresOwned;
    }
    public int newCostOfLand() {//int newCostOfLand()
      //  The price of land is random, and ranges from 17 to 23 bushels per acre.
        //  Return the new price for the next set of decisions the player has to make.
        int rannum = rand.nextInt(23  - 17 +1) + 17;
        int newprice = rannum;
        return newprice;
    }
    public int plagueDeaths(int i) {
        int numberOfPlagueDeaths = 0;
        if(rand.nextInt(100) < 15){
            numberOfPlagueDeaths = i / 2;
        }

        return numberOfPlagueDeaths;
    }
    public int starvationDeaths(int i, int i1) {
        int busheslsNeededForPopulation =0;
        int numStarvationDeaths = 0;
        int extraBushells = 0;
        busheslsNeededForPopulation = i *20; // i is population.
        if(i1 < busheslsNeededForPopulation) {
             extraBushells =  busheslsNeededForPopulation - i1; //i1 is bushelsFedToPeople.

        }
        if(extraBushells % 20 != 0) {
            numStarvationDeaths = (extraBushells / 20) + 1; // if it is not divisible by 20 that means there is a decimal, needed for extra person came less that is te reason added +1.
        } else {
            numStarvationDeaths = extraBushells / 20;
        }


        return numStarvationDeaths;
    }
    public boolean uprising(int i, int i1) { //boolean uprising(int population, int howManyPeopleStarved)

        boolean upRising = false;
        double percentDeath = ((double)i1 / (double)i)*100;
       // System.out.println("my calculation" + percentDeath);
        if(percentDeath > 45){
            upRising = true;
        }


        return upRising;
    }
    public int immigrants(int i, int i1, int i2) {  //int immigrants(int population, int acresOwned, int grainInStorage)

      int numOfImmigrants =   (20 * i1 + i2) / (100 * i) + 1;


        return numOfImmigrants;
    }
    public int harvest(int i) { //int harvest(int acres, int bushelsUsedAsSeed)
        //Choose a random integer between 1 and 6, inclusive. Each acre that was planted with seed will yield this many bushels of grain.
      int ranNum =   rand.nextInt(6 - 1 + 1) + 1;
       int numBushellsharvested = i * ranNum;
        return numBushellsharvested;
    }
    public int grainEatenByRats(int i) { //int grainEatenByRats(int bushels)
        //There is a 40% chance that you will have a rat infestation.
        // When this happens, rats will eat somewhere between 10% and 30% of your grain. Return the amount of grain eaten by rats (possibly zero).
        int grainseatenbyrats = 0;
        int ratinfestation = rand.nextInt(100);
        if(ratinfestation < 40){
            int rannum = rand.nextInt(30  - 10+1) + 10;
            grainseatenbyrats = i * rannum / 100;
        }


        return grainseatenbyrats;
    }


} //Hammurabi Class Ends