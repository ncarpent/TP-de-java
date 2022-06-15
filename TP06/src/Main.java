import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.time.Duration;
//import java.util.Objects;

public class Main
{
	
	public static void main(String[] args)
	{
		System.out.println("Exercice 1 :");
		System.out.println();
		
		// Question 1
		var laserDisc = new LaserDisc("Jaws");
		var videoTape = new VideoTape("The Cotton Club", Duration.ofMinutes(128));
		var videoTape2 = new VideoTape("Mission Impossible", Duration.ofMinutes(110));
		
		// Question 2
		System.out.println("Question 2 :");
		var catalog = new Catalog();
		catalog.add(laserDisc);
		catalog.add(videoTape);
		catalog.add(videoTape2);
		// catalog.add(new LaserDisc("Mission Impossible")); // exception !
		System.out.println(catalog.lookup("Jaws"));
		System.out.println(catalog.lookup("The Cotton Club"));
		System.out.println(catalog.lookup("Indiana Jones"));
		System.out.println();
		
		//Question 3
		System.out.println("Question 3 :");
		System.out.println("_ toText :");
		var laserDiscText = laserDisc.toText();
		var videoTapeText = videoTape.toText();
		System.out.println(laserDiscText);  // LaserDisc:Jaws
		System.out.println(videoTapeText);  // VideoTape:The Cotton Club:128
		
		System.out.println("_ fromText :");
		var laserDisc2 = Article.fromText(laserDiscText);
		var videoTape3 = Article.fromText(videoTapeText);
		System.out.println(laserDisc.equals(laserDisc2));  // true
		System.out.println(videoTape.equals(videoTape3));  // true
		System.out.println();
		
		//Question 4 : écriture
		System.out.println("Question 4 :");
		var catalog2 = new Catalog();
		catalog2.add(laserDisc);
		catalog2.add(videoTape);
		try
		{
			catalog2.save(Path.of("catalog.txt"));
			System.out.println("catalog.txt saved");
		}
		catch (IOException e)
		{
			System.err.println(e.getMessage());
			System.exit(1);
			return; // utilité du return ???
		}
		
		//Question 4 : leture
		var catalog3 = new Catalog();
		try
		{
			catalog3.load(Path.of("catalog.txt"));
			System.out.println("catalog.txt loaded");
		}
		catch (IOException e)
		{
			System.err.println(e.getMessage());
			System.exit(1);
			return; // utilité du return ???
		}
		System.out.println(catalog3.lookup("Jaws"));  // LaserDisc:Jaws
		System.out.println(catalog3.lookup("The Cotton Club"));  // VideoTape:The Cotton Club:128
		System.out.println();
		
		//Question 5 : écriture
		System.out.println("Question 5 :");
		var catalog4 = new Catalog();
		catalog4.add(new LaserDisc("A Fistful of €"));
		catalog4.add(new VideoTape("For a Few €s More", Duration.ofMinutes(132)));
		try
		{
			catalog4.save(Path.of("catalog-windows-1252.txt"), Charset.forName("Windows-1252"));
			System.out.println("catalog-windows-1252.txt saved");
		}
		catch (IOException e)
		{
			System.err.println(e.getMessage());
			System.exit(1);
			return; // utilité du return ???
		}
		
		//Question 5 : lecture
		var catalog5 = new Catalog();
		try
		{
			catalog5.load(Path.of("catalog-windows-1252.txt"), Charset.forName("Windows-1252"));
			System.out.println("catalog-windows-1252.txt loaded");
		}
		catch (IOException e)
		{
			System.err.println(e.getMessage());
			System.exit(1);
			return; // utilité du return ???
		}
		System.out.println(catalog5.lookup("A Fistful of €"));
		System.out.println(catalog5.lookup("For a Few €s More"));
		System.out.println();
		
		//Question 6 : écriture
		System.out.println("Question 6 :");
		var catalog6 = new Catalog();
		catalog6.add(new VideoTape("Back to the future", Duration.ofMinutes(116)));
		catalog6.add(new LaserDisc("Back to the future part II"));
		catalog6.add(new LaserDisc("Back to the future part III"));
		try
		{
			catalog6.saveInBinary(Path.of("catalog.binary"));
			System.out.println("catalog.binary saved");
		}
		catch (IOException e)
		{
			System.err.println(e.getMessage());
			System.exit(1);
			return; //utilité du return ???
		}
		
		// Question 6 : lecture
		var catalog7 = new Catalog();
		try
		{
			catalog7.loadInBinary(Path.of("catalog.binary"));
			System.out.println("catalog.binary loaded");
		}
		catch (IOException e)
		{
			System.err.println(e.getMessage());
			System.exit(1);
			return; //utilité du return ???
		}
		System.out.println(catalog7.lookup("Back to the future"));
		System.out.println(catalog7.lookup("Back to the future part II"));
		System.out.println(catalog7.lookup("Back to the future part III"));
		System.out.println();
	}

}

