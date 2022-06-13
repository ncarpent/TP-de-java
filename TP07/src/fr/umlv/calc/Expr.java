package fr.umlv.calc;

import java.util.Iterator;
//import java.util.Scanner;

public sealed interface Expr //permits Expr.Add, Expr.Sub, Expr.Mul, Expr.Value//, Expr.Binop
{
	
	abstract int eval ();
	
	public String toString ();
	
	public static Expr parse (Iterator<String> sc) // Ne prends pas une list !!!!
	{
		String next = sc.next();
		return switch (next)
		{
		case "+" -> new Add(parse(sc), parse(sc));
		case "-" -> new Sub(parse(sc), parse(sc));
		case "*" -> new Mul(parse(sc), parse(sc));
		default -> new Value(Integer.parseInt(next));
		};
	}
	
	
	public record Add (Expr val1, Expr val2) implements BinOp
	{
		
		@Override
		public int op (int v1, int v2)
		{
			return v1 + v2;
		}
		
		@Override
		public String toString ()
		{
			return "(" + val1.toString() + "+" + val2.toString() + ")";
		}
		
	}
	
	public record Sub (Expr val1, Expr val2) implements BinOp
	{
		
		@Override
		public int op (int v1, int v2)
		{
			return v1 - v2;
		}
		
		@Override
		public String toString () 
		{
			return "(" + val1.toString() + "-" + val2.toString() + ")";
		}
		
	}
	
	public record Mul (Expr val1, Expr val2) implements BinOp
	{
		
		@Override
		public int op (int v1, int v2)
		{
			return v1 * v2;
		}
		
		@Override
		public String toString ()
		{
			return "(" + val1.toString() + "*" + val2.toString() + ")";
		}
		
	}
	
	public record Value (int val) implements Expr
	{
		
		@Override
		public int eval ()
		{
			return val;
		}
		
		@Override
		public String toString ()
		{
			return Integer.toString(val);
		}
		
	}
	
	public sealed interface BinOp extends Expr
	{
		Expr val1();
		Expr val2();
		public abstract int op (int e1, int e2);
		
		default int eval ()
		{
			int e1 = val1().eval();
			int e2 = val2().eval();
			return op(e1, e2);
		}
		
	}
	
	/*
	public static void main(String[] args)
	{
		
		Expr expression = new Add(new Value(2), new Value(3));
		Expr expression2 = new Sub(new Mul(new Value(2), new Value(3)), new Value(4));
		System.out.println(expression.eval());
		System.out.println(expression2.eval());
		System.out.println(Integer.parseInt("007"));
		Scanner sc = new Scanner("- + 2 3 4");
		Expr expression3 = Expr.parse(sc);
		System.out.println(expression3.eval());
	}
	*/
	
	/* m�thode parse d�finie pour un Scanner :
	public static Expr parse (Scanner sc)
	{
		if (sc.hasNextInt())
		{
			return new Value(sc.nextInt());
		}
		else
		{
			switch (sc.next())
			{
			case "+" :
			{
				return new Add(parse(sc), parse(sc));
			}
			case "-" :
			{
				return new Sub(parse(sc), parse(sc));
			}
			case "*" :
			{
				return new Mul(parse(sc), parse(sc));
			}
			default : throw new IllegalArgumentException("symbole non reconnu.");
			}
		}
	}
	*/
	
	/*
	 * Q4 : Il faut fermer l'interface Expr.
	 * 
	 * Q5 : c'est int�ressant car on peut d�sormais fermer l'interface sans sp�cifier les types qui
	 * 		sont autoris�s (car ceux-ci sont pr�sents dans l'interface).
	 * 
	 * Q9 : Binop doit �tre une interface, pour pouvoir subvenir � toutes les attentes de ce nouveau
	 * 		type :
	 * 		_ On peut donc d�finir certaines m�thodes qui �taient abstraites dans Expr (comme eval, qui
	 * 		est le but de la cr�ation de BinOp).
	 * 		_ On peut garder certaines m�thodes abstraites (comme toString, qui d�pendra de chaque
	 * 		type).
	 * 		_ Et on peut g�n�rer de nouvelles m�thodes abstraites (comme op, qui sp�cifiera le
	 * 		fonctionnement de eval dans chaque sous-type)
	 * 
	 */
}
