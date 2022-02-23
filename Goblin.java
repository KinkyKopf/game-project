package gameprototypes;


public class Goblin 
{
	
	/*
	 * to DO: 
	 * ____________________
	 * add evasion stat
	 * find out what current damage is and add it
	 * 
	 * Done:
	 * ___________________
	 * fix the roll To hit in the goblins
	 */
	 int baseHealth,armor,health,minDamage,maxDamage,accuracy,goblinNum,currentDamage,evasion;
	static int numberOfGoblins;
	static int startingNum=0;
	private double hlthMultiplier;
	private double dmgMultiplier;
	boolean dead;
	boolean stunned;

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
		health = 10+(int)(f*hlthMultiplier);
		baseHealth=health;
		
		minDamage = (int)(1+(dmgMultiplier*f));
		maxDamage = (int)(1+minDamage*2+f*dmgMultiplier);
		
		startingNum++;
		numberOfGoblins++;
		goblinNum=numberOfGoblins;
		
		accuracy=Rpg1_18.randomGen(-3, 3);
			if(accuracy>0)
				Rpg1_18.slowPrintln("It looks like goblin "+goblinNum+" has glasses");
			if(accuracy<0)
				Rpg1_18.slowPrintln("Goblin "+goblinNum+" squints at you.");
		Rpg1_18.slowPrintln("Goblin "+goblinNum+" has "+health+" health");

	}
	public void takeDamage(int dam) throws InterruptedException
	{
		if(health>0)
		{
			health-=dam;
			Rpg1_18.slowPrintln("You deal "+dam+" damage to goblin "+goblinNum+", he has "+health+" health remaining!");
			if(health<=0)
			{
				dead=true;
				Rpg1_18.slowPrintln("Goblin "+goblinNum+" has died!");
				numberOfGoblins--;
					if(numberOfGoblins<=0)
						startingNum=0;
			}
			
			
		}
		else
			Rpg1_18.slowPrintln("I'm gonna be honest with you champ, you can't kill a corpse, so I would just stop");
	}
	public String toString()
	{
		if(dead)
			return"Goblin "+goblinNum+" is dead.";
		return "Goblin "+goblinNum+" has "+health+" health remaining";
		
	}
	public void attack(PlayerStats player) throws InterruptedException
	{
		if(stunned)
		{
			Rpg1_18.slowPrintln("The goblin prepares for an attack, but a sudden burst of electricty arks across his body, staggering him!");
			stunned=false;
			return;
		}
//		Rpg1_18.slowPrint("Goblin "+goblinNum+" swings,");
		if(player.rollToHit(accuracy))
		{
			currentDamage=0;
			Rpg1_18.slowPrintln("Goblin "+goblinNum+" swings, but you dodged the attack!");
			return;
		}
		
		currentDamage=Rpg1_18.randomGen(minDamage,maxDamage)-player.characterWeapon.protection; 
		if (currentDamage<=0)
		{
			Rpg1_18.slowPrintln("Goblin "+goblinNum+" swing, but you blocked the attack!");
			return;
		}
		player.takeDamage(currentDamage);
		Rpg1_18.slowPrintln("Goblin "+goblinNum+"swings and hits you for "+currentDamage+" damage!");
	}
	
}