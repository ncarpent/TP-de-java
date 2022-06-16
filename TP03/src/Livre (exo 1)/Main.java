public class Main
{
	public static void main (String[] args)
	{
		var book = new Book("Da Vinci Code", "Dan Brown");
		System.out.println(book.title() + ' ' + book.author());
		var weirdBook = new Book("Lord of the rings");
		System.out.println(weirdBook.title() + ' ' + weirdBook.author());
		weirdBook = weirdBook.withTitle("Le seigneur des anneaux");
		System.out.println(weirdBook.title() + ' ' + weirdBook.author());
	}
}