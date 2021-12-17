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
	
	public TrollStats(int f) throws InterruptedException
	{
		Rpg1_17.slowPrintln("As you go down the hallway, a rank scent of what you can only decsribe as teenage man-musk floods your nostrills, a troll is near.");
		
		nameGen();
		setFloor(f);
		setDamage(Rpg1_17.randomGen(-2,6));
		setHealth(20+(floor*5));	
		setAccuracy(Rpg1_17.randomGen(-2, 6));
	}

	
//Setters______________
	public void setDamage(int d) throws InterruptedException
	{
		//d=0;
		damage=d;
		if (d>4)
			Rpg1_17.slowPrintln("You see a truly staggering ammount of what you can only assume is empty tubs of preworkout scattered around"+name+"'s lair");
		if(d<2)
			Rpg1_17.slowPrintln("You notice a stack of books labled \"Computer Science: The Anylitical Studies Of Computational Electronics\"\nin the corner of "+name+"'s lair");
	}
	public void setHealth(int h) throws InterruptedException
	{
		int bonusHealth=+Rpg1_17.randomGen(-5,10);
		health = h+bonusHealth;
		if(bonusHealth>6)
			Rpg1_17.slowPrintln(name+" appears to be abnormally big.\nBut not like in a bad way or anything, everyone has their own body size");
		if(bonusHealth<=3)
		{
			Rpg1_17.slowPrintln(name+" is way smaller than your average troll but it is best not to metion it, he is probably insecure");
		}
	}
	public void setAccuracy(int a) throws InterruptedException
	{
		accuracy=a;
		if(a>4)
			Rpg1_17.slowPrintln("It appears that "+name+" is wearing glasses");
		else if (a<=0)
			{
			Rpg1_17.slowPrintln(name+" squints at you.");
			}
	}
	public void setName(String n)
	{
		name=(n+" the troll");
	}
	public void takeDamage(int dam) throws InterruptedException
	{
		health-=dam;
		if(health<=0)
		{
			Rpg1_17.slowPrintln("You killed "+name);
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
		String n;
		switch(Rpg1_17.randomGen(1,10))
		{
		case 1:
			n="Jeff";
			break;
		case 2:
			n="Phill";
			break;
		case 3:
			n = "Gary";
			break;
		case 4:
			n="Hok'no'Ragut'Hum";
			break;
		case 5:
			n ="Fus Ro Dah";
			break;
		case 6:
			n ="Al Dente'";
			break;
		case 7:
			n="Gene Poole";
			break;
		case 8:
			n="Moe B. Dick";
			break;
		case 9:
			n="Neil McNeil";
			break;
		case 10:
			n="Sam Sung";
			break;
		case 11:
			n="Linguini";
			break;
		default:
			n="Jorge Lopez";
		}
		setName(n);
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