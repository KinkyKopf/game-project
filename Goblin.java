package gameprototypes;

public class Goblin 
{
	
	/*
	 * to DO: 
	 * ____________________
	 * 
	 * fix the roll To hit in the goblins
	 */
	 int baseHealth,health,minDamage,maxDamage,accuracy,goblinNum,currentDamage;
	static int numberOfGoblins,startingNum=0;
	boolean dead;
	private double hlthMultiplier,dmgMultiplier;

	public Goblin(int f) throws InterruptedException
	{
		if(f<6)
		{
			hlthMultiplier=2;
			dmgMultiplier=.80;
		}
		else if(f<10)
		{
			hlthMultiplier=5;
			dmgMultiplier=1.2;
		}
		else if(f<20)
		{
			hlthMultiplier=10;
			dmgMultiplier=3;
		}
		health = 15+(int)(f*hlthMultiplier);
		baseHealth=health;
		
		minDamage = (int)(1+(dmgMultiplier*f));
		maxDamage = (int)(1+minDamage*2+f*dmgMultiplier);
		
		startingNum++;
		numberOfGoblins++;
		goblinNum=numberOfGoblins;
		
		accuracy=Rpg1_17.randomGen(-3, 3);
			if(accuracy>0)
				Rpg1_17.slowPrintln("It looks like goblin "+goblinNum+" has glasses");
			if(accuracy<0)
				Rpg1_17.slowPrintln("Goblin "+goblinNum+" squints at you.");
		Rpg1_17.slowPrintln("Goblin "+goblinNum+" has "+health+" health");

	}
	public void takeDamage(int dam) throws InterruptedException
	{
		if(health>0)
		{
		health-=dam;
			if(health<=0)
			{
				dead=true;
				Rpg1_17.slowPrintln("Goblin "+goblinNum+" has died!");
				numberOfGoblins--;
					
			}
		}
		else
		{
			Rpg1_17.slowPrintln("I'm gonna be honest with you champ, you can't kill a corpse, so I would just stop");
		}
	}
	public String toString()
	{
		if(dead)
			return"Goblin "+goblinNum+" is dead.";
		return "Goblin "+goblinNum+" has "+health+" health remaining";
		
	}
	public int rollDamage(PlayerStats player) throws InterruptedException
	{
		if(player.rollToHit(accuracy))
		{
			currentDamage=0;
			return 0;
		}
		
		currentDamage=Rpg1_17.randomGen(minDamage,maxDamage)-player.characterWeapon.protection; 
		if (currentDamage<=0)
		{
			Rpg1_17.slowPrintln("You blocked the attack!");
			return 0;
		}
		return currentDamage;
	}
	
}