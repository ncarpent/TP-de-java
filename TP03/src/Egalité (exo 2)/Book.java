import java.util.Objects;

public record Book (String title, String author)
{
	public Book
	{
		Objects.requireNonNull(title);
		Objects.requireNonNull(author);
	}
	
	public boolean isFromTheSameAuthor (Object other)
	{
		return other instanceof Book bk && this.author.equals(bk.author);
	}
	
	@Override
	public String toString ()
	{
		return title + " by " + author;
	}
}