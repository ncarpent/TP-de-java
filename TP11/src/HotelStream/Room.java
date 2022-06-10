package HotelStream;

import java.util.Objects;

public record Room (String name, int floor, long price)
{
	public Room
	{
		Objects.requireNonNull(name, "name is null");
		if (floor < 0)
		{
			throw new IllegalArgumentException("floor < 0");
		}
		if (price <= 0)
		{
			throw new IllegalArgumentException("price <= 0");
		}
	}
}
