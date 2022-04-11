package narrative;

import java.util.Scanner;

/*
 * Zachary Kinkopf 
 * april 7
 * this might be my senior narrative?
 */
public class MainClass 
{
	/*
	 * Notes/ideas
	 * 
	 * I want to divide the game into chapters and have each one be a different part of my life
	 * 
	 */
	static boolean aiAutoRun;
	static int printSpeed=15;
	
	static Scanner input =new Scanner(System.in);
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
	public static void slowPrint(String text) throws InterruptedException
	{
		
		
		for (int i=0;i<text.length();i++)
		{
			System.out.print(text.charAt(i));
			if(!aiAutoRun)
				Thread.sleep(printSpeed);
		}
	}
	
	public static void narratorPrintln(String text) throws InterruptedException
	{
		
		
		for (int i=0;i<text.length();i++)
		{
			System.err.print(text.charAt(i));
			if(!aiAutoRun)
				Thread.sleep(printSpeed);
		}
		System.out.println();
	}
	public static void narratorPrint(String text) throws InterruptedException
	{
		
		
		for (int i=0;i<text.length();i++)
		{
			System.err.print(text.charAt(i));
			if(!aiAutoRun)
				Thread.sleep(printSpeed);
		}
	}
	public static void narratorPrint(String text,int printingSpeed) throws InterruptedException//This slow prints, but you can set the print speed, good for counting.
	{
		//this is for multi-testing where I want it to go as fast as possible
		for (int i=0;i<text.length();i++)
		{
			System.err.print(text.charAt(i));
			if(!aiAutoRun)
				Thread.sleep(printingSpeed);
		}
	}
	public static void narratorPrintln(String text,int printingSpeed) throws InterruptedException//This slow prints, but you can set the print speed, good for counting.
	{
		//this is for multi-testing where I want it to go as fast as possible
		for (int i=0;i<text.length();i++)
		{
			System.err.print(text.charAt(i));
			if(!aiAutoRun)
				Thread.sleep(printingSpeed);
		}
		System.out.println();
	}
	public static void main(String[] args) throws InterruptedException 
	{
		String user;
		narratorPrintln("Hi I'm Zach, I will be your narrator/guide through my mind for the duration of this game.\n\nFor reference, the narration and my personal thoughts will be in red, evertyhing else will be in black\n\nTry to answer things, clearly and be careful of things like numbers being where they shouldn't\n\nI will try to put things in an easy order but I have a week to to make this so I mean ¯\\_(ツ)_/¯\n\n ");
		slowPrint("Does this make sense?(y/n): ");
		user=input.nextLine().toLowerCase();
		if(user.equals("y")||user.equals("yes"))
			narratorPrintln("Great so glad to see that makes sense!");
		else
			narratorPrintln("Too bad, you're already strapped in for the ride and I gave the drunken monkey I call my brain the keys OFF WE GO!");
		chapterOne();
		
		
		
	}
	
	public static void chapterOne() throws InterruptedException
	{
		boolean quit=false;
		
		String user;
		slowPrintln("Chapter 1: \n\tPreschool-Second Grade",0);
		slowPrintln("Welcome Zach, let me introduce you to some kids, this young lady is Vivian cox, Next to her Is Will Ott and this last boy is Fletcher");
		Thread.sleep(2000);
		narratorPrintln("Wanna guess which one is the \"antagonist\"?",printSpeed+15);
		Thread.sleep(2000);
		
		slowPrint("Type the name of the person you want to introduce yourself to or type leave to move on: ");
		user=input.nextLine().toLowerCase();
		{ int timesDone=0;
		do
		{
			
			switch(user.charAt(0))
			{
			case 'v':
				slowPrintln("You introduce yourself to Vivian, she seems super nice but shes a girl so thats like totally gross");				
				break;
			case 'w':
				slowPrintln("You introduce yourself to Will,he has blonde hair and is super cool, he will probably become a surfer bro later on");
				
				break;
			case 'f': 
				slowPrintln("You introduce yourself to Fletcher, he has a cleft lip and seems rather annoying\n");
				narratorPrintln("In case you didn't get the hint earlier, fletcher is the antagonist for chapter one");
				break;
			case 'l':
				if(timesDone==0)
					narratorPrintln("Ha, I probably wouldn't introduce myself either");
			}
					slowPrint("Enter who you would like to talk to:");
					user=input.nextLine().toLowerCase();
					
			
		}
		while(!quit);
		}
		
		slowPrint("After introducing yourself to the other kids, its time to play with toys\n\nNear you are a robin's nest, blocks, and a hammer.\nEnter what you would like to play with: ");
		user=input.nextLine().toLowerCase();
		do
		{
			switch(user)
			{
			case "blocks":
				slowPrintln("You play with the blocks for a little bit but the square peg doesn't fit inside the round hole so you throw them at some idiot toddler");
				quit=true;
				break;
			case 'w':
				quit=true;
				break;
			case 'f': 
				
				quit=true;
				break;
				default:
					user=input.nextLine();
					quit=false;
			}
		}
		while(!validAnswer);
		
	}
}
