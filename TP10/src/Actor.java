import java.util.Objects;

public record Actor (String firstName, String lastName)
{
	public Actor
	{
		Objects.requireNonNull(firstName);
		Objects.requireNonNull(lastName);
	}
	
	public String toString ()
	{
		return "Actor(\"" + firstName + "\", \"" + lastName + "\")";
	}
}