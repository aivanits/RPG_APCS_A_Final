import java.util.Scanner;
import java.util.Random;
public class Fight
{
          
      Scanner fightScanner = new Scanner(System.in);
      Random rand = new Random();
      private double crit; // crit variable 
      private double damage;// damage variable
      private double randomNum; // random number variable 
      private Player plyr;// player object variable 
      private boolean fightAgain = true;

    
          public Fight( Player in_plyr) // takes in information from player class
    {
            plyr=in_plyr;
            // takes in whether the player wants to fight again 
            while (fightAgain==true)
           { 
                 crit  =  plyr.choiceWep.getCrit();// gets the critical damage of the player 
                
                 // show enemies options
                 System.out.println("Select an enemy to fight by entering the number label");
                 System.out.println("1.Chicken              10hp");
                 System.out.println("2.Agressive squirrel   50hp");
                 System.out.println("3.Dragon               100hp");
                 
                //ask which enemy to fight
                int enemySelect = fightScanner.nextInt();
                if (enemySelect ==1)
                {
                  System.out.println("you have chosen to fight Chicken");
                  Enemy enemy = new Enemy("chicken");
                  playerHit(enemy);
                }
                else if (enemySelect ==2)
                {
                  System.out.println("you have chosen to fight Agressive squirrel");
                  Enemy enemy = new Enemy("squirrel");
                     playerHit(enemy);
                }
                else if(enemySelect ==3)
                {
                  System.out.println("you have chosen to fight Dragon");
                  Enemy enemy = new Enemy("dragon");
                  playerHit(enemy);
                }
                    
                plyr.setHealth(plyr.maxHealth);// regenerate
                System.out.println("you have regenerated back to " + (plyr.getHealth()) + " health points");
                    
                System.out.println("");
    
            }
    }
    
    public void playerHit(Enemy enemy)// method for when the player wants to hit the enemy, imput enemy object
    {
        String hitAgainString;
        damage = plyr.choiceWep.getDamage();
        boolean hitAgain=true;
        fightScanner.nextLine(); // fix bug with nextint and nextline interfering , this line was with help from google and my brother
        
        while ((hitAgain == true) && (enemy.hp>0))
        {
            randomNum = rand.nextDouble();//random number 0- 1.0
            
            System.out.println("enemy has " + enemy.hp + " health");
            System.out.print(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"); 
            System.out.println("\ntype \"hit\" to attack again or \"run\" to run");
            hitAgainString = fightScanner.nextLine(); 

           // if statement for if the player wants to hit or run 
            if( hitAgainString.toLowerCase().equals("hit"))
            {
                hitAgain=  true;
                if (crit>=randomNum)
                {
                    System.out.println("CRITICAL HIT double the damage given");
                    enemy.hp = enemy.hp - (int)(damage*2);
                }
                else
                {
                    System.out.println("no crit, regular damage given");
                    enemy.hp -= damage;
                }
                
                System.out.println("");   
                plyr.setHealth(plyr.getHealth() - enemy.enemyAttack());
            }
            else if (hitAgainString.toLowerCase().equals("run"))
            {
                System.out.println("wimp! you run from the battle!");
                hitAgain = false;
            }
            else
            {
                System.out.println("invalid move!");
            }
            
            System.out.println(""); 

           // if statement to tell health and also to check if dead after each battle  
            if (plyr.getHealth() > 0)
            {
                System.out.println(plyr.name + " has " + plyr.getHealth() + " health points remaining");
            }
            else 
            {
                System.out.println(plyr.name + " has died!");
                System.exit(0);
            }
        }
        //when enemy is dead
        if (enemy.hp <= 0)
        {
            
            System.out.println(" "); 
            System.out.println("you have defeated the enemy!Your weapon will now get +20% crit chance if possible due to an increase in skill");
            //add 20% to crit as prize
            if (crit >=1.0)
            {
                System.out.println("your weapon now has 100% crit chance! you are at max skill and all enemies now run away in fear! Congrats you won the game!" );
                System.exit(0);
            }
            else 
            {
                crit = crit+0.2;
                plyr.choiceWep.setCrit(crit);//FIX
                System.out.println("your weapon how has "+ (crit*100) +"% crit chance!");
            }
        }
        
        System.out.println("type \"fight again\" to battle another enemy, if you want to end the game type \"stop\"");
    
        String fightAgainString =  fightScanner.nextLine(); 
        //checks if player wants to fight another enemy or end the program
        if (fightAgainString.equals("fight again") )
        {
            fightAgain=true;
        }
        else if  (fightAgainString.equals("stop"))
        {
            fightAgain= false;
            System.out.println("goodbye!");
            System.exit(0);
            
            System.out.println("");
            
        }
        
    }
} // End of public class Fight 
