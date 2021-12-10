package gameprototypes;

public class PlayerStats 
{
	private int evasion,health,maxHealth,protection,gold,weaponNum;
	boolean alive;
	String weapon;
	
	/*
	 *Item index:
	 *0-gauntlets(fists/no weapon)
	 *1-sword
	 *2-shield
	 *3-bow
	 */
	public PlayerStats(int e,int h,int mh, int d, int p)//constructor
	{
		setEvasion(e);
		setHealth(h);
		setMaxHealth(mh);
		
		setProtection(p);
	}
	
	//getters______________________________
	
	
	public int getHealth() throws InterruptedException
	{
		if(health<0)
			Rpg1_17.slowPrintln("You Died!");
		return health;
	}
	public int getMaxHealth()//
	{
		return maxHealth;
	}
	public int getEvasion()
	{
		return evasion;
	}
	
	//Mutators_______________________________________
	public void setHealth(int h)
	{
		health=h;
	}
	public void setEvasion(int e)
	{
		evasion=e;
	}
	public void setProtection(int p)
	{
		protection=p;
	}
	public void setMaxHealth(int mh)
	{
		maxHealth=mh;
	}
	

	public boolean takeDamage(int damage)
	{
		health-=damage;
		alive=(health>0);
		return alive;
	}
	public void addProtection(int plus)
	{
		protection+=plus;
	}
	public void addEvasion(int plus)
	{
		evasion+=plus;
	}
	public void refillHealth()
	{
		health=maxHealth;
	}
	//Miscelanious methods
	public boolean rollEvasion(int enemyAccuracy)//roll to see if you can dodge
	{
		int playerRoll=Rpg1_17.randomGen(1,20)+evasion;
		int enemyRoll=Rpg1_17.randomGen(1,20)+enemyAccuracy;
		return (playerRoll>enemyRoll);
	}
	
}
