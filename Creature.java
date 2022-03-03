package gameprototypes;

public class Creature 
{
	private int health;
	private int floor;
	private int accuracy;
	private int minDamage,maxDamage,currentDamage,bonusDam;
	private int armor;//not yet implemented
	private String creatureName;
	
	private double healthMultiplier;
	private double damageMultiplier;
	
	private boolean stunned;
	public boolean alive;
	public boolean quickBuild;
	
	public Creature(int h,int f,String n) throws InterruptedException
	{
		creatureName=n;
		floor=f;
		alive=true;
	}
	
	public void setDamage(int minD,int maxD,double dm) throws InterruptedException
	{
		minDamage=minD;
		maxDamage=maxD;
		damageMultiplier=dm;
	}
	public void setHealth(int baseHealth,int bonusHealth,double healthMultiplier) throws InterruptedException
	{
		health = baseHealth+(int)(floor*healthMultiplier+bonusHealth);	
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
	public int getFloor()
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
		return creatureName+" has "+health+" health remaining";
		
	}
}
