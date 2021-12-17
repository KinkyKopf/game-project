package game;
/*
 * Zachary Kinkopf
 * December 1st
 * test the concepts of storing data outside of my main game class
 */
public class StatsRunner 
{
	public static int randomGen(int min, int max)//this is meant to make it easier to get random numbers faster without thinking too much about it.
	{
		return (int)(Math.random()*(max-min+1))+min;
	}
	
	
	public static void main(String[] args) 
	{
			for(int i=0;i<30;i++)
			System.out.print(randomGen(-5,6)+" ");
	}

}
