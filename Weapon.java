package gameprototypes;

public class Weapon
{
	
	/*
	 * Notes:
	 * ___________________
	 *
	 *	To do:
	 *__________________
	 *tweak the values so that the game is properly balanced
	 * I think the balancing is going to be super hard, I don't even know how each of them should interact, and how to ensure they all work properly
	 */
	
		int minDamage,maxDamage,damageBonus,protection,evasionBuff,currentDamage;
		 boolean enchanted;
		String weaponType;
		public Weapon(String s)//constructor
		{
//			damageBonus=1000;
			weaponType=s;
			switch(weaponType)
			{
			case"sword":
				setMin(2);
				setMax(6);
				setProtection(0);
				break;
			case"shield":
				setMin(1);
				setMax(4);
				setProtection(3);
				evasionBuff=-4;
				break;	
			case "bow"://look up inheritance
				setMin(2);
				setMax(4);
				setProtection(0);
				evasionBuff=3;
			case"gauntlets":
				setMin(1);
				setMax(2);
				setProtection(0);
				evasionBuff=4;
			default:
				setMin(1);
				setMax(2);
				setProtection(0);
				evasionBuff=4;
				weaponType="gauntlets";
			
			}
		}
		public Weapon(int min,int max,int p,boolean suped)
		{
			setMin(min);
			setMax(max);
			setProtection(p);
			enchanted =suped;
		}
		
		//setters_____________________________
		public void addDamage(int dam)//bonus damage will be for upgrading the weapon
		{
			damageBonus+=dam;
		}
		public void setMin(int min)
		{
			minDamage=min;
		}
		public void setMax(int max)
		{
			maxDamage=max;
		}
		public void setProtection(int p)
		{
			protection= p;
		}
		
		//Getters__________________________
		public int getDamage()
		{
			return damageBonus;
		}
		public int getMin()
		{
			return minDamage;
		}
		public int getMax()
		{
			return maxDamage;
		}
		public int getProtection()
		{
			return protection;
		}
		public boolean enchanted()
		{
			return enchanted;
		}
		
		//Misc methods___________________________________
		
		
		public int randomGen(int min, int max)
		{
			return (int)(Math.random()*(max-min+1))+min;
		}
		public int rollDamage(int times)
		{
			if(times<=0)
			return 0;
			int dam = Rpg1_17.randomGen(minDamage, maxDamage)+damageBonus+rollDamage(times-1);
			currentDamage=dam;
			return dam;
		}
		public String toString()
		{
			String enchantedString;
			if(enchanted)
				enchantedString="your weapon is enchanted";
			else 
				enchantedString="your weapon is not enchanted";
			return "Damage: "+damageBonus+"   Protection: "+protection+"   "+enchantedString;
		}
		
	}