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
	 * I am going to need to make each possible object have a specific value and then have something that can make use of said values
	 */
	private int gold,potions,upgradeTokens;
	private String weaponName;
	 Object[] inventorySlots=new Object[1];
	
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
	
	//getters_____________
	
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
		return weaponName;
	}
	//Setters____________________
	public void setArray(Object weapon)
	{
		inventorySlots[0]=weapon;
	}
	public void setWeapon(String s)
	{
		weaponName=s;
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
	public String toString()
	{
		return "Gold: "+gold+"\nUpgrade Tokens: "+upgradeTokens+"\nWeapon: "+weaponName;
	}
		
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
			public Sword(int min,int max,int p,boolean suped)
			{
				setMin(min);
				setMax(max);
				setProtection(p);
				enchanted =suped;
			}
			
			//setters_____________________________
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
			
			//Getters__________________________
			public int getDamage()
			{
				return damageBonus;
			}
			public int getMin()
			{
				return minDamage;
			}
			public int getMax()
			{
				return maxDamage;
			}
			public int getProtection()
			{
				return protection;
			}
			public boolean enchanted()
			{
				return enchanted;
			}
			
			//Misc methods___________________________________
			
			
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
			public String toString()
			{
				return "Damage: "+damageBonus+"\nProtection: "+"\nEnchanted: "+enchanted;
			}
			
		}
		public class Shield//WIP(duh)
		{
			private int minDamage,maxDamage,damageBonus,protection;
			private boolean enchanted;
			public Shield()//constructor
			{
				setMin(1);
				setMax(4);
				setProtection(2);
				inventorySlots[0]=2;
			}
			public Shield(int min,int max,int p,boolean suped)
			{
				setMin(min);
				setMax(max);
				setProtection(p);
				enchanted =suped;
			}
			
			//setters_____________________________
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
			
			//Getters__________________________
			public int getDamage()
			{
				return damageBonus;
			}
			public int getMin()
			{
				return minDamage;
			}
			public int getMax()
			{
				return maxDamage;
			}
			public int getProtection()
			{
				return protection;
			}
			public boolean enchanted()
			{
				return enchanted;
			}
			
			//Misc methods___________________________________
			
			
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
			public String toString()
			{
				return "Damage: "+damageBonus+"\nProtection: "+"\nEnchanted: "+enchanted;
			}
			
		}
}
