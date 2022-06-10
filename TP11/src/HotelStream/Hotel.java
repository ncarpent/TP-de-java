package HotelStream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Hotel
{
	// Question 1
	private final String name;
	private final List<Room> rooms;
	
	public Hotel (String name, List<Room> roomlist)
	{
		Objects.requireNonNull(name);
		Objects.requireNonNull(roomlist);
		this.name = name;
		rooms = List.copyOf(roomlist);
	} // Hotel pourraît aussi être un record...
	
	public String toString ()
	{
		return "Hotel : " + name + "\n |-- rooms : " + rooms;
	}
	
	// Question 2
	public String roomInfo ()
	{
		return rooms.stream().map(Room::name).collect(Collectors.joining(", "));
	}
	
	// Question 3
	public String roomInfoSortedByFloor ()
	{
		return rooms.stream().sorted(Comparator.comparingInt(Room::floor)).map(Room::name).collect(
				Collectors.joining(", "));
	}
	
	// Question 4
	public double averagePrice ()
	{
		return rooms.stream().mapToLong(Room::price).average().orElse(Double.NaN);
	}
	
	// Question 5
	public Optional<Room> roomForPrice1 (long p)
	{
		return rooms.stream().sorted(Comparator.comparingLong(Room::price).reversed()).filter(
				r -> (r.price()<=p)).findFirst();
	}
	
	// Question 6
	public Optional<Room> roomForPrice2 (long p)
	{
		return rooms.stream().filter(r -> (r.price()<=p)).max(Comparator.comparingLong(Room::price));
	}
	
	// Question 7
	public List<String> expensiveRoomNames (List<Hotel> hotels)
	{
		return hotels.stream().flatMap(h -> h.rooms.stream().sorted(
				Comparator.comparingLong(Room::price).reversed()).limit(2).map(Room::name)).collect(
						Collectors.toList());
	}
	
	// Question 8
	public Map<Integer, List<Room>> roomInfoGroupedByFloor ()
	{
		return rooms.stream().collect(Collectors.groupingBy(Room::floor, Collectors.toList()));
	}
	
	// Question 9
	public Map<Integer, List<Room>> roomInfoGroupedByFloorInOrder ()
	{
		return rooms.stream().collect(Collectors.groupingBy(Room::floor, TreeMap::new, Collectors.toList()));
	}
}

/*
 * Exercice 2 :
 * 
 * Q6/ L'implémentation de roomForPrice est meilleure dans la deuxième version.
 * 		En effet, sorted est appliqué avant le filtre (donc à plus d'éléments) dans la première
 * 		version.
 * 		De plus, le calcul du max est moins complexe que l'algorithme de tri.
 * 		
 * 
 * Q8/ Le type de retour de la méthode roomInfoGroupedByFloor est Map<Integer, List<Room>>.
 * 
 */
