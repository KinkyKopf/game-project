package game;

public class PlayerStats 
{
	private int floor, evasion,health,maxHealth,protection,gold,weaponNum;
	private boolean alive;
	private String weapon;
	
	/*
	 *Item index:
	 *0-gauntlets(fists/no weapon)
	 *1-sword
	 *2-shield
	 *3-bow
	 */
	public PlayerStats(int e,int h,int mh, int p)//constructor
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
	public boolean aliveOrNot()
	{
		return alive;
	}
	public int getFloor()
	{
		return floor;
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
	public void addHealth(int adder)
	{
		health+=adder;
	}
	public void addMaxHealth(int adder)
	{
		maxHealth+=adder;
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
	public void nextFloor()
	{
		floor++;
		//add some cool message here, or maybe a funny one
	}
	//Miscelanious methods______________________________
	public boolean rollEvasion(int enemyAccuracy)//roll to see if you can dodge
	{
		int playerRoll=Rpg1_17.randomGen(1,20)+evasion;
		int enemyRoll=Rpg1_17.randomGen(1,20)+enemyAccuracy;
		return (playerRoll>enemyRoll);
	}
	
}
