package unit5;

import java.util.Scanner;

public class Anagram 
{

	public static boolean testAnagrams(String str1, String str2)
	{
		return sortLexiographically(str1).equals(sortLexiographically(str2));
	}
	
	public static String getRidOfStupidStuff(String s)
	{
		for(int i=0;i<s.length();i++)
		{
			if(!Character.isLetter(s.charAt(i)))
			{
				s=s.substring(0,i)+s.substring(i+1);
				i=0;
			}
				
		}
		return s;
	}
	
	public static String sortLexiographically(String str)
	{
		Scanner input = new Scanner(System.in);
		String sorted="";
		String prompt="";
		str=str.toLowerCase();
		int i=0;
		str=getRidOfStupidStuff(str);
		while(true)
		{

			boolean isNext=false;
			
			if(str.charAt(i)!=' ')
			{
				for(int k=0;k<str.length();k++) 
				{
					System.out.println("Comparing "+str.charAt(i)+" to "+str.charAt(k)+" with a result of "+(str.charAt(i)+"").compareTo(""+str.charAt(k)));
					if( (str.charAt(i)+"").compareTo(""+str.charAt(k))>0)
						break;
					
					if( k==str.length()-1 && (str.charAt(i)+"").compareTo(""+str.charAt(k))<1)
					{
						isNext=true;
						System.out.println(str.charAt(i)+" is the next letter");
						
						sorted+=str.charAt(i);
						System.out.println(sorted+" ADDED");
						str=str.substring(0,i)+str.substring(i+1);
						System.out.println(str);
						i=0;
					}
				}
					if(str.length()<=1)
						return sorted+str;
			if(!isNext)
				i++;
			}
			else
			{
				str=str.substring(0,i)+str.substring(i+1);
			}
			//i=input.nextInt();
		}
		
	}
}
