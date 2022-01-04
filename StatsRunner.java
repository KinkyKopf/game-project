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

//	public static void test(PlayerStats Character)
//	{
//		System.out.print(Character.gold);
//	}
//	
	public static void main(String[] args) throws InterruptedException 
	{
		Scanner inputTaker= new Scanner(System.in);
		Weapon testWeapon= new Weapon("shield");
		PlayerStats player= new PlayerStats(testWeapon);
		//TrollStats troll = new TrollStats(1);
		
//		if(1==1|troll.rollDamage(1)==1)
//		{
//			System.out.println(troll.getDamage());
//		}
		
		
		System.out.println(player);
		System.out.println(testWeapon);
		System.out.println(testWeapon.rollDamage(1));
		
		//Rpg1_17.trollFight(inputTaker, player, null, testWeapon);
		Rpg1_17.goblinHorde(inputTaker, player, null, testWeapon);
		
	}

}