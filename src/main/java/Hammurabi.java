                                 // package declaration
import java.util.Random;         // imports go here
import java.util.Scanner;

public class Hammurabi {         // must save in a file named Hammurabi.java
    Random rand = new Random();  // this is an instance variable
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) { // required in every Java program
        new Hammurabi().playGame();
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