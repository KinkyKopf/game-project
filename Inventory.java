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
	public void setUpgrades(int u)
	{
		upgradeTokens=u;
	}
	//Miscelanious________________________
	public int randomGen(int min, int max)
	{
		return (int)(Math.random()*(max-min+1))+min;
	}
	
	
		public class Sword
		{
			int damage;
			
		}
}
