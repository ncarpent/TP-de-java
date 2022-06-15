import java.util.Objects;

public record LaserDisc(String name) implements Article
{
	public LaserDisc
	{
		Objects.requireNonNull(name);
	}
	
	public String toText ()
	{
		return "LaserDisc:" + name;
	}
}
