package gameprototypes;

public class Goblin 
{
	 int health,damage;
	static int numberOfGoblins;
	boolean dead;
	public Goblin(int f)
	{
		health = 10+(f*3);
		damage = f*2;
		numberOfGoblins++;
	}
	public void takeDamage(int dam)
	{
		
	}
}
