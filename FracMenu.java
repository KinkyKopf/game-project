package fractions;

import java.util.ArrayList;
import java.util.Scanner;

public class FracMenu 
{

	public static void main(String[] args)
	{
		Scanner input =new Scanner(System.in);
		int selection,num,denom;
		boolean exit=false;
		ArrayList<Fraction> fracArray = new ArrayList<Fraction>();
//		System.out.println(fList.size());
		System.out.println("Welcome to my thing please enter what you would like to do!");
		do
		{
			selection =input.nextInt();
			switch(selection)
			{
			case 0:
				System.out.print("Exiting");
				exit=true;
				break;
			case 1: 
				//display fractions
//				System.out.println("Displaying fractions");
				if(fracArray.size()==0)
					System.out.println("There are no fractions");
				else 
					System.out.println(fracArray);
				break;
			case 2:
				//add fraction
				
					System.out.println("Enter the numerator of the fraction to add:");
					num=input.nextInt();
					input.nextLine();
					System.out.println("Enter the denominator of the fractions to add:");
					denom=input.nextInt();
//					System.out.println("Hello");i-
					fracArray.add(new Fraction(num,denom));
//					System.out.println("Hello");
				break;
			case 3:
				System.out.print("Enter the location where you would like to enter the fraction: ");
				num=input.nextInt()-1;
				if(num>fracArray.size()-1||num<0)
				{
					System.out.println("You may only insert fractions between locations 1 and "+fracArray.size()+".Please try again");
				}
				else
				{
				System.out.print("Enter the numerator of the new fraction: ");
				num=input.nextInt();
				System.out.print("Enter the denominator of the new fraction: ");
				denom=input.nextInt();
				fracArray.add(input.nextInt(),new Fraction(.5));
				}
				break;
			case 4:
				///remove fraction at location
				break;
			case 5:
				//remove fraction by value
				break;
			case 6:
				//replace a fraction at a specific location
				break;
				default:
					System.out.println("That is not a valid command, please be better next time");
			}
			
		}
		while(!exit);
	}

}
