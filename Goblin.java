package gameprototypes;

public class Goblin 
{
	 int baseHealth,health,minDamage,maxDamage,accuracy,goblinNum,currentDamage;
	static int numberOfGoblins;
	boolean dead;
	public Goblin(int f) throws InterruptedException
	{
		health = 10+(f*3);
		baseHealth=health;
		
		minDamage = 1+f;
		maxDamage = (int)(minDamage*1.5);
		
		numberOfGoblins++;
		goblinNum=numberOfGoblins;
		
		accuracy=Rpg1_17.randomGen(1, 7);
			if(accuracy>5)
				Rpg1_17.slowPrintln("It looks like goblin "+goblinNum+" has glasses");
			if(accuracy<3)
				Rpg1_17.slowPrintln("Goblin "+goblinNum+" squints at you.");
		Rpg1_17.slowPrintln("Goblin "+goblinNum+" has "+health+" health");

	}
	public void takeDamage(int dam) throws InterruptedException
	{
		health-=dam;
		if(health<=0)
		{
			dead=true;
			Rpg1_17.slowPrintln("Goblin "+goblinNum+" has died!");
			numberOfGoblins--;
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
		if(player.rollEvasion(accuracy))
		{
			Rpg1_17.slowPrintln(",but you dodged the attack!");
			return 0;
		}
		
		currentDamage=Rpg1_17.randomGen(minDamage,maxDamage)-player.characterWeapon.protection; 
		if (currentDamage<=0)
		{
			Rpg1_17.slowPrintln(".but you blocked the attack!");
			return 0;
		}
		return currentDamage;
	}
	
}
