public record Point (int x, int y) {
	public static void main (String[] args) {
		int nb1 = Integer.parseInt(args[0]), nb2 = Integer.parseInt(args[1]);
		System.out.print("x : ");
		System.out.print(nb1);
		System.out.print(", y : ");
		System.out.println(nb2);
		Point pt = new Point(nb1, nb2);
		pt.afficher();
		System.out.print("distance à l'origine : ");
		System.out.println(pt.distance(new Point (0, 0)));
	}
	
	public void afficher () {
		System.out.print("Point[x=");
		System.out.print(x);
		System.out.print(", y=");
		System.out.print(y);
		System.out.print("]\n");
	}
	
	public double distance (Point autre) {
		return Math.sqrt(sqr(x - autre.x) + sqr(y - autre.y));
	}
	
	public static int sqr (int nb) {
		return nb*nb;
	}
}