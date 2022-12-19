
public class Weapon
{
    int damage;// weapon damage
    double crit ;// weapon crit 
   public Weapon(int weaponNum)
   {
      // gives weapon certian damages and crit chances based on the number imputed
      if (weaponNum ==1)
      {
        damage = 5;
        crit = 0.5;
      }
      else if(weaponNum ==2)
      {
        damage = 10;
        crit = 0.25;
      }
      else if (weaponNum ==3)
      {
        damage = 15;
        crit = 0.15;
      }
      else if (weaponNum ==4)
      {
        damage = 20;
        crit = 0.1;
      }
      
    }
    public int getDamage()// returns the damage the weapon does 
    {
        return damage;
    }
    public double getCrit()// returns the critical hit chace of the wepon
    {
        return crit;
    }
    public void setCrit(double newCrit) // sets a new crit with imput of new crit parameter 
    {
    crit=newCrit;
    }
    public String toString() // returns information about the weapon 
    {
     return "your weapon does "+ damage + " damage. And has " + crit + "% crit chance";
    }
}//end of weapon class
