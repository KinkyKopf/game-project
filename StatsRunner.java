package gameprototypes;

import java.util.Scanner;

/*
 * Zachary  Kinkopf
 * December 1st
 * test the concepts of storing data outside of my main game class
 * also I am going to turn this into a console for testing methods individually
 * I got this to work suprisingly well and it can add up the average floors as well, so that's pretty sweet
 * there is something super weird about this, it seems like you have a 50% change of being below floor five or getting all the way to 75, usually with only about 1 in 100 not falling in between them
 *
 *TO DO:
 *finish tweaking the values, so far the bow still dies a lot more on the first level
 *
 */
public class StatsRunner 
{
	public static int randomGen(int min, int max)//this is meant to make it easier to get random numbers faster without thinking too much about it.
	{
		return (int)(Math.random()*(max-min+1))+min;
	}


	public static void main(String[] args) throws InterruptedException 
	{
//		Scanner inputTaker= new Scanner(System.in);
//		Weapon testWeapon= new Weapon("");
//		PlayerStats player= new PlayerStats(testWeapon);
		int realTimes=0;
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
		for(int i=0;i<500;i++)
		{
		Rpg1_17 runner = new Rpg1_17("shield");
		runner.main(args);
		realTimes++;
		}
		 CounterFile tabKeeper=new CounterFile();
		System.out.println(tabKeeper);
//		
//		for(int i=0;i<100;i++)
//		{
//			System.out.print(randomGen(0,5-1));
//		}
//		
	}

}