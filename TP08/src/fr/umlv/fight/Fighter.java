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
	
	@Override
	protected boolean rollDice ()
	{
		boolean touch = rgen.nextBoolean();
		//System.out.println("boolean = " + touch);
		return touch;
	}
	
}

/* Q1 : un générateur pseudo-aléatoire utilise un algorithme complexe à partir d'un nombre appelé
 * 		"graine" pour en générer un autre de manière imprévisible.
 * 
 * Q3 : si un champ est déclaré avec une visibilité "public", n'impore qui peut le modifier à sa
 * 		guise. Avec une visibilité "protected", n'importe qui peut le modifier en créant une
 * 		sous-classe. Avec une visibilité "private", seule la classe courante peut le modifier
 * 		sans avoir recours à un accesseur. Avec une visibilité "package", les classes du
 * 		package peuvent le modifier.
 * 		Par exemple ici, un objet extérieur (pour une visibilité public) ou un Fighter (pour une
 * 		visibilité protected) pourrais modifier les pv de notre Robot et les remettre à 10 comme
 * 		bon lui semble...
 * 
 * Q5 : le copier-coller reproduit aussi les erreurs de code.
 * 
 * Q9 : le sous-typage, c'est la réutilisation de méthodes et de champs dans un nouveau type sans
 * 		avoir à les redéfinir (par exemple name et hp).
 * 		le polymorphisme, c'est avoir différents comportements pour une méthode en fonction des
 * 		types effectifs des objets manipulés (par exemple fire() et rollDice()).
 */

