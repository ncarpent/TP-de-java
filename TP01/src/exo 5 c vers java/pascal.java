public class pascal
{
	public static void main (String[] args)
	{
		System.out.printf(" Cn, p = %d\n", calcul (3000, 25));//30000 250
	}
	
	public static int calcul (int nBut, int pBut)
	{
		int[] tab = new int[nBut];
		int n, i;
		
		//tab = (int *)malloc ((nBut+1)*sizeof(int));
		if(tab==null)
		{
			System.out.printf("Pas assez de place\n");
			System.exit(0);
		}
		
		tab[0] = 1;
		
		for(n=1; n<=nBut; n++)
		{
			tab[n] = 1;
			for(i=n-1; i>0; i--)
				tab[i] = tab[i-1] + tab[i];
		}
		
		int result=tab[pBut];
		//free(tab);
		return result;
	}
}