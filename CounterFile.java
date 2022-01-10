package gameprototypes;

public class CounterFile 
{
	static int floorNum,times,lowFloor,highFloor;
	
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
	
}
