package gameprototypes;

public class Fireball extends SpellBase
{
	public Fireball(Weapon w, PlayerStats p)
	{	
		baseDamage=5;
		intelligenceModifier=1.5;
		spellName ="Fireball";
		magicCost=20;
		
		playerWeapon = w;
		player = p;
	}
		public int castFireball() throws InterruptedException 
		{
			int damage;
			player.useMagic(magicCost);
			
			damage=(int)(baseDamage*intelligenceModifier);
			Rpg1_18.slowPrintln("You cast fireball for "+magicCost+", you have "+ player.getMagic()+" magic left.");
			return damage;
		}
}

