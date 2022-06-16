public class Main
{
	public static void main (String[] args)
	{
		var b1 = new Book("Da Java Code", "Duke Brown");
		var b2 = b1;
		var b3 = new Book("Da Java Code", "Duke Brown");
		
		System.out.println(b1 == b2);
		System.out.println(b1 == b3);
		
		System.out.println();
		
		System.out.println(b1.equals(b2));
		System.out.println(b1.equals(b3));
		
		System.out.println();
		
		var book1 = new Book("Da Vinci Code", "Dan Brown");
		var book2 = new Book("Angels & Demons", new String("Dan Brown"));
		System.out.println(book1.isFromTheSameAuthor(book2));
		
		System.out.println();
		
		var javaBook = new Book("Da Java Code", "Duke Brown");
		System.out.println(javaBook);
	}
}