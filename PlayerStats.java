package gameprototypes;

import java.util.Scanner;

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
	 * make a minigame that allows you to increase your intelligence by solving math promlems.
	 * make a check magic method to make sure you can't cast spells at 0 magic
	 * Allow the player to choose how much magic they want to cast the spell for
	 * get rid of of the spell base and put all the spells in this class
	 */
	private int floor, evasion,health,maxHealth,armorClass,magic,intelligence,maxMagic;
	private boolean alive,nearDeath;
	Weapon characterWeapon;
	
	/*
	 *Item index:
	 *0-gauntlets(fists/no weapon)
	 *1-sword
	 *2-shield
	 *3-bow
	 */
	public PlayerStats(int e,int h,int mh,Weapon w,int mm)//constructor
	{
		characterWeapon=w;
		setEvasion(e+characterWeapon.evasionBuff);
		setHealth(h);
		setMaxHealth(mh);
		setMaxMagic(mm);
		alive = true;
		//armorClass=characterWeapon.protection;
	}
	public PlayerStats(Weapon w)
	{
		this(7,25,25,w,100);
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
	public int getMaxMagic()
	{
		return maxMagic;
	}
	public int getMagic()
	{
		return magic;
	}
	//Mutators_______________________________________
	public void die() throws InterruptedException
	{
		alive=false;
		Rpg1_18.slowPrintln("You died!!!");		
		Rpg1_18.slowPrintln("Floor: "+floor);
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
	public void setMaxMagic(int m)
	{
		magic=m;
		maxMagic=m;
	}
	
	public void addMaxMagic(int m)
	{
		maxMagic+=m;
	}
	public void addHealth(int adder)
	{
		health+=adder;
	}
	public void addMaxHealth(int adder)
	{
		maxHealth+=adder;
	}	
	public void addEvasion(int plus)
	{
		evasion+=plus;
	}
	
	
	public void refillMagic()
	{
		magic=maxMagic;
	}
	public void refillHealth()
	{
		health=maxHealth;
	}
	
	public void useMagic(int m) throws InterruptedException
	{
		if(magic-m<0)
			Rpg1_18.slowPrintln("you can't cast that spell, you don't have enought magic!");
		else
			magic-=m;
	}
	
	public void takeDamage(int damage) throws InterruptedException
	{
		health-=damage;
		if(health<=0)
			die();
	}
	public void nextFloor() throws InterruptedException
	{
		floor++;
		//add some cool message here, or maybe a funny one
		Rpg1_18.slowPrintln("You leave the relative comfort of the shop behind and begin decending lower into the dungeon");
		magic=maxMagic;
	}
	
	
	//Miscelanious methods______________________________
	public boolean rollToHit(int enemyAccuracy) throws InterruptedException//roll to see if you can dodge
	{
		
		int enemyRoll=Rpg1_18.randomGen(1,20)+enemyAccuracy;
		
		System.out.println("Enemy ROll: "+ enemyRoll);

		if(evasion>enemyRoll)
		{
			Rpg1_18.slowPrintln("You dodged the attack!");
			return true;
		}
		return false;
	}
	public void buyMaxPotion(int num,Inventory stuff) throws InterruptedException
	{
		int maxCst;
		maxCst=100+(floor*50);
		if(maxCst>500)
			maxCst=500;
		if(stuff.getGold()<maxCst*num)
		{
			Rpg1_18.slowPrintln("You don't have enough gold to buy "+num+" potions");
			if(Rpg1_18.randomGen(1, 20)==20)
				Rpg1_18.slowPrintln("A good video to help with adding is: `https://www.youtube.com/watch?v=dQw4w9WgXcQ");
		}
		else
		{
			stuff.addGold(-maxCst*num);
			addMaxHealth(num*10);
			refillHealth();
			Rpg1_18.slowPrintln("You bought "+num+" potions and now have "+stuff.getGold()+" gold remaining");
		}
		
		
	}
	
	public int castFireball(Scanner input) throws InterruptedException
	{
		int damage;
		int magicCost=20;
		
		Rpg1_18.slowPrint("How much magic do you want to use to cast this?");
		magicCost=input.nextInt();
		input.nextLine();
		if(!checkMagic(magicCost))
			return 0;
		useMagic(magicCost);
		
		damage=(int)(magicCost*.5+Rpg1_18.randomGen( (int)(magicCost*.25+intelligence),(magicCost*intelligence) ));
		
		Rpg1_18.slowPrintln("You cast fireball for "+magicCost+", you have "+ magic+" magic left.");
		return damage;
	}
	

	public boolean checkMagic(int c) throws InterruptedException
	{
		if(c>magic)
		{
			Rpg1_18.slowPrintln("You don't have enough magic to cast that spell");
			return false;
		}
		return true;
	}
	
	
	public String toString()
	{
		return "Current Health: "+health+"   Max Health: "+maxHealth+"   Evasion: "+evasion;
	}
}