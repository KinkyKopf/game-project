package gameprototypes;

import java.util.Scanner;

/*
 * Zachary Kinkopf
 * December 1st
 * test the concepts of storing data outside of my main game class
 * also I am going to turn this into a console for testing methods individually
 */
public class StatsRunner 
{
	public static int randomGen(int min, int max)//this is meant to make it easier to get random numbers faster without thinking too much about it.
	{
		return (int)(Math.random()*(max-min+1))+min;
	}


	public static void main(String[] args) throws InterruptedException 
	{
		Scanner inputTaker= new Scanner(System.in);
		Weapon testWeapon= new Weapon("");
		PlayerStats player= new PlayerStats(testWeapon);
		//TrollStats troll = new TrollStats(1);
		
//		if(1==1|troll.rollDamage(1)==1)
//		{
//			System.out.println(troll.getDamage());
//		}
//		
//		
//		System.out.println(player);
//		System.out.println(testWeapon);
//		System.out.println(testWeapon.rollDamage(1));
//		
//		//Rpg1_17.trollFight(inputTaker, player, null, testWeapon);
		//Rpg1_17.goblinHorde(inputTaker, player, null, testWeapon);
		
//Auto Run code:________________________
		Rpg1_17 runner = new Rpg1_17(3,"sword");
		runner.main(args);
		
//		
//		for(int i=0;i<100;i++)
//		{
//			System.out.print(randomGen(0,5-1));
//		}
//		
	}

}