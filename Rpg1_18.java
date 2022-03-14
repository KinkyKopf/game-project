package gameprototypes;

import java.util.Scanner;
/*
 * Zachary Kinkopf
 * December 1st
 * Expand the game into mutiple classes
 */
public class Rpg1_18 
{
	
	static int printSpeed=15;//20 feels a bit slow but anything less skips around too much
	static boolean aiAutoRun;
	static int hallChoice;
	static String weaponChoice;
	static boolean egg1=false;
	static int egg2Tries=0;
	
	public Rpg1_18(int hall,String weapon)
	{
		aiAutoRun=true;
		hallChoice =hall;
		weaponChoice=weapon;
	}
	
	
	public static int stringToInt(String intInString)
	{
		
		for(int i=0;i<200000;i++ )
		{
			if((""+i).equals(intInString))
			{
				return i;//this returns the value of I which it found to be equal to the number in the string
			}
		}
		return -1;//if the method can't find a corresponding number, it returns -1, which means that there is no positive number that corresponds with the string.	
	}
	
	public static int lootMaker(int floor)
	{
		int loot = ((int)(Math.random()*395)+123)+((int)(Math.random()*200)*floor);	
		return loot;
	}
	public static String partGen()//this is purely for fun
	{
		int partNumber=randomGen(1,15);
		String part;
		
		switch(partNumber)
		{
		case 1:
			part="brain";
			break;
		case 2:
			part="liver";
			break;
		case 3:
			part="appendix";
			break;
		case 4:
			part="gabella";
			break;
		case 5:
			part="rasceta";
			break;
		case 6:
			part="philtrum";
			break;
		case 7:
			part="gallbladder";
			break;
		case 8:
			part="coccyx";
			break;
		case 9:
			part="adenoid";
			break;
		case 10:
			part="femur";
			break;
		
		case 12:
			part="cellular membrane";
			break;
		case 13:
			part="epidermis";
			break;
		case 14:
			part="phostrum";
			break;
		case 15:
			part="Alpha dominant thyroidal coagulator";
			break;
		default:
			part="will to live";
		}
		return part;
	}
	public static int randomGen(int min, int max)//this is meant to make it easier to get random numbers faster without thinking too much about it.
	{
		return (int)(Math.random()*(max-min+1))+min;
	}
	public static String toLower(Scanner s)
	{
		return s.nextLine().toLowerCase();
	}
	public static int takeInt(Scanner input)
	{
		int temp=input.nextInt();
		input.nextLine();
		
		return temp;
	}
	
	private static int answerChecker(Goblin[] gob,Scanner inputTaker,PlayerStats player) throws InterruptedException
	{
		int choice;
		String str;
		do
		{
			slowPrintln("Which goblin would you like to attack?");
			str=inputTaker.nextLine();
			if(str.equals("goblins")||str.equals("goblin"))
				for(int i=0;i<Goblin.getStartingNum();i++)
					slowPrintln(gob[i]+"");
			else if(str.equals("help"))
				slowPrintln("You can type goblins to see the stats of all the goblins or enter the number of the goblin you want to attack");
			else
			{
				choice = stringToInt(str);
				if(choice>Goblin.getStartingNum())
				{
					slowPrintln("You can't attack a goblin that isn't there, try again.");
				}
				else if(choice<1)
				{
					slowPrintln("How do you think that would even work? You make no sense");
				}
				else if(!gob[choice-1].alive)
				choice =psychoChecker(gob,choice,inputTaker,player);
				else if(choice>=1 && choice<=Goblin.getStartingNum())
				{
//					System.out.println(choice);
					return choice;
				}
			}
		}
		while((1==1));
	}
	private static int psychoChecker(Goblin[] gob,int choice, Scanner inputTaker,PlayerStats player) throws InterruptedException
	{
		/*
		 * Notes:
		 * There are so many options in this thing, WAAAAAY more than I initially thought
		 * I defenitely want to do this before show Mr. Rakow, but ,man this might take a bit
		 * I am also going to have to assume the player might enter in some invalid number,
		 * , which means I am going to have to put in my other answer checker method...Ughhhhhhhhhhhhhhhhh
		 * wait maybe not, most of my things are yes or no questions
		 * SO MANY BUGS
		 */
		boolean validAutoChoose=false;
		String s;
		
		slowPrintln("Hey, you sure you wanna attack this goblin?");
		s=inputTaker.nextLine();
		
		switch(s)
		{
		case "yes","y","holla","yas","yerr","ya":
			
			slowPrintln("You know he is already dead right?");
			s=inputTaker.nextLine();
		
			if(s.equals("y")||s.equals("yes")||s.equals("yeah"))
			{
				slowPrint("...",330);
				slowPrint("Are you like");
				slowPrint("...",330);
				slowPrint("Ok?...Mentally speaking?");
				s=inputTaker.nextLine();
				
				if(s.equals("y")||s.equals("yes"))
				{
					slowPrintln("Great!");
					slowPrint("So you must have just entered a dead goblin, and then confirmed your choice twice on accident!");
					if(!aiAutoRun)
						Thread.sleep(750);
					slowPrint("...",333);
					slowPrintln("Right?");
					s=inputTaker.nextLine();
					
					if(s.equals("y")||s.equals("yes"))
					{
						
						
						slowPrint("Awesome! I am so glad you came to your senses!  Very well! who would you like to attack?");
						choice=inputTaker.nextInt();
						s=inputTaker.nextLine();
						if(gob[choice-1].alive);
							player.takeDamage(1000);
							return choice;
							
					}
					else
					{
						slowPrintln("Oh good heavens...");
						slowPrint("I-");
						slowPrint("...",250);
						slowPrintln("Give me a couple seconds here-");
						slowPrintln("...Ok fine whatever, attack your dead goblin");
						return choice;
					}
				}
				else 
				{
					slowPrintln("Yeah I kinda guessed as much..");
					slowPrintln("It would be foolish to challenge your judgment so sure, you go get 'em champ!");
					return choice;					
				}
			}
			else 
			{
				do
					if(!gob[choice-1].alive)
						choice=randomGen(1,Goblin.getStartingNum());
					else
						validAutoChoose=true;
				while(validAutoChoose==false);
				slowPrintln("Yeah he's totally dead man, I'll go ahead and assume you meant goblin "+choice);
				return choice;
			}
		case "n","no","you know what? i am going to do the proper and good thing and not merscilessly beat the corpse of my former enemy","eh":
			
			choice=randomGen(1,Goblin.getStartingNum());
		
			do
				if(!gob[choice-1].alive)
					choice=randomGen(1,Goblin.getStartingNum());
				else
					validAutoChoose=true;
			while(validAutoChoose==false);
			
			slowPrint("OK awesome! I'll assume you meant goblin "+choice+" Right?");
			slowPrint("...",400);
			slowPrintln("Right, awesome! So glad That's what you meant!!");
			return choice;
		default:
			return choice;
		}
	}
	private static void maxEasterEgg(Scanner input,Inventory stuff) throws InterruptedException
	{
		 if(egg1==false)//easter egg
		{
			slowPrintln("HEY!  You know thats not how that works!  But hey here is 500 gold for trying!");
			stuff.addGold(500);
			egg1=true;//discovered first egg
		}
		else if(egg2Tries==5)
		{
			egg2Tries++;
			slowPrintln("Hey seriously, its not gonna work\n");												
				Thread.sleep(1000);
		}
		else if(egg2Tries ==9)
		{
			System.out.print("Okay haha last chance i'm warning you!\n");
			egg2Tries++;
		}
		else if(egg2Tries==10)
		{
			slowPrintln("OKAY THAT'S IT! YOU'RE ON TIME OUT, GO THINK ABOUT WHAT YOU HAVE DONE AND COUNT TO SIXTY!");
			
			for (int i=1; i<=60;i++)
			{
				int numCount;
				boolean correct;
				do
				{
				System.out.print("Start counting!\t");
				numCount=input.nextInt();
				if(numCount==i)
					correct=true;
				else 
					correct=false;
				}
				while(correct==false);
			}
			
			egg2Tries++;
		}
		else if(egg2Tries==11)
		{
			while(egg2Tries==11)
			{
				slowPrintln("PANIC ");
			}
		}
		else 
		{
			slowPrintln("Hey, you just tried that, you know how much time it took coding this and you try to cheat AGAIN??!\n\n...\n\n");
			egg2Tries++;
			Thread.sleep(500);
			slowPrintln("For shame");
			Thread.sleep(500);
		}
	}
	
	public static void slowPrint(String text,int printingSpeed) throws InterruptedException//This slow prints, but you can set the print speed, good for counting.
	{
		//this is for multi-testing where I want it to go as fast as possible
		for (int i=0;i<text.length();i++)
		{
			System.out.print(text.charAt(i));
			if(!aiAutoRun)
				Thread.sleep(printingSpeed);
		}
	}
	public static void slowPrintln(String text,int printingSpeed) throws InterruptedException//This slow prints, but you can set the print speed, good for counting.
	{
		//this is for multi-testing where I want it to go as fast as possible
		for (int i=0;i<text.length();i++)
		{
			System.out.print(text.charAt(i));
			if(!aiAutoRun)
				Thread.sleep(printingSpeed);
		}
		System.out.println();
	}
	public static void slowPrintln(String text) throws InterruptedException//This is the same as the others but goes down one line after.
	{
		
		
		for (int i=0;i<text.length();i++)
		{
			System.out.print(text.charAt(i));
			if(!aiAutoRun)
				Thread.sleep(printSpeed);
		}
		System.out.println();
	}
	public static void slowPrint(String text) throws InterruptedException//this slowly prints text at a set speed in miliseconds
	{
		
		
		for (int i=0;i<text.length();i++)
		{
			System.out.print(text.charAt(i));
			if(!aiAutoRun)
				Thread.sleep(printSpeed);
		}
	}
	
	
	public static void grueFight(Scanner input, PlayerStats player,Inventory stuff,Weapon playerWeapon)
	{
		/*
		 * Notes:
		 * make it so the grue has a chance of stunning you, making it so you can't attack for a turn
		 */
	}
	public static void trollFight(Scanner input, PlayerStats player,Inventory stuff,Weapon playerWeapon) throws InterruptedException
	{
		/*
		 * Notes:
		 * add blocking-2-done
		 * the troll needs to attack you-1-done
		 * make sure troll gives you money-3-done
		 * make it run on user input-2-done
		 * fix health not transferring.-2-done-I forgot to re-initalise(is that the right word?)the variables once they got sent back.
		 * make sure if you die, the program ends.-2-done
		 * add the giving upgrade tokens.-2-done
		 * add some mechanic where you have the option to spare the ogre and if you do, the orge just eats you instantly
		 *the troll attacks after you kill it 
		 *make the taking damage thing work so that you can block or dodge when you are at low health
		 *
		 *to Do:
		 *____________________
		 *
		 * Adapt the revised methods to deal damage directly from them instead of in here
		 * have troll deal damage
		 */
		boolean validCommand=true;
		boolean win=false;
		
		String prompt;
		TrollStats troll= new TrollStats(player.getFloor());
		
		do
		{
			do
			{
				validCommand=true;
				slowPrintln("What would you like to do?");
				prompt = toLower(input);
				switch(prompt)
				{
				case "fire ball","fireball":
					player.castFireball(input,troll);
					break;
				case "attack","swing":
					player.attack(troll);
					break;
				case "run","run away","boat","book it","skeddadle":
					if(randomGen(1,5)==5)
					{
						slowPrintln("You successfully ran away from the troll!");
						return;
					}
					else
					slowPrintln("You failed to find a good escape route");
					break;
				case "help":
					slowPrintln("The valid commands are: attack, fireball, and run");
					validCommand = false;
					break; 
				default:
					slowPrintln("That isn't a valid command, try again!");
					validCommand = false;
				}
			}
			while(validCommand==false);
			if(troll.alive==false)
			{
				slowPrintln("Congrats, You killed "+troll.getName()+"!\nI bet his children will be equally as happy with your success!");
				if(!aiAutoRun)
					Thread.sleep(500);
				slowPrintln("Nah just kidding, he dosen't have children!");
				troll.giveLoot(player);
				return;
			}
			troll.attack(player);
			if(!player.isAlive())
				return;
			player.printHealth();
			troll.printHealth();
		}
		while(win==false);
		
		
		//		int round=1;
//		int playerDam;
//		int loot;
//		String plural="";
//		boolean	win=false,isHit;
//		boolean autoRun=false;
//		boolean blocked;
//		
//		slowPrint("Would you like to auto run this combat?");
//		if(!aiAutoRun)
//			prompt=input.nextLine();
//		else
//		prompt="y";
//		switch(prompt.toLowerCase())
//		{
//		case "y","yes":
//			if(!aiAutoRun)
//			{
//			slowPrint("Auto running in ...");
//			slowPrint("3...2...1...",250);
//			}
//			autoRun=true;
//		}
//		
//	
//		
//		do 
//		{
//			
//			slowPrintln("Round "+round+"___________\n");
//			
//			if( (!autoRun||player.getHealth()<player.getMaxHealth()/4) && !aiAutoRun)
//			{
//				
//				slowPrintln("");
//				prompt=input.nextLine();
//				
//			44w	switch(prompt)
//				{
//				case "run","run away":
//					slowPrintln("You decide it is best to run away and as you do, "+troll.getName()+" makes a dumb face and sneers as you run away");
//					return;
//					
//				}
//			}
//			
//			playerDam=playerWeapon.rollDamage(1);
//						
//			
//				 if(troll.getHealth()-playerDam<=0)//killing the troll
//				{
//					
//					slowPrintln("Congrats, You killed "+troll.getName()+"!\nI bet his children will be equally as happy with your success!");
//					if(!aiAutoRun)
//						Thread.sleep(500);
//					slowPrint("Nah just kidding, he dosen't have children!");
//					
//					loot =lootMaker(player.getFloor());
//					stuff.addGold(loot);
//					
//					slowPrintln("You got "+loot+" gold from killing,the troll!\nIt's a bit red but I bet you don't care about that do you?\n\nGold: "+stuff.getGold()+" \n");
//					
//					loot=randomGen(1,3);
//					stuff.addUpgrades(loot);
//					
//					if(loot>1)
//						plural="s";
//					
//					slowPrintln("You also found "+loot+" upgrade token"+plural+" inside the troll's "+partGen()+"........Nice!");
//					break;
//				}
//				 else 
//				 {
//					 troll.takeDamage(playerDam);
//						slowPrintln("You deal "+playerDam+" damage to the troll!\n\nThe troll has "+troll.getHealth()+" health remaning.");	
//				 }
//				 
//				troll.rollDamage(1, player);
//			round++;
//		}
//		while(win==false);
//		
			 
	
		
	}
	public static void goblinHorde(Scanner input, PlayerStats player,Inventory stuff,Weapon playerWeapon) throws InterruptedException
	{
		/*
		 * Notes:
		 * add giving upgrade tokens-2-done
		 * Add blocking-done
		 * Add a command that allows you to see the health of all the goblins and which ones are dead-3
		 * add something that auto attacks goblins-4
		 * integrate the string to number into my code-1-the converter works now all I need to do is get the if statements right.
		 *
		 *	Bugs:
		 * 	
		 * To Do:
		 * I am revising my roll damage methods to deal damage directly, so I need to integrate those into the goblins method
		 * 
		 * fixes:
		 *  dead goblins are attacking; it will say that the goblin is dead, roll the goblin again then just attack-done, just some bad boolean logic, I belive
		 *	i fixed half of the array exception issue, originally, whenever it would reroll when a goblin is dead, I set the generator to make the wrong values, so stupid problem, easy fix, but it is still happening sometimes
		 *  it makes a number bigger than the array when choosing an attacker sometimes, so far it has happened twice
		 *  it isn't a problem with the random generator, since I made 100 generater numbers and an erroir wasn't in them, meaning in must be in my adding and subtracting--The starting num must stay even though the array got garbage collected meaning that if statring num was five on the las one it will be e5 on this one, i belive. 
		 *  to fix it, I made it so once all the goblins died, starting num was set to 0.
		 *  IT DIDN'T WORK-it actually did, I just didn't5 set it up to be run mutiple times in a row.
		 */
	
		
		int selection=1;
		int goblinAttacker;
		String prompt = "";
		int goblinGen =randomGen(1,4);
		boolean valid=false;
	//	goblinGen=4;
		Goblin[] goblins=new Goblin[goblinGen];
	
//		slowPrintln("You see the flickering light of a fire around the hall, but right as you are about to turn the corner,\n You see the the dancing shadows of goblins.  Prepare for a fight.\n___________________________\n");
		slowPrintln("There are "+goblinGen+" goblins to attack");

		for(int i=0;i<goblinGen;i++)//generates the goblins
			goblins[i]=new Goblin(player.getFloor());
		
		do
		{
			do
			{
			slowPrintln("What would you like to do?");
			prompt=toLower(input);
			valid=false;
				switch(prompt)
				{
				case "attack", "swing":
					selection=answerChecker(goblins,input,player);
					player.attack(goblins[selection-1]);
					valid=true;
					Rpg1_18.slowPrintln(goblins[selection-1]+"");
					break;
				case "cast fireball","cast fire ball","fireball","fire ball":
			//			slowPrintln("Wfoor");
					selection=answerChecker(goblins,input,player);
//					System.out.println("point 1");
					player.castFireball(input, goblins[selection-1]);
					valid=true;
					Rpg1_18.slowPrintln(goblins[selection-1]+"");
					break;
				case "cast lightning","lightning":
					player.castChainLightning(input, goblins);
					valid=true;
					break;
				case "help":
					slowPrintln("You can swing, cast fireball or cast lightning\n\nNote: selection what goblin to attack is a different selection so just enter attack, or fireball.");
					break;
				case "goblins":
					for(Goblin g: goblins)
						slowPrintln(g+"");
					break;
				default:
					slowPrintln("That isn't a command I recognize, try again");
				}	
			}
			while(!valid);
		
		
		if(Goblin.getGoblinNum()==0)
		{
			Goblin.reset(player);
			return;
		}
		
		goblinAttacker= randomGen(0,Goblin.getStartingNum()-1);//this decides what goblin will attack
		
		if(goblinAttacker>=Goblin.getStartingNum()||!goblins[goblinAttacker].alive)
			goblinAttacker= randomGen(0,Goblin.getStartingNum()-1);
		goblins[goblinAttacker].attack(player);
		
		}
		while(player.isAlive());
		
//		if(aiAutoRun)//this is to generate random numbers to see if they are within a range
//		{
//			for(int i=0;i<100;i++)
//			{
//				slowPrintln(randomGen(0,Goblin.startingNum-1)+" ");
//			}
//			prompt=input.nextLine();
//		}
		
//		do
//		{
//			//Real code:
//			if(!aiAutoRun)
//				selection=answerChecker(goblins,input);
//			else
//				selection=aiCounter;
//			//slowPrint("Answer recived: "+selection);
//			
//			if(goblins[selection-1].dead==true)
//				selection=psychoChecker(goblins,selection,input,player);
//			
//			if(goblins[selection-1].dead==false)
//			{
//			goblins[selection-1].takeDamage(playerWeapon.rollDamage(1));
//			slowPrintln("You deal "+playerWeapon.currentDamage+" damage to goblin "+selection+".  The goblin now has "+goblins[selection-1].health+ " health remaining!");
//			
//			//Ai runner code:
//			if(goblins[selection-1].dead==true)
//				aiCounter++;
//			}
//			else 
//			{
//				slowPrint("You look at all the very much alive goblins standing around you and decide that,\n in the middle of a fight, you will attack the ONE THING that poses zero danger to you and beat the corpse of goblin "+selection);
//			}
//					if(Goblin.numberOfGoblins==0)
//					{
//						slowPrintln("You killed all the goblins, congrats!  I'm not going to guilt trip you on this one, the goblins are just idiots.");
//						loot=lootMaker(player.getFloor()*Goblin.startingNum);
//						stuff.addGold(loot);
//						loot=randomGen(1,3);
//						stuff.addGold(loot);;
//						slowPrintln("You also found "+loot+" ugrade tokens in one of the goblin's "+partGen()+" so win/win!");
//						Goblin.startingNum=0;
//						return;
//					}
//	
			
//			
//			//slowPrint("Goblin number "+goblinAttacker);
//			System.out.println("Starting num: "+Goblin.startingNum+"Length: "+goblins.length);
//			while((goblins[goblinAttacker].dead))//if the chosen goblin is dead, this keep picking until an alive goblin is chosen.
//			{
//						slowPrintln("Old Attacker: "+goblinAttacker);
//						goblinAttacker= randomGen(1,Goblin.startingNum-1);//rerolls the selection
//						slowPrintln("New Attacker: "+goblinAttacker);		
//			}
//			
//			
//			slowPrint("Goblin number "+(goblinAttacker+1)+" swings!");
//			goblins[goblinAttacker].rollDamage(player);
//			
//			if(goblins[goblinAttacker].currentDamage>0)
//			{
//			player.takeDamage(goblins[goblinAttacker].currentDamage);
//			slowPrintln("He hits you for "+goblins[goblinAttacker].currentDamage+" damage!\n"
//					+ "You have "+player.getHealth()+" health remaining");
//			}
//			
//			if(player.getHealth()<=0)
//			{
//				
//				System.out.print("The goblins killed you! They celebrate by taking out your "+partGen()+" and doing a dance around it\n that looks like a monkey told another monkey how to do the hokey pokey. ");
//				alive=false;
//				Goblin.startingNum=0;
//				Goblin.numberOfGoblins=0;
//				break;
//			}
//			System.out.println("\n_____________________________________");
//		}
//		while(win==false&&alive==true);
	}
	
	public static Weapon firstStore(Scanner input,Inventory stuff) throws InterruptedException
	{
		Weapon killTool=null;
		int swordCost,shieldCost,bowCost,loot;
		String prompt;
		boolean skipDungeon=false;//first cheat code
		boolean balance=false;//this is for skipping floors
		
		swordCost = 500;
		shieldCost = 700;
		bowCost = 150;
		
		//slowPrintln("Welcome to Dork adventurer, your journey awaits!  \n\nInside the shop you see a chest, the shopkeeper say you can buy what ever is in the chest, but you doubt he has any idea what it is inside. \n\nWould you like to open the chest? y/n");
			// long and cheesy, I know but it is about the atmosphere, right?
			//this was back when I made the weapon you get random, for some reason
			
		slowPrintln("Gold:"+stuff.getGold()+"\n\nWelcome to Dork adventurer!");
		slowPrintln("\nNote: Make sure your inputs are spelled correctly, All prompts will be one word");
		
				do
				{
			slowPrintln("\nYou are in the store, Before you is a sword, shield and bow. To leave, type dungeon.");
			//Real Code:
			if(!aiAutoRun)
			prompt = input.nextLine();
			else
			prompt=weaponChoice;
				switch(prompt.toLowerCase())
						{
						case "sword":
							slowPrintln("Gold:"+stuff.getGold()+"\n\n Would you like to purchase the sword for 500 gold?(y/n)");
							//Real Code:
							if(!aiAutoRun)
								prompt = input.nextLine();
							else
								prompt="y";	
								if (prompt.equals("y"))
									{
								
											if(swordCost>stuff.getGold())
											{
												slowPrintln("Sorry, you don't have enough to buy the sword at the moment");
												break;
											}
												else 
											{
												stuff.addGold(-swordCost);
												slowPrintln("You have "+stuff.getGold()+" gold remaining");
												slowPrintln("Now off to the dungeon you go!");
												killTool=new Weapon("sword",stuff);
												prompt = "dungeon";
												break;
											}
									
									}//prompt y if block
									else
									{
										break;//break if n
									}
								case "shield":
									slowPrintln("Gold:"+stuff.getGold()+" \n\n Would you like you buy the shield for 700 gold?(y/n)");
									//Real Code:	
									if(!aiAutoRun)
										prompt = input.nextLine();
									else
										prompt="y";	
									
										if (prompt.toLowerCase().equals("y"))
										{
										
										
											if(shieldCost>stuff.getGold())
											{
												slowPrintln("Sorry, you don't have enough to buy the shield at the moment");
												break;
											}
												else 
											{
												stuff.addGold(-shieldCost);
												slowPrintln("You now have "+stuff.getGold()+" gold remaining");
												slowPrintln("Now off to the dungeon you go!");
												killTool=new Weapon("shield",stuff);
												prompt = "dungeon";
												break;
											}
										}
										else
										{
											break;//break if n
										}
								
						case "bow":
							slowPrintln("Gold:"+stuff.getGold()+" \n\n Would you like you buy the bow for 150 gold?(y/n)");
							
							if(!aiAutoRun)
								prompt = input.nextLine();
							else
								prompt="y";	
								if (prompt.toLowerCase().equals("y"))
								{
								
									if(bowCost>stuff.getGold())
									 {
										slowPrintln("Sorry, you don't have enough to buy the bow at the moment");
										break;
									 }
									else 		
									{
									stuff.addGold(-bowCost);
									slowPrintln("You now have "+stuff.getGold()+" gold remaining");
									slowPrintln("Now off to the dungeon you go!");
									killTool=new Weapon("bow",stuff);
									prompt = "dungeon";
									break;
									}//end else
								}//end if yes
							else
							{
								break;
							}
									
//						case "skip.sword":
//							skipDungeon=true;
//							player.weapon="sword";
//						break;
//						
//						case "skip.shield":
//							skipDungeon=true;
//							player.weapon=2;
//							break;
//							
//						case "skip.bow":
//							skipDungeon=true;
//							player.weapon=3;
//							break;
//						case "floor6":
//							weaponNum=0;
//							floor=6;
//							balance=true;
//							break;
						case "leave","dungeon":
							prompt="dungeon";
							killTool=new Weapon("gauntlets",stuff);
							break;
						case "gimme.stuff":
							loot=lootMaker(1);
							stuff.addGold(loot);
							System.out.print(loot);
							break;
						case "part.test":
							slowPrint(partGen());
						case "println_speed":
							slowPrintln("print_speed");
							break;
						case "print_speed":
							slowPrint("print_speed");
							break;
						
						default:
							slowPrintln("I'm sorry, I dont understand things that aren't commands, please try again");
							
						}//switch brckt
					
				   }//while brckt
				while(!(prompt.equals("dungeon"))&&skipDungeon==false&&balance==false);
				
				
			if (stuff.getGold()<0)
			{
				slowPrintln("\n Man, you have " + stuff.getGold()+" gold! Your bankrupt!!!you are going to have to work that off in the dungeon)");
				
			}
		return killTool;
	
	}
	public static void floorStore(Scanner input, PlayerStats player,Inventory stuff,Weapon playerWeapon) throws InterruptedException
	{
		/*
		 * Notes:
		 * Get both the inventory and player classes to work in this-1
		 * get rid of the transfer array that I was so proud of-2
		 * get rid of the old if/else mess and do a switch instead, but it might be better to do that in the next edition
		 * make it print the updated stats
		 * 
		 * TO do:
		 * _________________________________
		 * set up the auto run
		 */
		int number;
		int maxCst;
		String prompt;
		
		maxCst=100+(player.getFloor()*50);
		if(maxCst>500)
			maxCst=500;//this should cap the maximum cost at 500
		
		slowPrintln("You see torchlight in the distance, as you approach, a broken sign reading \"shop\" hangs from one end\n\nYou can upgrade your weapon or buy some potions, the choice is yours.\n");
		slowPrintln(player+"");
		if(aiAutoRun)
		{
			if( (stuff.getGold()>=200 && stuff.getUpgrades()>0) && player.getHealth()==player.getMaxHealth() )
				prompt="upgrade";
			else if(stuff.getGold()>=maxCst)
				prompt="potions";	
			else
				prompt="leave";
		}
		else
			prompt = input.nextLine();
		
		switch(prompt.toLowerCase())
		{
		case "upgrade","upgrade weapon":
			
			slowPrintln("Would you like to upgrade your weapon for "+playerWeapon.upgradeCost+" gold?");
			
			if(aiAutoRun)
				prompt="yes";
			else
			prompt=input.nextLine();
				
				switch(prompt.toLowerCase())
				{
				case "yes","y":
					playerWeapon.upgrade(player.getFloor());
				default:
					slowPrintln("You head back to the main room");
				}
		case "potions","potion","max","refill":
			slowPrintln("There are two potions on the wall, max potions, and refill potions, both have a drawing of a heart on them");
				
			if(aiAutoRun)
			{
				if(stuff.getGold()>=maxCst)
					prompt="max";
				else
					prompt="refill";
			}
		
				switch(prompt.toLowerCase())
				{
				case "max","buy max potions","max potions":
					slowPrintln("How many would you like to buy?");
					
				if(aiAutoRun)
					number=stuff.getGold()/maxCst;
				else
				{
					number=input.nextInt();
					prompt=input.nextLine();
				}
					if(number<0)
						maxEasterEgg(input,stuff);
					else
						player.buyMaxPotion(number, stuff);

				}
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException 
	  {
			
			/*
			 * _________________
			 * Notes:
			 * 
			 * Done:
			 * __________________
			 * Eventually I should be able to completely get rid of the combat in my main method, which is my primary goal right now 11/5-only took me 14 days
			 * I also don't need to return an array since non-primitive datatypes are constant throughout the class-eh too much work imma return them anyway
			 * be able to buy upgrade tokens-3-maybe not, still not sure if I should.
			 * add a thing where you can edit the print speed in game-1-dosen't really work
			 * make it so that you can choose from three diffrent halls, with a diffrent event behind each, randomly assigned of course-2-done?
			 * -make it that hall 1 might be goblins, 2 a troll and 3 be a treasure-3-done?
			 * transfer stores into seperate methods-done-that was a lot easier than I expected.
			 *make it so that 1.17 has things in different classes-1
			 *Get the class-things to work in each method-1
			 *get rid of the transfer arrays-2
			 *put in the evasion stat-3
			 *finish the auto run setting
			 *make a prompt that tells you that you are going to see goblins
			 *the bow isn't working, when you buy it, for some reason it dosen't work
			 *I think everything is about good for this edition, I just need to play it a lot to make sure it is fully debuged.
			 *add spells-10
			 *goblins are a bit to hard if you get bad rng, either add player input (maybe spells) or add a mechanic like counterattacking for dodging
			 *To Do:
			 *____________________
			 * 
			 * fix floor shop
			 * 
			 *	
			 *Next Update:
			 *___________________________________________
			 *
			 * add a dagger to maximize evasion. -5
			 * make it so you can chooses your stats, fallout-style at the beginning of the game.-6
			 * integrate the cheat codes into working again.-7
			 * 
			 *allow player to get different weapons later on.-10
			 *
			 */
		
	 	Scanner input = new Scanner(System.in);
		
		Inventory bag = new	Inventory(1000,2);
		Weapon killonater;
		int roll;
		double number;
		int loot;
		String prompt;
		boolean balance=false;//this is for skipping floors
		
			killonater=firstStore(input,bag);
			
//			slowPrint(killonater.weaponType);
			
			PlayerStats character = new PlayerStats(killonater,bag);
			character.nextFloor();
			
			
			
			if(balance==true)
			{
				slowPrintln("\n\nYou skipped to floor "+character.getFloor()+", now I will beef up your stats!");
				killonater.damageBonus=15;
				character.setHealth(90);
				character.setMaxHealth(90);
			}
//			goblinHorde(input,character,bag,killonater);
			//trollFight(input,character,bag,killonater);
			do 
			{
				do//this is to make sure you don't enter a negative number
				{
					slowPrintln("Before you are three halls, which hallway would you like to go down?");
					if(!aiAutoRun)
					{
						number=input.nextInt();
						prompt=input.nextLine();
					}
					else
						number=hallChoice;
					
					if(number>3)
					{
						slowPrintln("As you try to run through a hallway that isn't there, you run into a wall and take 1 damage");
						character.addHealth(-1);
					}
					if(number==0)
					{
						slowPrintln("...",250);
						slowPrintln("What?",100);
						Thread.sleep(500);
					}
					if(number<0)
					{
						slowPrintln("You struggle to even rationalise what you mean by a negative hallway"
								+ "\nbut eventually you decide it makes sense, and try to slam your head through the ground like an ostrich\n");
							Thread.sleep(1000);	 
							slowPrint("You take 2 damage\n",100);
							Thread.sleep(1000);
						character.addHealth(-2);
					}
					if(character.getHealth()<=0)
					{
						break;
					}
				}
				while(number>3||number<=0);
				
				slowPrintln("You have "+character.getHealth()+" health");
				
				if(character.isAlive()==false)
				{
					slowPrintln("looks like you somehow died, those walls must have been pretty fun huh? ");
					break;
				}
						
						
//						slowPrint("Which fight would you like to do?\n Enter 1 for a  troll fight or 2 to fight a group of goblins: ");//this is to test the code, I have no intention of leaving this in the 1.2 version.
//						number=input.nextInt();
//						prompt=input.nextLine();
						roll=randomGen(1,6);
						switch((int)number)
						{
						case 1://each hall will have different odds, this is even odds
							switch(roll)
							{
							case 1,2:
								
								goblinHorde(input,character,bag,killonater);
								break;
							case 3,4:
								trollFight(input,character,bag,killonater);
								break;	
							case 5:
								slowPrint("You find nothing in this hallway and continue to the shop, tough luck");
								break;
							case 6:
								loot=randomGen((int)(300*character.getFloor()*1.5),(int)(1000*character.getFloor()*1.5));
								bag.addGold(loot);
								slowPrintln("You find a treasure chest containing "+loot+" gold! You now have "+ bag.getGold()+" gold!");
							}
							break;
						case 2://more likely to have a troll
							switch(roll)
							{
							case 1,2,3:
								trollFight(input,character,bag,killonater);
								break;
							case 4,6:
								goblinHorde(input,character,bag,killonater);
								break;
							case 5:
								if(!killonater.enchanted)
								{
								slowPrintln("Your "+killonater.weaponType+" feels imbued with energy, you can feel the power flowing through it ");
								killonater.enchanted=true;
								}
								else
								{
									slowPrint("Suddenly, the energy from your "+killonater.weaponType+" seems to dissipate into the air\nYou feel you coin purse get heavier by a miniscule ammount, you recived compensation");
									slowPrint("...",300);
									slowPrintln("one coin.");
									killonater.enchanted=false;
									bag.addGold(1);
								}
								break;
							}
							break;
						case 3://more likely to have goblins 
							switch(roll)
							{
							case 1,2,3,6:
								goblinHorde(input,character,bag,killonater);
								break;
							case 4:
								trollFight(input,character,bag,killonater);
								break;
							case 5:
								slowPrintln("You find an old amulet, after you put it on, you feel more protected");
								killonater.protection++;
								break;
							}
							break;
						}
					
						
						
						if(character.isAlive()==false)//detects if you died in one of the other types of combats.
						{							
							slowPrintln("You Died");
							break;
						}		
				       floorStore(input, character,bag,killonater);
				   
				       slowPrint("Type quit to leave the game or press enter to continue on to the next floor:");
				       
				       if(!aiAutoRun)
				    	   prompt = input.nextLine();
				       else
				    	   prompt="";
				       
				       character.nextFloor();
				       
				       if(character.getFloor()==76)
				       {
				    	   prompt="quit";
				       }
			}
		   while(!prompt.equals("quit"));
			
			//this is for rapid testing
			CounterFile.addFloors(character.getFloor());
			if(character.getFloor()==76)
				CounterFile.numWon++;
			else if(character.getFloor()<2)
				CounterFile.f1Death++;
			else if(character.getFloor()<6)
				CounterFile.f5Death++;
			else if(character.getFloor()<11)
				CounterFile.f10Death++;
			else if(character.getFloor()<21)
				CounterFile.f20Death++;
			else if(character.getFloor()<51)
				CounterFile.f50Death++;

				slowPrintln("Welp thats the whole game, I hope you had fun!!");
			
		input.close();	

}
}