package gameprototypes;

abstract class Creature 
{
	private int health;
	private static int floor;
	private int accuracy;
	private int minDamage,maxDamage,currentDamage,bonusDam;
	private int armor;//not yet implemented
	private double damageModifier;
	private double healthModifier;
	private String creatureName;

	public boolean stunned;
	public boolean alive;
	public boolean quickBuild;

	/*
	 * To do:
	 * Fit this to be a proper abstract class
	 * find a good way to make the constructor
	 */
	
	public Creature(int f) throws InterruptedException
	{
		floor=f;
		alive=true;
	}
	abstract void bonusDamMessage(int bonus) throws InterruptedException;
	abstract void bonusHealthMessage(int bonus) throws InterruptedException;
	abstract void bonusAccuracyMessage(int bonus) throws InterruptedException;
	
	public void setDamage(int minD,int maxD,int bd,double dm) throws InterruptedException
	{
		minDamage=(int)(minD*dm+.5);
		maxDamage=(int)(maxD*dm+.5);
		damageModifier=dm;
		bonusDam=bd;
		bonusDamMessage(bonusDam);
	}
	public void setHealth(int baseHealth,int bonusHealth,double hm) throws InterruptedException
	{
		health = baseHealth+(int)(floor*hm+bonusHealth);	
		healthModifier=hm;
		bonusHealthMessage(bonusHealth);
	}
	public void setAccuracy(int a) throws InterruptedException
	{
		accuracy=a;
	}
	public void setCreatureName(String n)
	{
		creatureName=n;
	}
	public void setFloor(int f)
	{
		floor=f;
	}
//Getters_________________
	public static int getFloor()
	{
		return floor;
	}
	public int getDamage()
	{
		return currentDamage;
	}
	public int getHealth()
	{
		return health;
	}
	public int getAccuracy()
	{
		return accuracy;
	}
	public String getName()
	{
		return creatureName;
	}
	public double getDModifier()
	{
		return damageModifier;
	}
	public double getHModifier()
	{
		return healthModifier;
	}
	//misc methods
	
	public void attack(PlayerStats player) throws InterruptedException
	{
		if(stunned)
		{
			Rpg1_18.slowPrintln("The "+creatureName+" prepares for an attack, but a sudden burst of electricty arks across his body, staggering him!");
			stunned=false;
			return;
		}
//		Rpg1_18.slowPrint("Goblin "+goblinNum+" swings,");
		if(player.rollToHit(accuracy))
		{
			currentDamage=0;
			Rpg1_18.slowPrintln(creatureName+" swings, but you dodged the attack!");
			return;
		}
		
		currentDamage=Rpg1_18.randomGen(minDamage,maxDamage)-player.characterWeapon.protection; 
		if (currentDamage<=0)
		{
			Rpg1_18.slowPrintln(creatureName+" swings, but you blocked the attack!");
			return;
		}
		player.takeDamage(currentDamage);
		Rpg1_18.slowPrintln(creatureName+" swings and hits you for "+currentDamage+" damage!");
	}
	public void takeDamage(int dam) throws InterruptedException
	{
		if(health>0)
		{
			health-=dam;
			if(health<=0)
			{
				alive=false;
				Rpg1_18.slowPrintln(creatureName+" has died!");
			}
		}
		else
			Rpg1_18.slowPrintln("I'm gonna be honest with you champ, you can't kill a corpse, so I would just stop");
	}
	public String toString()
	{
		if(!alive)
			return creatureName+" is dead.";
		return creatureName+" has "+ health+" health remaining";
		
	}
}
