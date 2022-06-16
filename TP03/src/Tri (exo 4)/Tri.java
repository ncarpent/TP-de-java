//import java.lang.Array;

public class Tri
{
	public static void main (String[] args)
	{
		int[] tab={5,6,0,8,15,3,12};
		System.out.print("tab : ");
		affiche_tab_ln(tab);
		Tri.sort(tab);
		System.out.print("sorted : ");
		affiche_tab_ln(tab);
	}
	
	
	
	
	public static void swap (int[] array, int index1, int index2)
	{
		int tmp = 0;
		tmp = array[index1];
		array[index1] = array[index2];
		array[index2] = tmp;
	}
	
	
	
	public static int indexOfMin (int[] array, int index1, int index2)
	{
		if (array.length < index2 || index1 >= index2)
		{
			throw new ArrayIndexOutOfBoundsException("tableau vide");
		}
		int min = array[index1];
		int idx = index1;
		for (int k=index1 ; k<index2 ; k++)
		{
			if (min>array[k])
			{
				min = array[k];
				idx = k;
			}
		}
		return idx;
	}
	
	
	
	public static void sort (int[] array)
	{
		for (int k=0 ; k<array.length ; k++)
		{
			int imin = indexOfMin(array, k, array.length);
			if (imin != k)
			{
				swap(array, k, imin);
			}
		}
	}
	
	
	
	public static void affiche_tab_ln (int[] tab)
	{
		int k;
		System.out.print("[");
		for (k=0 ; k<tab.length -1 ; k++)
		{
			System.out.print(tab[k] + ", ");
		}
		System.out.println(tab[k] + "]");
	}
	
	
}