package algos;

public class TheAirTripDiv2 {
	public int find(int[] flights, int fuel) {
		int numberOfFlights = 0;
		for(int flightDistance: flights) {
			if(fuel >= flightDistance) {
				numberOfFlights++;
				fuel -= flightDistance;
			}else {
				return numberOfFlights;
			}
		}
		return numberOfFlights;
	}
}
