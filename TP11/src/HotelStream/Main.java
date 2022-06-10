package HotelStream;

import java.util.List;

public class Main
{
	
	public static void main (String[] args)
	{
		var hotel = new Hotel("paradisio", List.of(
					new Room("blue", 100, 100),
					new Room("yellow", 110, 200),
					new Room("fuchsia", 120, 300),
					new Room("red", 100, 200),
					new Room("green", 100, 200)
					));
		
		// Question 1
		System.out.println("Question 1 :");
		System.out.println(hotel);
		System.out.println();
		
		// Question 2
		System.out.println("Question 2 :");
		System.out.println(hotel.roomInfo());  // blue, yellow, fuchsia, red, green
		System.out.println();
		
		// Question 3
		System.out.println("Question 3 :");
		System.out.println(hotel.roomInfoSortedByFloor());  // blue, red, green, yellow, fuchsia
		System.out.println();
		
		// Question 4
		System.out.println("Question 4 :");
		System.out.println(hotel.averagePrice());  // 200.0
		System.out.println();
		
		// Question 5
		System.out.println("Question 5 :");
		System.out.println(hotel.roomForPrice1(250));  // Optional[Room[name=yellow, floor=110, price=200]]
		System.out.println();
		
		// Question 6
		System.out.println("Question 6 :");
		System.out.println(hotel.roomForPrice2(250));  // Optional[Room[name=yellow, floor=110, price=200]]
		System.out.println();
		
		// Question 7
		System.out.println("Question 7 :");
		var hotel2 = new Hotel("fantastico", List.of(
				new Room("queen", 1, 200),
				new Room("king", 1, 500)
				));
		System.out.println(hotel.expensiveRoomNames(List.of(hotel, hotel2)));  // [fuchsia, yellow, king, queen]
		System.out.println();
		
		// Question 8
		System.out.println("Question 8 :");
		System.out.println(hotel.roomInfoGroupedByFloor());   // {100=[Room[name=blue, ...], Room[name=red, ...], Room[name=green, ...]], 120=[Room[name=fuchsia, ...]], 110=[Room[name=yellow, ...]]}
		System.out.println();
		
		// Question 9
		System.out.println("Question 9 :");
		System.out.println(hotel.roomInfoGroupedByFloorInOrder());  // {100=[Room[name=blue, ...], Room[name=red, ...], Room[name=green, ...]], 110=[Room[name=yellow, ...]], 120=[Room[name=fuchsia, ...]]}
		System.out.println();
	}
	
}
