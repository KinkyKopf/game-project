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
//		Stats.gold=1000;
//		
////		System.out.println(Stats.gold);
//		test(Stats);
		Inventory bag = new Inventory();
		
		Inventory.Sword bigKnife=bag.new Sword();
		
		System.out.print(bigKnife.damage);
	}

}
