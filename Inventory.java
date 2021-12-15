package game;
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
	
	
	public Inventory(int g,int u)
	{
		setGold(g);
		setUpgrades(u);
	}
	public Inventory()
	{
		this(1000,2);
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
	
	//Setters____________________
	
	
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
		return "Gold: "+gold+"\nUpgrade Tokens: "+upgradeTokens;
	}
		
}
