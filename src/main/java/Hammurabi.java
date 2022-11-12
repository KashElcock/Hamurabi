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

    }

    public int askHowManyAcresToBuy(int price, int bushels){
        int toalPrice = bushels*price;
        if (toalPrice<this.bushelsOwned){
            this.bushelsOwned -= bushels;
            this.acresOwned += bushels/price;
            this.priceOfBushels = price;
        }
        return bushels/price;
    }

    public int askHowManyAcresToSell(int acresOwned){
        if(acresOwned < this.acresOwned){
            this.acresOwned -= acresOwned;
            this.bushelsOwned += acresOwned*priceOfBushels;
        }
        return acresOwned;
    }
    public int askHowMuchGrainToFeedPeople(int bushels){
        return bushels;
    }

    public int askHowManyAcresToPlant(int acresOwned, int population, int bushels){
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