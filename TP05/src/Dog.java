import java.util.Objects;

public class Dog implements Animal {
	
	private static final double COEFF = 7.3;
	private String name;
	private int weight;
	private Shelter shelt = null;
	
	public Dog (String name, int weight) {
		Objects.requireNonNull(name);
		if (weight < 0) {
			throw new IllegalArgumentException("Poid négatif");
		}
		this.name = name;
		this.weight = weight;
	}
	
	public String name () {return name;}
	public int weight () {return weight;}
	public Shelter shelt () {return shelt;}
	
	@Override
	public boolean equals (Object o) {
		return o instanceof Dog d && name.equals(d.name()) && weight == d.weight();
	}
	
	@Override
	public int hashCode () {
		return name.hashCode() ^ Integer.hashCode(weight);
	}
	
	@Override
	public String toString () {
		return "Dog : " + name + " : " + weight;
	}
	
	
	
	
	
	
	
	@Override
	public void addShelter (Shelter shelter) {
		if (shelt == null) {
			shelt = shelter;
		}
		else {
			throw new IllegalStateException (name + " est déjà affecté à un refuge.");
		}
	}
	
	@Override
	public void delShelter () {
		shelt = null;
	}
	
	public double biscuits () {
		return weight * COEFF;
	}
	
	public void isNowKing () {
		if (shelt == null) {
			throw new IllegalStateException(name + " n'est pas dans un refuge.");
		}
		shelt.king = this;
	}
	
	
	
}
