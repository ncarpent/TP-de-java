
public /*1*/ interface Animal /*2*/ {
	// 1 : sealed : pour une interface ferm�e (sous-types fix�s).
	// 2 : permits a, b, c... : liste tous les sous-types d'une interface ferm�e.
	
	public abstract String name();
	public abstract double biscuits();
	
	public default void addShelter (Shelter shelter) {}
	public default void delShelter () {}
}

/*
 * Exercice 2 :
 * 
 * Q2/ Pour qu'il n'y ai que des chiens et des chats dans le refuge, il faut ajouter le modificateur
 * 		de visibilit� "sealed" � l'interface Animal et ajouter une clause avec "permits" qui liste les
 * 		types autoris�s (Cat et Dog).
 *
 *
 */