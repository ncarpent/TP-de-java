import java.time.Duration;
import java.util.Objects;

public record VideoTape(String name, Duration duration) implements Article
{
	public VideoTape
	{
		Objects.requireNonNull(name);
		if (duration.compareTo(Duration.ZERO) < 0) {throw new IllegalArgumentException("Durée négative.");}
	}
	
	public String toText ()
	{
		return "VideoTape:" + name + ":" + duration.toMinutes();
	}
}
