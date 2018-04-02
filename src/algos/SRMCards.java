package algos;
import java.util.Arrays;

public class SRMCards {
	public static int maxTurns(int[] c){
		Arrays.sort(c);
		int count = 0;
		for(int i = 0; i < c.length; i++) {
			if(i + 1< c.length && c[i] + 1 == c[i+1]) {
				count++;
				i++;
			}
			else {
				count++;
			}
		}
		return count;
	}
}
