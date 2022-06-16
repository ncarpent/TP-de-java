public class Morse
{
	public static void main (String[] args)
	{
		/*
		String morse = "";
		for (int i=0 ; i < args.length ; i++)
		{
			morse += args[i] + " Stop. ";
		}
		System.out.println(morse);
		*/
		StringBuilder morse = new StringBuilder();
		for (int i=0 ; i < args.length ; i++)
		{
			morse.append(args[i]).append(" Stop. ");
		}
		System.out.println(morse);
	}
}