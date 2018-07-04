package establishedalgos.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import establishedalgos.Algos;

public class QuickSortRunner {
	
	public static void main(String args[]) {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(12, 9, 4, 5, 2, 1, 7)); 
		Algos.quickSort(list);
		System.out.println(list);	
	}
}
