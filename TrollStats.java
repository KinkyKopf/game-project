package gameprototypes;

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
		nameGen();
		Rpg1_17.slowPrintln("As you go down the hallway, a rank scent of what you can only decsribe as teenage man-musk floods your nostrills ");
		Rpg1_17.slowPrint("...\n",500);
		Rpg1_17.slowPrintln("A troll is near.\nYou see a door labeled: "+name+". \nBrave yourself, "+name+" the troll is behind here.");
		
		setFloor(f);
		setDamage(Rpg1_17.randomGen(-3,4));
		setHealth(20+(floor*5));	
		setAccuracy(Rpg1_17.randomGen(-3, 6));
	}

	
//Setters______________
	public void setDamage(int d) throws InterruptedException
	{
		//d=0;
		damage=d;
		if (d>2)
			Rpg1_17.slowPrintln("You see a truly staggering ammount of what you can only assume is empty tubs of preworkout scattered around "+name+"'s lair\n");
		if(d<1)
			Rpg1_17.slowPrintln("You notice a stack of books labled \"Computer Science: The Anylitical Studies Of Computational Electronics\" in the corner of "+name+"'s lair\n");
	}
	public void setHealth(int h) throws InterruptedException
	{
		int bonusHealth=Rpg1_17.randomGen(-7,10);
		health = h+bonusHealth;
		if(bonusHealth>6)
			Rpg1_17.slowPrintln(name+" appears to be abnormally large. But not like in a bad way or anything,he's still in shape for a troll");
		if(bonusHealth<=3)
		{
			Rpg1_17.slowPrintln(name+" is way smaller than your average troll but it is best not to metion it, he is probably insecure\n");
		}
	}
	public void setAccuracy(int a) throws InterruptedException
	{
		accuracy=a;
		if(a>4)
			Rpg1_17.slowPrintln("It appears that "+name+" is wearing glasses\n");
		else if (a<=0)
			{
			Rpg1_17.slowPrintln(name+" squints at you.\n");
			}
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
		switch(Rpg1_17.randomGen(1,11))
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
	public int rollDamage(int times,int playerProtection) throws InterruptedException
	{
		if(times<=0)
		return 0;
		damageOut = (Rpg1_17.randomGen(1, 7)+damage-playerProtection)+rollDamage(times-1,playerProtection);
		
		System.out.println("DamageValue: "+damageOut);
		
		if(damageOut<=0)
			Rpg1_17.slowPrintln("You blocked the attack!");
		
		return damageOut;
		
	}
	public String toString()
	{
		return name+" currently has "+health+" health.";
	}
}