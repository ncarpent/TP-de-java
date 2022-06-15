import java.util.ArrayList;

public class Shelter {
	
	public ArrayList<Animal> shelt;
	public Dog king;
	
	
	public Shelter () {
		shelt = new ArrayList<Animal>();
	}
	
	
	
	public void add (Animal anim) {
		anim.addShelter(this);
		shelt.add(anim);
	}
	
	public ArrayList<Animal> removeAll (String name) {
		var retour = new ArrayList<Animal>();
		var iter = shelt.iterator();
		while (iter.hasNext()) {
			var val = iter.next();
			if (val.name().equals(name)) {
				val.delShelter();
				iter.remove();
				retour.add(val);
			}
		}
		return retour;
	}
	
	@Override
	public String toString () {
		StringBuilder retour = new StringBuilder("Refuge : \n");
		for (var anim : shelt) {
			retour.append("| ").append(anim.toString()).append(king != null && king.equals(anim) ? " : King" : "").append("\n");
			//retour.append(dog.name()).append(" : ").append(dog.weight()).append("\n");
		}
		return retour.append("|__\n").toString();
	}
	
	
	public double biscuits () {
		double cost = 0.;
		for (var anim : shelt) {
			cost += anim.biscuits();
		}
		return cost;
	}

	
	
	public static void afficher (ArrayList<Animal> liste) {
		System.out.println("chiens renvoyés : ");
		for (var anim : liste) {
			System.out.println(anim.toString() + " ; ");
			//System.out.println(element.name() + " : " + element.weight() + " ; ");
		}
		System.out.println();
	}
	
}

/*
 * Exercice 2 :
 * 
 * Q3/ Le champ shelt de Dog peut désormais varier au cours du temps. Il faut donc changer le Record
 * 		en Class. C'est un gros changement car cela implique de devoir réimplémenter les méthodes
 * 		equals et hashCode.
 */
