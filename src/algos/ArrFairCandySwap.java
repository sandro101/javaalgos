package algos;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class ArrFairCandySwap {

    public int[] fairCandySwap(int[] a, int[] b) {
        int tsa = Arrays.stream(a).sum();
        int tsb = Arrays.stream(b).sum();
        int d = (tsa - tsb)/2;
        Set<Integer> setA = Arrays.stream(a).boxed().collect(Collectors.toSet());
        for (int i = 0; i < b.length; i++) {
			if(setA.contains(d + b[i]))
				return new int[] {d + b[i], b[i]};
		}
        return null;
    }
}