package gameprototypes;
/*
 * Zachary Kinkopf
 * December 1st
 * Hold items for the player in the rpg
 */
public class Inventory 
{
	
	/*
	 * Notes:
	 * I am going to need to make each possible object have a specific value and then have something that  can make use of said values
	 */
	private int gold,potions,upgradeTokens;
	String weapon;
	
	public Inventory(int g,int u, String w)
	{
		setGold(g);
		setUpgrades(u);
		setWeapon(w);
	}
	public Inventory()
	{
		this(1000,2,"Gauntlets");
	}
	
	//getters
	public int getGold()
	{
		return gold;
	}
	public int getUpgrades()
	{
		return upgradeTokens;
	}
	public String getWeapon()
	{
		return weapon;
	}
	//Setters____________________
	public void setWeapon(String s)
	{
		weapon=s;
	}
	public void setGold(int g)
	{
		gold=g;
	}
	public void addGold(int adder)
	{
		gold+=adder;
	}
	public void setUpgrades(int u)
	{
		upgradeTokens=u;
	}
	public void addUpgrades(int adder)
	{
		upgradeTokens+=adder;
	}
	//Miscelanious________________________
	
		/*
		 * add protecion
		 * 
		 */
		public class Sword//WIP(duh)
		{
			private int minDamage,maxDamage,damageBonus,protection;
			private boolean enchanted;
			public Sword()//constructor
			{
				setMin(1);
				setMax(4);
				setProtection(2);
			}
			
			public void addDamage(int dam)//bonus damage will be for upgrading the weapon
			{
				damageBonus+=dam;
			}
			public void setMin(int min)
			{
				minDamage=min;
			}
			public void setMax(int max)
			{
				maxDamage=max;
			}
			public void setProtection(int p)
			{
				protection= p;
			}
			
			public int randomGen(int min, int max)
			{
				return (int)(Math.random()*(max-min+1))+min;
			}
			public int rollDamage()
			{
				
				int damage= randomGen(minDamage,maxDamage)+damageBonus;
				if(enchanted)
					return 2*damage;
				return damage;
			}
			
		}
}
