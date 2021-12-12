package game;

public class TrollStats 
{
	private int health,damage,accuracy,floor;
	private String name;
	/*   Notes:
	 *make the troll get bonus evasion if he has glasses on
	 *more damage if there are tubs of pre-workout 
	 *bonus health be some quip about him being "big but not like in a bad way"
	 */
	
	public TrollStats(int f)
	{
		setDamage((int)(floor*1.5));
	}

	
//Setters______________
	public void setDamage(int d)
	{
		damage=d;
	}
	public void setHealth(int h)
	{
		health = h;
	}
	public void setAccuracy(int a)
	{
		accuracy=a;
	}
	public void setName(String n)
	{
		name=n;
	}
	public void takeDamage(int dam) throws InterruptedException
	{
		health-=dam;
		if(health<=0)
		{
			Rpg1_17.slowPrintln("You killed the troll!");
		}
	}
	public void setFloor(int f)
	{
		
	}
//Getters_________________
	public int getDamage()
	{
		return damage;
	}
	public int getHealth()
	{
		return health;
	}
	public int getAccuracy()
	{
		return accuracy;
	}
	public String getName()
	{
		return name;
	}
//misc methods_________________________	
	
	public void nameGen()
	{
		
		switch(Rpg1_17.randomGen(1,4))
		{
		case 1:
			name="jeff";
		case 2:
			name="phill";
		}
	}

	
}
