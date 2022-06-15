import java.util.HashMap;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
//import java.util.ArrayList;
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
			throw new IllegalArgumentException("L'article est d�j� pr�sent.");
		}
		catalog.put(m.name(), m);
	}
	
	public Article lookup (String name) // renvoie null si pas trouv� !
	{
		return catalog.get(name);
	}
	
	public void save (Path p) throws IOException
	{
		save(p, StandardCharsets.UTF_8);
		/*try (var writer = Files.newBufferedWriter(p))
		{
			for (var article : catalog.values())
			{
				writer.write(article.toText());
				writer.newLine();
			}
		}*/
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
					throw new IllegalArgumentException("Support de film erron�");
				}
				}
			}
		}
	}
	
	public void load (Path p) throws IOException
	{
		load(p, StandardCharsets.UTF_8);
		/*try (var reader = Files.newBufferedReader(p))
		{
			String ligne;
			Article art;
			while ((ligne = reader.readLine()) != null)
			{
				art = Article.fromText(ligne);
				catalog.put(art.name(), art);
			}
		}*/
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
			var data = new DataInputStream(input)) //catch ajoutable ???
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
 * Q2/ 	_ Il faut cr�er une interface commune � VideoTape et LaserDisc (ici Article). La m�thode add
 * 		prend alors un Article en param�tre et la m�thode lookup renvoie un Article.
 * 		_ S'il n'y a ni cassette, ni disc qui a le nom demand�, lookup doit renvoy� null.
 * 		???
 * 
 * Q3/ La m�thode toText s'applique sur un Article. On peut donc la cr�er comme une m�thode
 * 		d'instance de cet Article.
 * 		La m�thode fromText s'applique sur une String (on ne peut donc pas la cr�er comme m�thode
 * 		d'instance de String). On doit alors la cr�er comme m�thode statique de Article.
 * 		La m�thode fromText liste explicitement les diff�rents cas possibles, il ne doit donc pas y
 * 		en avoir d'autres. L'interface doit �tre ferm�e.
 * 
 * Q4/ Pour cr�er un �crivain sur un fichier texte � partir d'un Path, on utilise la m�thode
 * 		newBufferedWriter de la classe Files.
 * 		Pour garantir que la ressource syst�me est bien lib�r�e, il faut utiliser un try().
 * 		Pour g�rer l'exception d'entr�e/sortie, il ne faut pas oublier de mentionner la clause
 * 		throws.
 * 		L'int�r�t de d�finir la m�thode load comme m�thode d'instance est que l'on peut charger un
 * 		fichier de sauvegarde � la suite d'un catalogue qui n'est pas vide.
 */
