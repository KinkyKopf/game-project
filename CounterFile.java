package gameprototypes;

public class CounterFile 
{
	static int floorNum,times,f1Death,f5Death,f10Death,f20Death,f50Death,numWon;
	
	public static int averageFloors()
	{
		System.out.println("Floor: "+floorNum);
		return (floorNum/times);
	}
	public static void addFloors(int floors)
	{
		floorNum+=floors;
		times++;
	}
	public String toString()
	{
		return"Average floor: "+averageFloors()+", Times run: "+times+"\nDeaths on floor 1: "+f1Death+", deaths before floor 6: "+f5Death
				+", Deaths before floor 11: "+f10Death+",Deaths before floor 20: "+f20Death+",Deaths before floor 50: "+f50Death+", Times Won: "+numWon;
	}
}
