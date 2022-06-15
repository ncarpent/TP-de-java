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
	
	
}
