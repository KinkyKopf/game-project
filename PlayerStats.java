package gameprototypes;

public class PlayerStats 
{
	private int floor, evasion,health,maxHealth;
	private boolean alive;
	Weapon characterWeapon;
	
	/*
	 *Item index:
	 *0-gauntlets(fists/no weapon)
	 *1-sword
	 *2-shield
	 *3-bow
	 */
	public PlayerStats(int e,int h,int mh,Weapon w)//constructor
	{
		characterWeapon=w;
		setEvasion(e+characterWeapon.evasionBuff);
		setHealth(h);
		setMaxHealth(mh);
	}
	public PlayerStats(Weapon w)
	{
		this(1,20,20,w);
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
	public void die()
	{
		alive=false;
	}
	public void setHealth(int h)
	{
		health=h;
	}
	public void setEvasion(int e)
	{
		evasion=e;
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
	
	public void takeDamage(int damage)
	{
		health-=damage;
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
	public String toString()
	{
		return "Current Health: "+health+"\t Max Health: "+maxHealth+"\nEvasion: "+evasion;
	}
}