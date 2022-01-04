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
	static int numberOfGoblins,startingNum;
	boolean dead;
	public Goblin(int f) throws InterruptedException
	{
		
		health = 10+(f*3);
		baseHealth=health;
		
		minDamage = 1+f;
		maxDamage = (int)(minDamage+3*1.5);
		
		startingNum++;
		numberOfGoblins++;
		goblinNum=numberOfGoblins;
		
		accuracy=Rpg1_17.randomGen(-3, 4);
			if(accuracy>2)
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