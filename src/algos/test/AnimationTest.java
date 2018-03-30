package algos.test;

import algos.Animation;

public class AnimationTest {

	public static void main(String[] args) {
		String init = "RR..LRL";
		int speed = 3;
		String[] result = new Animation().animate(speed, init);
		for(String s: result) {
			System.out.println(s);
		}
	}
}
