package algos.test;

import algos.TheAirTripDiv2;

public class TheAirTripDiv2Test {
	public static void main(String[] args) {
		int[] flights = new int[] {1, 2, 3, 4, 5, 6, 7};
		int fuel = 10;
		System.out.println(new TheAirTripDiv2().find(flights, fuel));
	}
}
