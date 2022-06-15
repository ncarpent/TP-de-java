import java.time.Duration;

public sealed interface Article permits VideoTape, LaserDisc
{
	static String VIDEOTAPE = "VideoTape";
	static String LASERDISC = "LaserDisc";
	
	String name();
	String toText();
	
	static Article fromText (String text)
	{
		String[] textsplit = text.split(":");
		switch(textsplit[0])
		{
		case VIDEOTAPE : {
			return new VideoTape(textsplit[1], Duration.ofMinutes(Integer.parseInt(textsplit[2])) );
		}
		case LASERDISC : {
			return new LaserDisc(textsplit[1]);
		}
		default : throw new IllegalArgumentException("Support de film erroné");
		}
	}
}
