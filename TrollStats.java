package gameprototypes;


public class TrollStats 
{
	private int health,damage,accuracy,floor,damageOut;
	private double hlthMultiplier,dmgMultiplier;

	private String name;
	/*   Notes:
	 *make the troll get bonus evasion if he has glasses on
	 *more damage if there are tubs of pre-workout 
	 *bonus health be some quip about him being "big but not like in a bad way"
	 */
	
	public TrollStats(int f) throws InterruptedException
	{
		
		if(f<6)
		{
			hlthMultiplier=5;
			dmgMultiplier=.9;
		}
		else if(f<10)
		{
			hlthMultiplier=8;
			dmgMultiplier=1.5;
		}
		else if(f<20)
		{
			hlthMultiplier=15;
			dmgMultiplier=3;
		}
		nameGen();
		Rpg1_18.slowPrintln("As you go down the hallway, a rank scent of what you can only decsribe as teenage man-musk floods your nostrills ");
		Rpg1_18.slowPrint("...\n",500);
		Rpg1_18.slowPrintln("A troll is near.\nYou see a door labeled: "+name+". \nBrave yourself, "+name+" the troll is behind here.");
		
		setFloor(f);
		setDamage(Rpg1_18.randomGen(-2,3));
		setHealth(20+(int)(floor*hlthMultiplier));	
		setAccuracy(Rpg1_18.randomGen(-3, 3));
	}

	
//Setters______________
	public void setDamage(int d) throws InterruptedException
	{
		//d=0;
		damage=d;
		if (d>2)
			Rpg1_18.slowPrintln("You see a truly staggering ammount of what you can only assume is empty tubs of preworkout scattered around "+name+"'s lair\n");
		if(d<1)
			Rpg1_18.slowPrintln("You notice a stack of books labled \"Computer Science: The Anylitical Studies Of Computational Electronics\" in the corner of "+name+"'s lair\n");
	}
	public void setHealth(int h) throws InterruptedException
	{
		int bonusHealth=Rpg1_18.randomGen(-7,10);
		health = h+bonusHealth;
		if(bonusHealth>5)
			Rpg1_18.slowPrintln(name+" appears to be abnormally large. But not like in a bad way or anything,he's still in shape for a troll");
		if(bonusHealth<0)
		{
			Rpg1_18.slowPrintln(name+" is way smaller than your average troll but it is best not to metion it, he is probably insecure\n");
		}
	}
	public void setAccuracy(int a) throws InterruptedException
	{
		accuracy=a;
		if(a>0)
			Rpg1_18.slowPrintln("It appears that "+name+" is wearing glasses\n");
		else if (a<=0)
			{
			Rpg1_18.slowPrintln(name+" squints at you.\n");
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
			Rpg1_18.slowPrintln("You killed "+name);
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
		switch(Rpg1_18.randomGen(1,11))
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
		for(int i=0;i<times;i++)
		{
		damageOut += (Rpg1_18.randomGen((int)(2*dmgMultiplier), (int)(5*dmgMultiplier))+damage-playerProtection);
		}
		
		//System.out.println("DamageValue: "+damageOut);
		
		if(damageOut<=0)
			Rpg1_18.slowPrintln("You blocked the attack!");
		
		return damageOut;
		
	}
	public String toString()
	{
		return name+" currently has "+health+" health.";
	}
}