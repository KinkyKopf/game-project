package gameprototypes;

public class SpellBase 
{
	 Weapon playerWeapon;
	 PlayerStats player;
	 int baseDamage;
	 double intelligenceModifier;
	 int magicCost;
	
	public int castSpell()
	{
		int damage;
		player.useMagic(magicCost);
		
		damage=(int)(baseDamage*intelligenceModifier);
		
		return damage;
	}
	
	
	
}
