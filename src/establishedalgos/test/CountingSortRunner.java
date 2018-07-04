package establishedalgos.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import establishedalgos.Algos;
import establishedalgos.datastructures.SortOrder;

public class CountingSortRunner {
	
	public static void main(String args[]) {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(12, 9, 4, 1, 1, 12, 4, 5, 2, 1, 7)); 
		System.out.println(Algos.countingSort(list, SortOrder.ASCENDING));
	}
}
