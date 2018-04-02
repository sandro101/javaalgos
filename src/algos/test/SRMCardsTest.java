package algos.test;

import algos.SRMCards;

public class SRMCardsTest {

	public static void main(String[] args) {
		int[] in = {493, 494, 495, 496, 497, 498};
		System.out.println(SRMCards.maxTurns(in));
		
		int[] in2 = {495, 496, 497, 499};
		System.out.println(SRMCards.maxTurns(in2));
		
		int[] in3 = {494, 495, 496, 497, 499};
		System.out.println(SRMCards.maxTurns(in3));
		
		int[] in4 = {493, 494, 495, 497, 499};
		System.out.println(SRMCards.maxTurns(in4));
	}
}
