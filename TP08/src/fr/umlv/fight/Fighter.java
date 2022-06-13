package fr.umlv.fight;

import java.util.Random;

public class Fighter extends Robot
{
	private int seed;
	private Random rgen;
	
	public Fighter (String name, int seed)
	{
		super(name);
		this.seed = seed;
		rgen = new Random(this.seed);
	}
	
	@Override
	public String toString ()
	{
		return "Fighter " + this.name();
	}
	
	/* 
	public void fire (Robot target)
	{
		
		
		if (touch)
		{
			target.hp(target.hp()-2);
			System.out.println(target + " a �t� touch� par le " + this + " !");
		}
	}
	*/
	
	@Override
	protected boolean rollDice ()
	{
		boolean touch = rgen.nextBoolean();
		//System.out.println("boolean = " + touch);
		return touch;
	}
	
}

/* Q1 : un g�n�rateur pseudo-al�atoire utilise un algorithme complexe � partir d'un nombre appel�
 * 		"graine" pour en g�n�rer un autre de mani�re impr�visible.
 * 
 * Q3 : si un champ est d�clar� avec une visibilit� "public", n'impore qui peut le modifier � sa
 * 		guise. Avec une visibilit� "protected", n'importe qui peut le modifier en cr�ant une
 * 		sous-classe. Avec une visibilit� "private", seule la classe courante peut le modifier
 * 		sans avoir recours � un accesseur. Avec une visibilit� "package", seules les classes du
 * 		package peuvent le modifier.
 * 		Par exemple ici, un objet ext�rieur (pour une visibilit� public) ou un Fighter (pour une
 * 		visibilit� protected) pourrais modifier les pv de notre Robot et les remettre � 10 comme
 * 		bon lui semble...
 * 
 * Q5 : le copier-coller reproduit aussi les erreurs de code.
 * 
 * Q9 : le sous-typage, c'est la r�utilisation de m�thodes et de champs dans un nouveau type sans
 * 		avoir � les red�finir (par exemple name et hp).
 * 		le polymorphisme, c'est avoir diff�rents comportements pour une m�thode en fonction des
 * 		types effectifs des objets manipul�s (par exemple fire() et rollDice()).
 */

