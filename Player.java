
      
import java.text.*;
import java.io.*;
import java.awt.*;
import java.util.Scanner;
public class Player
{
    
    Scanner playerScanner = new Scanner(System.in); 
    public String name;
    private char type; 
    public Weapon choiceWep;
    private boolean correctWeaponNum=false ;
    public int maxHealth = 100;
    private int playerHealth = 100;
    public Player( String aName, char aType)// constructor, inputs name and type of player class 
    {
            name =aName;
            type = aType; 
    
        //if mage 
        if ((type=='M')||(type=='m'))// did not use toLowerCase because of its data type
            {
             //asks to choose a spell
             mage();
            }        
        //if warriror
         else if ((type=='W')||(type=='w'))
            {
            // ask choose weapon 
             warrior();
            }
        //weapon choice
           int weaponNum = playerScanner.nextInt();
           choiceWep = new Weapon(weaponNum); //inputs the choice into weapon class to get the damage and crit out 
           System.out.println(choiceWep);
    }
    public void mage ()// prints out weapons options for mage 
    {
        System.out.println(name +" ,you have selected mage");
        System.out.println("Now choose a spell of choice by entering the number it is labeled as ");
        System.out.println("crit reffers to the % chance that a hit damage is doubled");
                System.out.println("1.Freeze      "+"50% crit   "+" 5  damage");
                System.out.println("2.Thorns      "+"25% crit   "+" 10 damage");
                System.out.println("3.Fire        "+"15% crit   "+" 15 damage");
                System.out.println("4.Lightning   "+"10% crit   "+" 20 damage");
    }
    
   public void warrior ()// prints out weapons options for  warrior 
   {
    System.out.println(name + " ,you have selected warrior");
    System.out.println("Now choose a weapon of choice by entering the number it is labeled as ");
    System.out.println("crit reffers to the % chance that a hit damage is doubled");
            System.out.println("1.Sword       "+"50% crit   "+" 5  damage");
            System.out.println("2.Battle axe  "+"25% crit   "+" 10 damage");
            System.out.println("3.Mace        "+"15% crit   "+" 15 damage");
            System.out.println("4.War Hammer  "+"10% crit   "+" 20 damage");
    }
   public int getHealth()// getter for health, returns health 
    {
        return playerHealth;
    }
   public void setHealth(int newHealth)// setter for new health, allows changes to be made to player  health when take damage, input is new health.  
    {
        playerHealth= newHealth;
    }
} // end of player class
