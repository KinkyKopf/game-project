package gameprototypes;

public class PlayerStats 
{
	
	/*
	 * Notes:
	 * ________________
	 * 
	 * 
	 * To do:
	 * ________________________
	 * make a balanced way to block, so that the player isn't constantly blocking everything,
	 */
	private int floor, evasion,health,maxHealth,armorClass;
	private boolean alive,nearDeath;
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
		alive = true;
		//armorClass=characterWeapon.protection;
	}
	public PlayerStats(Weapon w)
	{
		this(7,25,25,w);
	}
	//getters______________________________
	
	
	public int getHealth() throws InterruptedException
	{
		return health;
	}
	public int getMaxHealth()//
	{
		return maxHealth;
	}
	public int getEvasion()
	{
		if (nearDeath)
			return evasion+3;
		return evasion;
	}
	public boolean isAlive()
	{
		return alive;
	}
	public int getFloor()
	{
		return floor;
	}
	//Mutators_______________________________________
	public void die() throws InterruptedException
	{
		alive=false;
		Rpg1_17.slowPrintln("You died!!!");		
		Rpg1_17.slowPrintln("Floor: "+floor);
		//Thread.sleep(100);
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
	
	public void takeDamage(int damage) throws InterruptedException
	{
		health-=damage;
		if(health<=0)
			die();
	}
	
	public void addEvasion(int plus)
	{
		evasion+=plus;
	}
	public void refillHealth()
	{
		health=maxHealth;
	}
	public void nextFloor() throws InterruptedException
	{
		floor++;
		//add some cool message here, or maybe a funny one
		Rpg1_17.slowPrintln("You leave the relative comfort of the shop behind and begin decending lower into the dungeon");
	}
	//Miscelanious methods______________________________
	public boolean rollToHit(int enemyAccuracy) throws InterruptedException//roll to see if you can dodge
	{
		
		int enemyRoll=Rpg1_17.randomGen(1,20)+enemyAccuracy;
		
		System.out.println("Enemy ROll: "+ enemyRoll);

		if(evasion>enemyRoll)
		{
			Rpg1_17.slowPrintln("You dodged the attack!");
			return true;
		}
		return false;
	}
	
	public String toString()
	{
		return "Current Health: "+health+"   Max Health: "+maxHealth+"   Evasion: "+evasion;
	}
}