package establishedalgos.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import establishedalgos.Algos;
import establishedalgos.datastructures.SortOrder;

public class RadixSortRunner {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(142, 943, 433, 144, 133, 122, 4, 5344, 2344, 34331, 7)); 
		System.out.println(Algos.radixSort(list, SortOrder.ASCENDING));
	}

}
