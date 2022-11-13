   // package declaration
import java.util.Objects;
import java.util.Random;         // imports go here
import java.util.Scanner;

public class Hammurabi {         // must save in a file named Hammurabi.java

    private int priceOfBushels;
    private int landValue;
    private int bushelsOwned;
    private int population;
    private int acresOwned;
    static Random rand = new Random();

    public int getPriceOfBushels() {
        return priceOfBushels;
    }

    public void setPriceOfBushels(int priceOfBushels) {
        this.priceOfBushels = priceOfBushels;
    }

    public int getLandValue() {
        return landValue;
    }

    public void setLandValue(int landValue) {
        this.landValue = landValue;
    }

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

    public Hammurabi(int landValue, int bushelsOwned, int population, int acresOwned) {
        this.landValue = landValue;
        this.bushelsOwned = bushelsOwned;
        this.population = population;
        this.acresOwned = acresOwned;
    }

    public Hammurabi() {
        this.landValue = 19;
        this.bushelsOwned = 2800;
        this.population = 100;
        this.acresOwned = 1000;
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

    void playGame() {
        // declare local variables here: grain, population, etc.
        // statements go after the declations
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

    //other methods go here
}