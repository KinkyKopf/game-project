package gameprototypes;
/*
 * Zachary Kinkopf
 * December 1st
 * test the concepts of storing data outside of my main game class
 */
public class StatsRunner {

//	public static void test(PlayerStats Character)
//	{
//		System.out.print(Character.gold);
//	}
//	
	public static void main(String[] args) 
	{
//		PlayerStats Stats = new PlayerStats();
//		
		
		Inventory bag = new Inventory();
		
		Inventory.Sword bigKnife=bag.new Sword();
		bag.inventorySlots[0]=bigKnife;
		System.out.println(bag.inventorySlots[0]);
		Object weapon=bag.inventorySlots[0];
		
		
		
	}
	public void printer(Inventory bag)
	{
		
	}
}
