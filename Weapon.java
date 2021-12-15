package game;

public class Weapon
{
	
		int minDamage,maxDamage,damageBonus,protection,evasionBuff;
		private boolean enchanted;
		String weaponType;
		public Weapon(String s)//constructor
		{
			weaponType=s;
			switch(weaponType)
			{
			case"sword":
				setMin(1);
				setMax(6);
				setProtection(2);
				break;
			case"shield":
				setMin(1);
				setMax(4);
				setProtection(4);
				evasionBuff=-4;
				break;	
			case "bow"://look up inheritance
				setMin(1);
				setMax(4);
				setProtection(0);
				evasionBuff=5;
			case"gauntlets":
				setMin(1);
				setMax(2);
				setProtection(0);
				evasionBuff=7;
			
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
			return dam;
		}
		public String toString()
		{
			return "Damage: "+damageBonus+"\nProtection: "+"\nEnchanted: "+enchanted;
		}
		
	}
