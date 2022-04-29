import java.util.ArrayList;
import java.util.Random;

/**
 * This stores all information for every character used.
 *
 * @author Mustafa Osmani
 * @version 04/29/2022
 */
public class Character
{
    // instance variables 
    private String name;
    private int health;
    private HeroClass type;
    private int luck;
    private ArrayList<String> item;
    /**
     * Constructor for objects of class Character
     * 
     * @param name The title of the character.
     * @param health Amount of health the character has.
     * @param type The Power System the character is in.
     * @param luck The amount of luck points the character has.
     */
    public Character(String name, int health, HeroClass type, int luck)
    {
        // initialise instance variables
        this.name = name;
        this.health = health;
        this.type = type;
        this.luck = luck;
        this.item = new ArrayList<String>();
    }
    
    public Character() {
        // initialise instance variables
        this.name = name;
        this.health = health;
        this.type = type;
        this.luck = luck;
        this.item = new ArrayList<String>();
    }
    
    /**
     * This method finds the name of a certain character.
     *
     * @return The name of the character.
     */
    public String getName()
    {
        // put your code here
        return this.name;
    }
    
    /**
     * This method saves the name to a certain character.
     * 
     * @param n This is the name that will be saved to the character.
     */
    public void setName(String n)
    {
        this.name = n;
    }
    
    /**
     * This method gives the amount of health a certain character has.
     *
     * @return The amount of health of the character.
     */
    public int getHealth()
    {
        return this.health;
    }
    
    /**
     * This method saves the amount of health to a certain character.
     *
     * @param h This is the amount of health that will be saved.
     */
    public void setHealth(int h)
    {
        this.health = h;
    }
    
    /**
     * This method finds the Power System class of a certain character.
     *
     * @return The Power Class of the character.
     */
    public HeroClass getHeroClass()
    {
        return this.type;
    }
    
    /**
     * This method saves a Power System class to a certain character.
     *
     * @param t This is the Power System class that will be saved.
     */
    public void setHeroClass(HeroClass t)
    {
        this.type = t;
    }
    
    /**
     * This method finds the amount of luck a certain character has.
     *
     * @return The amount of luck the character has.
     */
    public int getLuck()
    {
        return this.luck;
    }
    
    /**
     * This method saves an amount of luck to a certain character.
     *
     * @param l This is the amount of luck that will be saved.
     */
    public void setLuck(int l)
    {
        this.luck = l;
    }
    
    /**
     * This method finds a specific item of a certain character.
     *
     * @return The item requested.
     */
    public ArrayList<String> getItem()
    {
        return this.item;
    }
    
    /**
     * This method adds a specific item to the character's inventory.
     *
     * @param thing This is the specific item that will be added to the 
     * inventory.
     */
    public void addItem(String thing)
    {
        item.add(thing);
        System.out.println(thing.toUpperCase() + " has been added to your inventory.");
    }
    
    /**
     * This method checks if the character has a certain item.
     *
     * @param thing This is the item being searched for in the character's
     * inventory.
     * @return true if item is in inventory and false if item is not in
     * inventory.
     */
    public boolean hasItem(String thing)
    {
        if(item.indexOf(thing) > -1) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * This method prints information about the character's health. If 
     * character has no health left, it will say the character is dead.
     *
     */
    public void printHealth() {
        System.out.println("(" + this.name + "'s current health is " + this.health + "/100.)");
        if (this.health == 0) {
            System.out.println("");
            System.out.println(this.name + " is dead.");
        }
    }
    
    /**
     * This method informs the character when they perform a good deed or
     * bad deed. It will also add or subtract luck points based on the 
     * character's actions.
     *
     * @param deed This is a number signifying if the deed is good or bad.
     * @param sin This is the title of the deed performed.
     */
    public void printLuck(int deed, String sin) {
        if (deed == -1) { 
            System.out.println("You chose to " + sin + ". (-1 luck points)");
            this.luck = (this.luck - 1);
        } else {
            System.out.println("You chose to " + sin + ". (+1 luck points)");
            this.luck = (this.luck + 1);
        }
    }
    
    //fighting
    /**
     * This method displays the amount of damage the character takes, which is
     * caused by a specific enemy. It also saves the new health amount after 
     * the damage is counted.
     *
     * @param dam This is the maximum amount of damage that can be caused to
     * the character.
     * @param enemy This is the name of the enemy that attacked the character.
     * @param attack This is the name of the attack the character received.
     */
    public void EnemyDamage(int dam, String enemy, String attack) {
        Random rand = new Random();
        int damage = rand.nextInt(dam-10) +10;
        this.health = (this.health - damage);
        System.out.println(enemy + " has " + attack + " you for " + damage + " damage.");
    }
    
    //endgame
    /**
     * This method displays evey award won. It also displays the amount of
     * points the character has won. It exits the program after completion.
     *
     * @param a This is the ending number that the character has arrived at.
     * param t This is the name of the award based on the Power System class
     * of the character. It is only used in specific endings.
     */
    public void printAwards(int a, String t) {
        int totalPoints = 0;
        System.out.println("----------------- THE END ---------------------");
        System.out.println("");
        System.out.println("----------------- ACHIEVEMENTS ---------------------");
        System.out.println("");
        if (a == 1) {
            System.out.println("{A TRUE MONSTER}");
            System.out.println(" - You joined forces with Millard and took over the world");
            totalPoints += -5000;
            System.out.println("");
        }
        if (a == 2) {
            System.out.println("{A TRUE HERO}");
            System.out.println(" - You sacrificed yourself for the survival of the world");
            totalPoints += 9999;
            System.out.println("");
        }
        if (a == 3) {
            System.out.println("{"+t+"}");
            System.out.println(" - You became the hero you always wanted...");
            totalPoints += 5000;
            System.out.println("");
        }
        if (a == 4) {
            System.out.println("{HEAL THE WORLD}");
            System.out.println(" - You saved the town, saved your friends, AND survived");
            totalPoints += 100000;
            System.out.println("");
        }
        if (this.luck >= 3) {
            System.out.println("{A PURE HEART}");
            System.out.println(" - You've done at least 3 good deeds.");
            totalPoints += 300;
            System.out.println("");
        }
        if (this.luck < 3) {
            System.out.println("{TAINTED SOUL}");
            System.out.println(" - You've committed some sins, kid");
            totalPoints -= 300;
            System.out.println("");
        }
        
        System.out.println("TOTAL POINTS: " + totalPoints);
        System.exit(0);
    }
}

