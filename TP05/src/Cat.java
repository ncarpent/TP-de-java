import java.util.Objects;

public record Cat(String name, double biscuits) implements Animal {
	
	public Cat {
		Objects.requireNonNull(name);
		if (biscuits < 0) {
			throw new IllegalArgumentException("Quantité de croquettes négative.");
		}
	}
	
	@Override
	public String toString () {
		return "Cat : " + name + " (" + biscuits + ")";
	}
	
	/*
	public static void main (String[] args) {
		var gar = new Cat("garfield", 120);
		System.out.println(gar);
	}
	*/
	
}
