
//**********************************************************
// Assignment: RPG Game Semster Final 
// Assigned:  January
// Due Date:  1/27/2021
//
// Course: APCS-A 
//
// Author: Ivanitskiy, Alice
//
//
// Honor Code: I pledge that this program represents my own
// program code. I received help from my Mr.Behmer, my brother and google in understanding and debugging my program.
//(my brother helped me with a bit of debugging that I tried for a long time to fix,such as on line 64 of fight class) 
//( i used google to call a char variable on line 39 of main as I was not sure how to do so, credit is given where needed, also used it to reaserch some errors I had to help fix and understand them)  
//*********************************************************

import java.util.Scanner;
public class RunRPG
{
   public static void main(String[] args)  
   {
        boolean fightAgain=true; // variable to check if player wants to fight again 
  
        boolean correctInput=false; // variable to see if imput for type is correct 
        Scanner genScanner = new Scanner(System.in);
        System.out.println("~~Groundrim~~~"); 
        System.out.println("Alice Ivanitskiy, Huron High School, 2022, CSA"); 
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~"); 
        //intro
            System.out.println("In this game you get to choose a carachter to fight with and weapons to use to fight battles with super dangerous enemies.");
        //player creation
            //ask for name 
            System.out.println("What is your charachters name?"); 
            String name = genScanner.nextLine(); 
            //ask for type ( mage or warrior)
            System.out.println( name + " you can be a or a mage, a warrior fights with heavy weapons and does more base damage while mages cast spells which have a higher chance of getting critical hits");
            System.out.println(" Do you wish to be a warrior(W) or a mage(M) ( enter a charachter )");
            char type = genScanner.next().charAt(0); //taken from :  https://stackoverflow.com/questions/13942701/take-a-char-input-from-the-scanner
          // while loop to make sure input is correct  
      for (int i=1;i<=3;i++)
      {
      if ( correctInput ==false) 
      {
        
        if (type=='w'||type=='W'||type=='M'||type=='m')
        {
            correctInput =true;
            break;
        }
        else 
        {
          System.out.println("please enter a W or M, stop being dumb, you have " + (3-i) + " attempts left");
          type = genScanner.next().charAt(0); 
        }
        if (i==2)
        { 
            System.out.println("this is stupid, load the program again and get some braincells, its not hard just type a w or m >:(" );
            System.exit(0);
        }
      }
    }
      //create object for player with parameters name and type
          Player player1= new Player(name, type);
      // Fight              
          // describe the setting          
          System.out.println("in the woods or whatever oooop sppookykky scary game descriptions");
          System.out.println("");
           //run battle 
          Fight fight = new Fight( player1);     
          genScanner.nextLine();//press enter to continue
}
 } //end of main method
// AAH CompSci Java template
