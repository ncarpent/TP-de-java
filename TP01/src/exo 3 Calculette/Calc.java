import java.util.Scanner; 

public class Calc {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);//scanner;
		int value1 = scanner.nextInt();//value;
		int value2 = scanner.nextInt();
		System.out.println("Somme : ");
		System.out.println(value1 + value2);
		//"%d + %d = %d".format(value1.String(), value2.String(), (  ).String())
		System.out.println("Différence :");
		System.out.println(value1 - value2);
		System.out.println("Produit :");
		System.out.println(value1 * value2);
		System.out.println("Quotient :");
		System.out.println(value1 / value2);
		System.out.println("Reste :");
		System.out.println(value1 % value2);
		//System.out.println(, , , );
	}
}