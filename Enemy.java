    import java.util.Scanner;
    import java.util.Random;
    public class Enemy
    
{
    private String enemyType;
    private int numHits;
    private int damage;
    private double probHit;
    public int hp;
    Random randHit = new Random();
    
    public Enemy(String inputType)// constructor L imputs the type of enemy the player has elected 
    {
       if (inputType.equals("chicken"))
       {
           numHits = 10;
           damage = 15;
           probHit = 0.2;
           hp = 10;
          }
       else if (inputType.equals("squirrel"))
       {
           numHits = 5;
           damage = 30;
           probHit = 0.4;
           hp = 50;
       }
       else if (inputType.equals("dragon"))
       {
           numHits = 3;
           damage = 50;
           probHit = 0.6;
           hp = 100;
       }
    }
    
    
    public int enemyAttack()// no imputs, outputs how much damage enemy has done 
    {
        System.out.println("The enemy unleashes its attacks!");
        int totalDamage = 0;
        for (int i =0; i<numHits; i++) //for i in range 0 to numHits
        {
            double randomNum = randHit.nextDouble();// generate random number
            // if less than probHit
            if (randomNum <= probHit)
            {
                // add "damage" to "totalDamage"
                totalDamage = totalDamage + damage;
                System.out.println("    you got hit! the enemy has done "+ damage +" damage!"); 
            }
           else
           {
               System.out.println("    the enemy misses! the enemy has "+ (numHits - i - 1) +" attacks left!");
           }
        }
        
        return totalDamage;
    }
}// end of enemy class
