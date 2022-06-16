import java.util.Objects;

public record Book (String title, String author)
{
	/*
	public static void main (String[] args)
	{
		var book = new Book("Da Vinci Code", "Dan Brown");
		System.out.println(book.title + ' ' + book.author);
	}
	*/
	
	/*
	public Book (String title, String author)
	{
		Objects.requireNonNull(title);
		this.title = title;
		Objects.requireNonNull(author);
		this.author = author;
	}
	*/
	
	public Book
	{
		Objects.requireNonNull(title);
		Objects.requireNonNull(author);
	}
	
	
	public Book (String title)
	{
		this(title, "<no author>");
		//this.title = title;
		//this.author = "<no author>";
	}
	
	public Book withTitle(String title) {
		return new Book(title, this.author);
	}
}