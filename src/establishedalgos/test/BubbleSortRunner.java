package establishedalgos.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import establishedalgos.Algos;
import establishedalgos.datastructures.SortOrder;

public class BubbleSortRunner {
	
	public static void main(String args[]) {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(4, 5, 2, 1, 9)); 		
		System.out.println(Algos.bubbleSort(list, SortOrder.DESENDING));	
		System.out.println(Algos.bubbleSort(list, SortOrder.ASCENDING));
	}
}
