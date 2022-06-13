package fr.umlv.fight.Arena;

import fr.umlv.fight.Robot;

public class Fight
{
	
	public static Robot fight (Robot player1, Robot player2)
	{
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
		}
		throw new IllegalStateException("Les deux robots sont morts ou un robot est déclaré mort trop tard.");
	}
}
