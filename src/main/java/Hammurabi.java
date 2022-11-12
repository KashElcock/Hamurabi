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

    public int newCostOfLand() { return 0;
    }

    public int plagueDeaths(int i) { return 0;
    }

    public int starvationDeaths(int i, int i1) { return 0;
    }

    public boolean uprising(int i, int i1) { return false;
    }

    public int immigrants(int i, int i1, int i2) { return 0;
    }

    public int harvest(int i) {return 0;
    }

    public int grainEatenByRats(int i) {return 0;
    }

    //other methods go here
}