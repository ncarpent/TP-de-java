import java.util.HashMap;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Catalog
{
	public HashMap<String, Article> catalog;
	
	public Catalog ()
	{
		catalog = new HashMap<String, Article>();
	}
	
	
	
	public void add (Article m)
	{
		if (lookup(m.name()) != null)
		{
			throw new IllegalArgumentException("L'article est déjà présent.");
		}
		catalog.put(m.name(), m);
	}
	
	public Article lookup (String name)
	{
		return catalog.get(name);
	}
	
	public void save (Path p) throws IOException
	{
		save(p, StandardCharsets.UTF_8);
	}
	
	public void save (Path p, Charset encoding) throws IOException
	{
		try (var writer = Files.newBufferedWriter(p, encoding))
		{
			for (var article : catalog.values())
			{
				writer.write(article.toText());
				writer.newLine();
			}
		}
	}
	
	public void saveInBinary (Path p) throws IOException
	{
		try (var output = Files.newOutputStream(p);
			var data = new DataOutputStream(output)) // catch ajoutable???
		{
			String text;
			String[] textsplit;
			data.writeInt(catalog.values().size());
			for (var article : catalog.values())
			{
				text = article.toText();
				textsplit = text.split(":");
				switch (textsplit[0])
				{
				case "VideoTape" : //Article.VIDEOTAPE
				{
					data.writeByte(1);
					data.writeUTF(textsplit[1]);
					data.writeLong(((VideoTape) article).duration().toMinutes());
					break;
				}
				case "LaserDisc" : //Article.LASERDISC
				{
					data.writeByte(2);
					data.writeUTF(textsplit[1]);
					break;
				}
				default : 
				{
					throw new IllegalArgumentException("Support de film erroné");
				}
				}
			}
		}
	}
	
	public void load (Path p) throws IOException
	{
		load(p, StandardCharsets.UTF_8);
	}
	
	public void load (Path p, Charset encoding) throws IOException
	{
		try (var reader = Files.newBufferedReader(p, encoding))
		{
			String ligne;
			Article art;
			while ((ligne = reader.readLine()) != null)
			{
				art = Article.fromText(ligne);
				catalog.put(art.name(), art);
			}
		}
	}
	
	public void loadInBinary (Path p) throws IOException
	{
		try ( var input = Files.newInputStream(p);
			var data = new DataInputStream(input))
		{
			int len = data.readInt();
			int type;
			String name;
			long nbMin;
			for (int i=0 ; i < len ; i++)
			{
				type = data.read();
				switch (type)
				{
				case 1 :
				{
					name = data.readUTF();
					nbMin = data.readLong();
					catalog.put(name, new VideoTape(name, Duration.ofMinutes(nbMin)));
					break;
				}
				case 2 :
				{
					name = data.readUTF();
					catalog.put(name, new LaserDisc(name));
					break;
				}
				default :
				{
					throw new IllegalArgumentException ("unsupported type number.");
				}
				}
			}
		}
	}
}

/*
 * Exercice 1 :
 * Q2/ 	_ Il faut créer une interface commune à VideoTape et LaserDisc (ici Article). La méthode add
 * 		prend alors un Article en paramètre et la méthode lookup renvoie un Article.
 * 		_ S'il n'y a ni cassette, ni disc qui a le nom demandé, lookup doit renvoyer null.
 * 
 * Q3/ La méthode toText s'applique sur un Article. On peut donc la créer comme une méthode
 * 		d'instance de cet Article.
 * 		La méthode fromText s'applique sur une String (on ne peut donc pas la créer comme méthode
 * 		d'instance de String). On doit alors la créer comme méthode statique de Article.
 * 		La méthode fromText liste explicitement les différents cas possibles, il ne doit donc pas y
 * 		en avoir d'autres. L'interface doit être fermée.
 * 
 * Q4/ Pour créer un écrivain sur un fichier texte à partir d'un Path, on utilise la méthode
 * 		newBufferedWriter de la classe Files.
 * 		Pour garantir que la ressource système est bien libérée, il faut utiliser un try().
 * 		Pour gérer l'exception d'entrée/sortie, il ne faut pas oublier de mentionner la clause
 * 		throws.
 * 		L'intérêt de définir la méthode load comme méthode d'instance est que l'on peut charger un
 * 		fichier de sauvegarde à la suite d'un catalogue qui n'est pas vide.
 */
