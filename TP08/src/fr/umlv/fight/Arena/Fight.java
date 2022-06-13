package fr.umlv.fight.Arena;

import fr.umlv.fight.Robot;

public class Fight
{
	/*
	static private void swap (Robot r1, Robot r2)
	{
		Robot tmp = r2;
		r2 = r1;
		r1 = tmp;
	}
	*/
	
	public static Robot fight (Robot player1, Robot player2)
	{
		//Robot attacking = player1;
		//Robot target = player2;
		boolean order = true;
		while (!(player1.isDead()) && !(player2.isDead()))
		{
			if (order)
			{
				player1.fire(player2);
				if (player2.isDead())
				{
					return player1;
				}
			}
			else
			{
				player2.fire(player1);
				if (player1.isDead())
				{
					return player2;
				}
			}
			order = !order;
			/*
			System.out.println("tour " + tour + " - attaquant : " + attacking);
			System.out.println("tour " + tour + " - cible : " + target);
			attacking.fire(target);
			if (target.isDead())
			{
				return attacking;
			}
			Fight.swap(attacking, target);
			tour++;
			*/
		}
		throw new IllegalStateException("Les deux robots sont morts ou un robot est déclaré mort trop tard.");
	}
}
