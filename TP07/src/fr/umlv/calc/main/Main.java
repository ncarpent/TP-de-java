package fr.umlv.calc.main;

import java.util.List;
import java.util.Scanner;
import fr.umlv.calc.Expr;
import fr.umlv.calc.Expr.*;

//import fr.umlv.calc.Expr.Add;
//import fr.umlv.calc.Expr.Mul;
//import fr.umlv.calc.Expr.Sub;
//import fr.umlv.calc.Expr.Value;

public class Main
{
	public static void main(String[] args)
	{
		// Question 1
		System.out.println("Question 1 :");
		Expr expression = new Add(new Value(2), new Value(3));
		System.out.println("expression 1 : " + expression);
		Expr expression2 = new Sub(new Mul(new Value(2), new Value(3)), new Value(4));
		System.out.println("expression 2 : " + expression2);
		System.out.println();
		
		// Question 2
		System.out.println("Question 2 :");
		System.out.println("résultat 1 : " + expression.eval());
		System.out.println("résultat 2 : " + expression2.eval());
		System.out.println();
		
		// Question 3
		System.out.println("Question 3 :");
		Scanner sc = new Scanner("- + 2 3 4");
		Expr expression3 = Expr.parse(sc);
		System.out.println("expression 3 : " + expression3);
		System.out.println("résultat 3 : " + expression3.eval());
		System.out.println();
		
		// Question 7
		System.out.println("Question 7 : ");
		List<String> liste = List.of("-", "+", "2", "3", "4");
		Expr expression4 = Expr.parse(liste.iterator()); //Ne prends pas une list !!!
		System.out.println("expression 4 : " + expression4);
		System.out.println("résultat 4 : " + expression4.eval());
		
		//System.out.println(Integer.parseInt("007"));
		//System.out.println(Integer.parseInt("+"));
		//String v = String.valueOf(5);
		//Scanner sc = new Scanner((Readable) liste); est-ce possible ???
		
		
	}
}

/* 
 * 
 */
