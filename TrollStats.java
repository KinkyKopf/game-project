package game;

public class TrollStats 
{
	private int health,damage,accuracy,floor,damageOut;
	private String name;
	/*   Notes:
	 *make the troll get bonus evasion if he has glasses on
	 *more damage if there are tubs of pre-workout 
	 *bonus health be some quip about him being "big but not like in a bad way"
	 */
	
	public TrollStats(int f)
	{
		setFloor(f);
		setDamage((int)(floor*1.5));
		setHealth(20+(floor*5));	
		nameGen();
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
		floor=f;
	}
//Getters_________________
	public int getDamage()
	{
		return damageOut;
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
			name="Jeff";
			break;
		case 2:
			name="Phill";
			break;
		case 3:
			name = "Gary";
			break;
		case 4:
			name="Hok'no'Ragut'Hum";
			break;
		}
	}
	public int rollDamage(int times)
	{
		if(times<=0)
		return 0;
		int dam = Rpg1_17.randomGen(1, 5)+damage+rollDamage(times-1);
		return dam;
		
	}
	public String toString()
	{
		return name+" currently has "+health+" health.";
	}
}
