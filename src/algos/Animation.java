package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Animation {

	public String[] animate(int speed, String init) {
		String frame = init;
		List<String> animation = new ArrayList<String>();
		animation.add(init.replace("L", "X").replace("R", "X"));
		for (int i = 1; i < init.length(); i++) {
			if(!animation.get(i-1).contains("X")) {
				break;
			}
			frame = rotate(frame, speed);
			animation.add(frame.replace("L", "X").replace("R", "X").replace("D", "X"));	
		}
		String[] res = new String[animation.size()];
		res = animation.toArray(res);
		return res;
	}

	private String rotate(String frame, int speed) {
		int i = 0;
		char[] newLocations = new char[frame.length()];
		Arrays.fill(newLocations, ".".charAt(0));
		char[] chars = frame.toCharArray();
		for (char c : chars) {
			if (c == "R".charAt(0)) {
				moveRight(frame, speed, i, newLocations, c);
			}
			if (c == "L".charAt(0)) {
				moveLeft(speed, i, newLocations, c);
			}
			if (c == "D".charAt(0)) {
				moveLeft(speed, i, newLocations, "L".charAt(0));
				moveRight(frame, speed, i, newLocations, "R".charAt(0));
			}
			i++;
		}

		return new String(newLocations);
	}

	private void moveLeft(int speed, int i, char[] newLocations, char c) {
		if (i - speed >= 0) {
			if (newLocations[i - speed] != ".".charAt(0)) {
				newLocations[i - speed] = "D".charAt(0);
			} else {
				newLocations[i - speed] = c;
			}
		}
	}

	private void moveRight(String frame, int speed, int i, char[] newLocations, char c) {
		if (i + speed < frame.length()) {
			if (newLocations[i + speed] != ".".charAt(0)) {
				newLocations[i + speed] = "D".charAt(0);
			} else {
				newLocations[i + speed] = c;
			}
		}
	}
}
