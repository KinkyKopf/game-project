package gameprototypes;


public class Goblin extends Creature
{
	
	/*
	 * to DO: 
	 * ____________________
	 * 
	 * 
	 * 
	 * Done:
	 * ___________________
	 * fix the roll To hit in the goblins
	 *add evasion stat
	 * find out what current damage is and add it
	 * add the bonusMessage methods, attack methods, take damage methods,give damage methods.
	 * rewrite the class so it will be a proper subclass
	 */
	
	//Old Code__________________________
	
	/*	int baseHealth,armor,health,minDamage,maxDamage,accuracy,goblinNum,currentDamage,evasion;
	//	static int numberOfGoblins;
	//	static int startingNum=0;
	//	private double hlthMultiplier;
	//	private double dmgMultiplier;
	//	boolean dead;
	//	boolean stunned;
	//	static boolean allDead;
	//
	//	public Goblin(int f) throws InterruptedException
	//	{
	//		super(10,f,"Goblin ");
	//		
	//		int minD,maxD,h;
	//		double dm,hm;
	//		
	//		hm=.25+.25*getFloor();
	//		dm=.7*.1*getFloor();
	//		
	//		health = 10+(int)(f*hlthMultiplier);
	//		baseHealth=health;
	//		
	//		minD = (int)(1+(dmgMultiplier*f));
	//		maxD = (int)(1+minDamage*2+f*dmgMultiplier);
	//		
	//		setDamage(minD,maxD,dm);
	//		startingNum++;
	//		numberOfGoblins++;
	//		goblinNum=numberOfGoblins;
	//		
	//		setCreatureName(getName()+startingNum);
	//		
	//		setAccuracy(Rpg1_18.randomGen(-3, 3));
	//			
	//		Rpg1_18.slowPrintln("Goblin "+goblinNum+" has "+health+" health");
	//
	//	}
	//	public void takeDamage(int dam) throws InterruptedException
	//	{
	//		if(health>0)
	//		{
	//			health-=dam;
	//			Rpg1_18.slowPrintln("You deal "+dam+" damage to goblin "+goblinNum+", he has "+health+" health remaining!");
	//			if(health<=0)
	//			{
	//				dead=true;
	//				Rpg1_18.slowPrintln("Goblin "+goblinNum+" has died!");
	//				numberOfGoblins--;
	//					if(numberOfGoblins<=0)
	//					{
	//						startingNum=0;
	//						allDead=true;
	//					}
	//			}		
	//		}
	//		else
	//			Rpg1_18.slowPrintln("I'm gonna be honest with you champ, you can't kill a corpse, so I would just stop");
	//	}
	//	public String toString()
	//	{
	//		if(dead)
	//			return"Goblin "+goblinNum+" is dead.";
	//		return "Goblin "+goblinNum+" has "+health+" health remaining";
	//		
	//	}
	//	public static void reset()
	//	{
	//		numberOfGoblins=0;
	//	}
	//	public void attack(PlayerStats player) throws InterruptedException
	//	{
	//		if(stunned)
	//		{
	//			Rpg1_18.slowPrintln("The goblin prepares for an attack, but a sudden burst of electricty arks across his body, staggering him!");
	//			stunned=false;
	//			return;
	//		}
	////		Rpg1_18.slowPrint("Goblin "+goblinNum+" swings,");
	//		if(player.rollToHit(accuracy))
	//		{
	//			currentDamage=0;
	//			Rpg1_18.slowPrintln("Goblin "+goblinNum+" swings, but you dodged the attack!");
	//			return;
	//		}
	//		
	//		currentDamage=Rpg1_18.randomGen(minDamage,maxDamage)-player.characterWeapon.protection; 
	//		if (currentDamage<=0)
	//		{
	//			Rpg1_18.slowPrintln("Goblin "+goblinNum+" swing, but you blocked the attack!");
	//			return;
	//		}
	//		player.takeDamage(currentDamage);
	//		Rpg1_18.slowPrintln("Goblin "+goblinNum+"swings and hits you for "+currentDamage+" damage!");
	*/	
	
	//New Code:_______________________________________
	private int goblinNum;//also the name of the goblin
	private static int numberOfGoblins;
	private static int startingNum;
	
	public Goblin(int f) throws InterruptedException
	{
		super(f);
		numberOfGoblins++;
		goblinNum=numberOfGoblins;
		setCreatureName("Goblin "+goblinNum);
		setDamage(1,3,Rpg1_18.randomGen((int)(-2*(.35+.15*f)),(int)(3*(.35+.15*f))),.35+.15*f);
		setHealth(10,Rpg1_18.randomGen(-3, 5),.75);
		startingNum++;
	}
	
	
	public void bonusDamMessage(int bonus) throws InterruptedException
	{
		String s="";
		if(bonus<(int)(-1*getDModifier()))
			s=getName()+" looks particularily skinny.\n";
		else if(bonus>(int)(2*getDModifier()))
			s=getName()+" seems particularly bulky.\n";
		if(!quickBuild)
		Rpg1_18.slowPrint(s);
	}
	public void bonusHealthMessage(int bonus) throws InterruptedException
	{
		String s="";
		if(bonus<(int)(-2*getHModifier()))
			s=getName()+" looks especially vertically challenged.\n";
		else if(bonus>(int)(3*getHModifier()))
			s=getName()+" looks rather large compared to other goblins.\n";
		if(!quickBuild)
			Rpg1_18.slowPrint(s);
	}
	public void bonusAccuracyMessage(int bonus) throws InterruptedException
	{
		String s="";
		if(bonus<=-2)
			s=getName()+" squints at you.\n";
		else if(bonus>=2)
			s=getName()+" is wearing glasses.\n";
		if(!quickBuild)
			Rpg1_18.slowPrint(s);
	}
	
	public static void reset(PlayerStats player) throws InterruptedException
	{
		int totalGold=0;
		int temp;
		System.out.println(startingNum);
		for(int i=0;i<startingNum;i++)
		{
		temp=giveLoot();
		System.out.println(temp);
		player.bag.addGold(temp);
		totalGold+=temp;
		}
		temp=Rpg1_18.randomGen(1, 3);
		Rpg1_18.slowPrintln("You got "+totalGold+" gold from the goblins and found "+temp+" upgrade tokens in the goblins' "+Rpg1_18.partGen()+" nice!");
		startingNum=0;
	}
	
	private static int giveLoot()
	{
		int min=(int)(75*(getFloor()*(1+.15)));
		int max=(int)(200*(getFloor()*(1+.15)));
		return Rpg1_18.randomGen(min,max);
	}
	
	public static int getStartingNum()
	{
		return startingNum;
	}
	public static int getGoblinNum()
	{
		return numberOfGoblins;
	}
	
	public void takeDamage(int dam) throws InterruptedException
	{
		super.takeDamage(dam);
		if(!alive)
		{
			numberOfGoblins--;
			if(numberOfGoblins==0)
			{
				Rpg1_18.slowPrintln("You have killed all the goblins!");
				
			}
		}
	}
	
	
}