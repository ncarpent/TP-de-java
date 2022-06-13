package fr.umlv.fight;

import java.util.Objects;

public class Robot
{
	private String name;
	private int hp;
	
	public String name() {return name;}
	
	public int hp () {return hp;}
	
	public void hp (int n) {hp = n;}
	
	public Robot (String name)
	{
		Objects.requireNonNull(name);
		this.name = name;
		this.hp = 10;
	}
	
	@Override
	public String toString ()
	{
		return "Robot " + this.name;
	}
	
	public void fire (Robot target)
	{
		if (target.isDead())
		{
			throw new IllegalStateException("La cible est déjà morte !");
		}
		if (rollDice())
		{
			target.hp(target.hp()-2);
			System.out.println(target + " a été touché par le " + this + " !");
		}
		
		
	}
	
	public boolean isDead ()
	{
		return hp == 0;
	}
	
	protected boolean rollDice ()
	{
		return true;
	}
	
}

/*
 * Q1 : On ne peut pas utiliser de record car le nombre de points de vie varie avec le temps.
 */
 