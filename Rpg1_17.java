package gameprototypes;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Zachary Kinkopf
 * December 1st
 * Expand the game into mutiple classes
 */
public class Rpg1_17 
{
	static int printSpeed=17;//20 feels a bit slow but anything less 
	
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
		case 11:
			part ="the top-right part of your left kidney";
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
			part="";
		}
		return part;
	}
	public static int randomGen(int min, int max)//this is meant to make it easier to get random numbers faster without thinking too much about it.
	{
		return (int)(Math.random()*(max-min+1))+min;
	}

	public static int answerChecker(Goblin[] gob,String str,Scanner inputTaker) throws InterruptedException
	{
		int choice=0;
		int times=0;
		while(choice<=Goblin.numberOfGoblins||choice>=1)
		{
			slowPrint("Enter goblins to see the goblin's health or enter the number of the goblin you want to attack");
			str=inputTaker.nextLine();
			if(str.equals("goblins"))
				for(int i=0;i<Goblin.numberOfGoblins;i++)
					slowPrintln(gob[i]+"");
			else
			{
				choice = stringToInt(str);
				if(choice>Goblin.numberOfGoblins)
				{
					slowPrintln("You can't attack a goblin that isn't there, try again.");
				}
				else if(choice<1)
				{
					slowPrintln("How do you think that would even work? You make no sense");
				}
				else if(gob[choice].dead==true&&times==0)
				{
					slowPrintln("Hey, look, he's dead you dont need to keep whacking the corpse");
					times++;
				}
				else if(gob[choice].dead==true&&times!=0)
				{
					slowPrintln("Ok fine, if you want to beat a ded goblin for no benefit, who am I to stop you");
				}
				else if(choice>=1 && choice<=Goblin.numberOfGoblins)
					return choice;
			}
		}
		return choice;
	}
	
	public static void slowPrint(String text,int printSpeed) throws InterruptedException//This slow prints, but you can set the print speed, good for counting.
	{
		
		for (int i=0;i<text.length();i++)
		{
			System.out.print(text.charAt(i));
			Thread.sleep(printSpeed);
		}
		System.out.println();
	}
	public static void slowPrintln(String text) throws InterruptedException//This is the same as the others but goes down one line after.
	{
		
		
		for (int i=0;i<text.length();i++)
		{
			System.out.print(text.charAt(i));
			Thread.sleep(printSpeed);
		}
		System.out.println();
	}
	public static void slowPrint(String text) throws InterruptedException//this slowly prints text at a set speed in miliseconds
	{
		
		
		for (int i=0;i<text.length();i++)
		{
			System.out.print(text.charAt(i));
			Thread.sleep(printSpeed);
		}
		System.out.println();
	}
	//k
	
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
		 */
		String prompt;
		
		TrollStats troll= new TrollStats(player.getFloor());
		
		int round=1;
		int playerDam;
		int loot;
		String plural="";
		boolean	win=false;
		boolean autoRun=false;
		
		
		slowPrint("Would you like to auto run this combat?");
		prompt=input.nextLine();
		
		switch(prompt)
		{
		case "y","yes":
			slowPrint("Auto running in ...");
			slowPrint("3...2...1...",250);
			autoRun=true;
		}
		
	
		
		do 
		{
			
			slowPrintln("Round "+round+"___________\n");
			playerDam=playerWeapon.rollDamage(1);
				if(troll.getHealth()>0)//troll is still alive , you damage the troll
				{
				
				troll.takeDamage(playerDam);
				slowPrintln("You deal "+playerDam+" damage to the troll!\n\nThe troll has "+troll.getHealth()+" health remaning.");
				
				}
				else if(troll.getHealth()-playerDam<=0)//killing the troll
				{
					slowPrintln("Congrats, You killed "+troll.getName()+"!\n I bet the troll's children will be equally as happy with your success!");
					Thread.sleep(500);
					slowPrint("Nah just kidding, he dosen't have children!");
					
					loot =lootMaker(player.getFloor());
					stuff.addGold(loot);
					
					slowPrintln("You got "+loot+" gold from killing,the troll!\nIt's a bit red but I bet you don't care about that do you?\n\nGold: "+stuff.getGold()+" \n");
					
					loot=randomGen(1,3);
					stuff.addUpgrades(loot);
					
					if(loot>1)
						plural="s";
					
					slowPrintln("You also found "+loot+" upgrade token"+plural+" inside the troll's "+partGen()+"........Nice!");
					break;
				}
				
				if(player.rollEvasion(troll.getAccuracy()))
				{
					slowPrintln("You dodged the attack!");
				}
				else if(player.getHealth()-troll.rollDamage(1)<=0)//player dies
				{
					slowPrintln("The troll hits you for "+troll.getDamage()+" damage, absoutely obliterating your "+partGen()+", killing you instantly.");//add a random part generator
					player.die();
					break;
				}
				else if(troll.getDamage()<=0)
				{
					slowPrintln("You blocked the attack!");
				}
				else 
				{
					player.addHealth(-troll.getDamage());
					slowPrintln("The troll hits you for "+troll.getDamage()+" damage!\nYou have "+player.getHealth()+" health remaning!");
				}
				if(!autoRun||player.getHealth()<player.getMaxHealth()/4)
				{
					slowPrintln("Press enter to continue or n to run away");
					prompt=input.nextLine();
					
					if(prompt.toLowerCase().equals("n"))
					{
						slowPrint("As you run away the troll laughs and taunts you with some gestures I won't repeat here since my teacher is going to see this");
						break;
					}
				}
				
			round++;
		}
		while(win==false);
		
			 
	
		
	}
	public static void goblinHorde(Scanner input, PlayerStats player,Inventory stuff,Weapon playerWeapon) throws InterruptedException
	{
		/*
		 * Notes:
		 * add giving upgrade tokens-2-done
		 * Add blocking-done
		 * Add a command that allows you to see the health of all the goblins and which ones are dead-3
		 * add something that auto attacks goblins-4
		 * integrate the string to number into my code-1-the converter works now all I need to do is get the if statments right.
		 * 
		 */
	
		
		int selection;
		int goblinAttacker;
		int loot;
		String prompt = "";
		
		boolean alive=true;
		boolean validAttacker=false;//this will be for a loop to make a random ALIVE goblin attack you.
		boolean win = false;
		int goblinGen =randomGen(1,5);
		
		Goblin[] goblins=new Goblin[goblinGen];
		
		slowPrintln("There are "+goblinGen+" goblins to attack");
		
				for(int i=0;i<goblinGen;i++)
				{
					goblins[i]=new Goblin(player.getFloor());
				}
		
		do
		{
			selection=answerChecker(goblins,prompt,input);
			goblins[selection-1].takeDamage(playerWeapon.rollDamage(1));
		
			slowPrintln("You deal "+playerWeapon.currentDamage+" damage to goblin "+selection+".  The goblin now has "+goblins[selection-1].health+ " health remaining!");
			
					
					 
					if(Goblin.numberOfGoblins==0)
					{
						slowPrintln("You killed all the goblins, congrats!  I'm not going to guilt trip you on this one, the goblins are just idiots.");
						loot=lootMaker(player.getFloor()*Goblin.numberOfGoblins);
						stuff.addGold(loot);
						loot=randomGen(1,3);
						stuff.addGold(loot);;
						slowPrintln("You also found "+loot+" ugrade tokens in one of the goblin's "+partGen()+" so win/win!");
						return;
					}
					
					
			
			
			goblinAttacker= randomGen(0,Goblin.numberOfGoblins-1);//this decides what goblin will attack
			
			do//if the chosen goblin is dead, this keep picking until an alive goblin is chosen.
			{
					if(goblins[goblinAttacker].dead)
					{
						goblinAttacker= randomGen(0,Goblin.numberOfGoblins-1);//rerolls the selection
					}
					else
						validAttacker=true;
			}
			while(validAttacker==false);
			
			slowPrint("Goblin number "+(goblinAttacker+1)+" swings");
			goblins[goblinAttacker].rollDamage(player);
			
			if(goblins[goblinAttacker].currentDamage>0)
			{
			player.takeDamage(goblins[goblinAttacker].currentDamage);
			slowPrintln("He hits you for "+goblins[goblinAttacker].currentDamage+" damage!\n"
					+ "You have "+player.getHealth()+" health remaining");
			}
			
			if(player.getHealth()<=0)
			{
				
				System.out.print("The goblins killed you! They celebrate by taking out your "+partGen()+" and doing a dance around it\n that looks like a monkey told another monkey how to do the hokey pokey. ");
				alive=false;
				player.die();
				break;
			}
			System.out.println("\n_____________________________________");
		}
		while(win==false&&alive==true);
		
		
	}
	
	public static Weapon firstStore(Scanner input,Inventory stuff) throws InterruptedException
	{
		Weapon killTool=null;
		int swordCost,shieldCost,bowCost,loot,floor;
		String prompt;
		boolean skipDungeon=false;//first cheat code
		boolean balance=false;//this is for skipping floors
		
		swordCost = 500;
		shieldCost = 700;
		bowCost = 150;
		
		floor = 1;
		//slowPrintln("Welcome to Dork adventurer, your journey awaits!  \n\nInside the shop you see a chest, the shopkeeper say you can buy what ever is in the chest, but you doubt he has any idea what it is inside. \n\nWould you like to open the chest? y/n");
			// long and cheesy, I know but it is about the atmosphere, right?
			//this was back when I made the weapon you get random, for some reason
			
		slowPrintln("Gold:"+stuff.getGold()+"\n\nWelcome to Dork adventurer!");
		slowPrintln("\nNote: Make sure your inputs are spelled correctly. All prompts will be one word");
		
				do
				{
			slowPrintln("\nYou are in the store, Before you is a sword, shield and bow. To leave, type dungeon.");
			prompt = input.nextLine();
				switch(prompt.toLowerCase())
						{
						case "sword":
							slowPrintln("Gold:"+stuff.getGold()+"\n\n Would you like to purchase the sword for 500 gold?(y/n)");
							prompt = input.nextLine();
							
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
												killTool=new Weapon("sword");
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
										prompt = input.nextLine();
										
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
												killTool=new Weapon("shield");
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
								prompt = input.nextLine();
								
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
										killTool=new Weapon("bow");
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
						case "leave":
							prompt="dungeon";
							killTool=new Weapon("gauntlets");
							break;
						case "gimme.stuff":
							loot=lootMaker(floor);
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
		 */
		double number;
		int maxCst,egg2Tries=0,refilCost=100;
		boolean egg1=false;
		
		
		String prompt;
		
		
		slowPrintln("\n________________________________________________\n\nYou now enter the floor "+player.getFloor()+" shop.");
		
		do
		{		
	
		slowPrintln("\nYou can either type potion to look at the avaible potions, type upgrade to upgrade your weapon, or type leave to go to the next floor.");
		slowPrintln("\nMax health:"+player.getMaxHealth()+"\t\tHealth:"+player.getHealth()+"\n\nGold: "+stuff.getGold()+"\t\tUpgrade Tokens: "+stuff.getUpgrades());
		prompt=input.nextLine();
		
			if(prompt.toLowerCase().equals("potions")||prompt.toLowerCase().equals("potion"))
			{
				slowPrintln("\n There is a max health potion, which increases your max health by ten but you must use the refill after, and the refill potion which refills your health back to max.");
				
				
				
								do
								{
									slowPrintln("Type max to buy max potions, refill to buy refill potions, or n to go back to the store.");
									prompt=input.nextLine();
									
									
									
									if(prompt.toLowerCase().equals("max"))
									{
										maxCst=100+(player.getFloor()*50);
										
												if(maxCst>500)
												{
													maxCst=500;//this should cap the maximum cost at 500
												}
												
										slowPrintln("\nThat will cost "+maxCst+" per bottle, how many do you want?");
										slowPrintln("\n\nNote: The maximum ammount of potions you can currently buy is: "+ ((int)(stuff.getGold()/maxCst)) );
										number=input.nextDouble();
										prompt=input.nextLine();//this is to prevent the scanner from skipping inputs later because of how the console reads inputs.
										
											if((maxCst*((int)number))>stuff.getGold())
											{
												slowPrintln("Sorry, you don't have enough gold to buy that many, please try again.");	
											}
															else if(number<0&&egg1==false)//easter egg
															{
																slowPrintln("HEY!  You know thats not how that works!  But hey here is 500 gold for trying!");
																stuff.addGold(500);
																egg1=true;//discovered first egg
															}
															else if(number<0&&egg2Tries==5)
															{
																egg2Tries++;
																slowPrintln("Hey seriously, its not gonna work\n");												
																	Thread.sleep(1000);
															}
															else if(number<0&&egg2Tries ==9)
															{
																System.out.print("Okay haha last chance i'm warning you!\n");
																egg2Tries++;
															}
															else if(number<0&&egg2Tries==10)
															{
																slowPrintln("OKAY THAT'S IT! YOU'RE ON TIME OUT, GO THINK ABOUT WHAT YOU HAVE DONE AND COUNT TO SIXTY!");
																
																for (int i =1; i<60;i++)
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
															else if(number<0&&egg2Tries==11)
															{
																while(egg2Tries==11)
																{
																	slowPrintln("NIGHTMARE");
																}
															}
															else if(number<0)
															{
																slowPrintln("Hey, you just tried that, you know how much time it took coding this and you try to cheat AGAIN??!\n\n...\n\n");
																egg2Tries++;
																try {
																	Thread.sleep(500);
																} catch (InterruptedException e) {
																	e.printStackTrace();
																}
																slowPrintln("For shame");
																	Thread.sleep(500);
															}
															
											else
											{
												stuff.addGold(-maxCst*(int)number);
												player.addMaxHealth(10*(int)number);
												slowPrintln("You paid "+((int)maxCst*number)+" gold for "+(int)number+" potions and you now have "+player.getMaxHealth()+" Max health and "+ stuff.getGold()+" gold left");
											}
									}
									else if(prompt.toLowerCase().equals("refill"))
									{
										slowPrintln("That will cost 100 gold, press enter to accept or n to decline.");
										prompt=input.nextLine();
										
												if(prompt.toLowerCase().equals("n"))
												{
													slowPrintln("Ok no problem!");
													break;
												}
												else if(stuff.getGold()<100)
												{
													slowPrintln("Sorry, you don't have enough gold to buy that, please try again.");
												}
												else
												{
													player.getHealth();
													stuff.addGold(refilCost);
													slowPrintln("Your health has been refilled to "+player.getHealth());
													break;
												}
									}
									else if (prompt.equals("n"))
									{
										slowPrintln("Okay, back to the store you go!");
									}
									else
									{
										slowPrintln("Sorry! I don't recognise that command!");
									}
									
									
								}
								while(!prompt.toLowerCase().equals("n"));
						
			}//potion bracket end
			else if (prompt.toLowerCase().equals("upgrade"))
			{
				slowPrintln("\nWould you like to upgrade your "+playerWeapon.weaponType+" for 200 gold?(y/n)");
				prompt=input.nextLine();
				
					if(prompt.toLowerCase().equals("y")&&stuff.getGold()>=200&&stuff.getUpgrades()>0)
					{
						stuff.addGold(-200);
						playerWeapon.damageBonus+= 3+(int)(player.getFloor()*.5);
						slowPrintln("\nYou Upgraded your "+playerWeapon.weaponType+" and now have "+stuff.getGold()+" gold left!");
						stuff.addUpgrades(-1);
						if(playerWeapon.weaponType.equals("shield"));
							playerWeapon.protection+=randomGen(1,3+player.getFloor());
					}
					else if((prompt.toLowerCase().equals("y"))&&stuff.getGold()<200)
					{
						slowPrintln("\nSorry! You don't have enough gold to get an upgrade!");
					}
					else if((prompt.toLowerCase().equals("y"))&&stuff.getGold()<200)
					{
						slowPrintln("You don't enough upgrade tokens to upgrade your "+playerWeapon.weaponType+", try being a better killer!");
					}
					else if((prompt.toLowerCase().equals("n")))
					{
						slowPrintln("Ok!");
					}
					else
					{
						slowPrintln("Sorry you either don't have enough money or tokens to afford that or I didn't recognise your input.");
					}
			}
		
		}
		while( !(prompt.toLowerCase().equals("leave")) );
		
	}
	
	public static void main(String[] args) throws InterruptedException 
	  {
			/*
			 * Note about notes:
			 * The number I assign to the end of the note is the priority I am assigning to them.  This is to help with orginsiation, unless it is a date, it which case it says the date.
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
			 *
			 *To Do:
			 *____________________
			 *make it so that 1.17 has things in different classes-1
			 *Get the class-things to work in each method-1
			 *get rid of the transfer arrays-2
			 *put in the evasion stat-3
			 * add a dagger to maximize evasion. -5
			 * make it so you can chooses your stats, fallout-style at the beginning of the game.-6
			 * integrate the cheat codes into working again.-7
			 * add spells-10
			 *allow player to get different weapons later on.-10
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
			
			PlayerStats character = new PlayerStats(killonater);
			character.nextFloor();
			
			
			
			if(balance==true)
			{
				slowPrintln("\n\nYou skipped to floor "+character.getFloor()+", now I will beef up your stats!");
//				error message to remind me to add damage;
				character.setHealth(90);
				character.setMaxHealth(90);
			}
			goblinHorde(input,character,bag,killonater);
			//trollFight(input,character,bag,killonater);
			do 
			{
				do//this is to make sure you don't enter a negative number
				{
					slowPrintln("Before you are three halls, which hallway would you like to go down?");
					number=input.nextInt();
					prompt=input.nextLine();
					if(number>3)
					{
						slowPrintln("As you try to run through a hallway that isn't there, you run into a wall and take 1 damage");
						character.addHealth(-1);
					}
					if(number==0)
						slowPrintln("What?");
					if(number<0)
					{
						slowPrintln("You struggle to even rationalise what you mean by a negative hallway"
								+ "\nbut eventually you decide it makes sense, and try to slam your head through the ground like an ostrich\n");
							Thread.sleep(1000);	 
							slowPrint("You take 2 damage",30);
							Thread.sleep(1000);
						character.addHealth(-2);
					}
					if(character.getHealth()<=0)
						break;
				}
				while(number>3||number<=0);
				
				slowPrintln("You have "+character.getHealth()+" health");
				
				if(character.getHealth()<=0)
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
						case 1://each hall will have different odds 
							switch(roll)
							{
							case 1,2:
								
								goblinHorde(input,character,bag,killonater);
								break;
							case 3,4:
								trollFight(input,character,bag,killonater);
							case 5:
								slowPrint("You find nothing in this hallway and continue to the shop, tough luck");
								break;
							case 6:
								loot=randomGen((int)(300*character.getFloor()*1.5),(int)(1000*character.getFloor()*1.5));
								bag.addGold(loot);
								slowPrintln("You find a treasure chest containing "+loot+" gold! You now have "+ bag.getGold()+" gold!");
							}
							break;
						case 2:
							switch(roll)
							{
							case 1,2,3,6:
								trollFight(input,character,bag,killonater);
								break;
							case 4:
								goblinHorde(input,character,bag,killonater);
							case 5:
								if(!killonater.enchanted)
								{
								slowPrintln("Your "+killonater.weaponType+" feels imbued with energy, you can feel the power flowing through it ");
								killonater.enchanted=true;
								}
								else
								{
									slowPrintln("Suddenly, the energy from your "+killonater.weaponType+" seems to dissipate into the air\n and on the ground, a pitiful compensatio of one coin");
									killonater.enchanted=false;
									bag.addGold(1);
								}
								break;
							}
							break;
						case 3:
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
					
						slowPrintln("Do you want to see your stats?");
						prompt=input.nextLine();
						
						switch (prompt)
						{
						case "y","yes","yerr":
							slowPrintln(character+"");
							slowPrintln(killonater+"");
						}
						
						if(character.aliveOrNot())//detects if you died in one of the other types of combats.
						{							
							slowPrintln("You Died");
							break;
						}		
				       floorStore(input, character,bag,killonater);
				   
				       slowPrint("Type quit to leave the game or press enter to continue on to the next floor:");
				       prompt = input.nextLine();
			}
		   while(!prompt.equals("quit"));
			
			if (prompt.equals("quit"))
			{
				slowPrintln("Welp thats the whole game, I hope you had fun!!");
			}
		input.close();	

}
}