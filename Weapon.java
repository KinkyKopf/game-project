package gameprototypes;

import oldversions.Rpg1_17;

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
	
		int minDamage,maxDamage,damageBonus,protection,evasionBuff,currentDamage,upgradeCost;
		 boolean enchanted;
		String weaponType;
		Inventory bag;
		public Weapon(String s,Inventory b)//constructor
		{
//			damageBonus=1000;
			weaponType=s;
			upgradeCost=200;
			switch(weaponType)
			{
			case"sword":
				setMin(2);
				setMax(6);
				setProtection(0);
				evasionBuff=2;
				break;
			case"shield":
				setMin(1);
				setMax(4);
				setProtection(1);
				evasionBuff=-3;
				break;	
			case "bow"://look up inheritance
				setMin(2);
				setMax(5);
				setProtection(0);
				System.out.println("Bow Bought!");
				evasionBuff=6;
				break;
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
			bag=b;
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
		public void upgrade(int f) throws InterruptedException
		{
			if(weaponType.equals("shield"))
			{
				protection+=Rpg1_17.randomGen(1, 3);
			}
			damageBonus+=Rpg1_17.randomGen(1, 3)*(int)(f*1.5);
			bag.addUpgrades(-1);
			bag.addGold(-200);
			Rpg1_18.slowPrintln("The shopkeeper takes your "+weaponType+" into the back, a while later he comes back with your weapon");
			Thread.sleep(200);
			Rpg1_18.slowPrintln("It dosen't look any different, but as you hold the "+weaponType+" it just FEELS more deadly.");
		}
		
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
			return "Bonus Damage: "+damageBonus+"   Protection: "+protection+"   "+enchantedString;
		}
		
	}