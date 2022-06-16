public class Main
{
	public static void main (String[] args)
	{
		var s = "toto";
		System.out.println(s.length());
		System.out.println();
		
		var s1 = "toto";
		var s2 = s1;
		var s3 = new String(s1);
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println();
		
		var s4 = "toto";
		var s5 = new String(s4);
		System.out.println(s4.equals(s5));
		System.out.println();
		
		var s6 = "toto";
		var s7 = "toto";
		System.out.println(s6 == s7);
		System.out.println();
		
		var s8 = "hello";
		s8.toUpperCase();
		System.out.println(s8);
		System.out.println();
	}
}