package algos;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class UnsortedLinkedListSorter {

	public LinkedList<String> removeDupes(LinkedList<String> ll) {
		Iterator<String> iter = ll.iterator();
		Set<String> dupes = new LinkedHashSet<String>();
		while(iter.hasNext()) {
			Iterator<String> iter2 = ll.iterator();
			while(iter2.hasNext()) {
				String val = iter.next();
				if(val.equals(iter2.next())) {
					dupes.add(val);					
				}
			}
		}
		ll.removeAll(dupes);
		ll.addAll(dupes);
		return ll;		

	};

	public String getNthElementFromEnd(LinkedList<String> ll, int n) throws IllegalAccessException{
		int size = ll.size();
		//size = 5, 2 from last I want the 3 element. 0, 1, 2, 3, 4		
		int requiredPosition = size - n;
		Iterator<String> iter = ll.iterator();
		int i = 1;
		while(iter.hasNext()) {
			if(i == requiredPosition) {
				return(iter.next());
			}
			iter.next();
			i++;
		}
		throw new IllegalAccessException(String.format("No value at position, %d", n));
	}

	public LinkedList<Integer> add(LinkedList<Integer> l1, LinkedList<Integer>l2){
		//Head is the 1s, tail is the largest
		if(l1.size() > l2.size()) {
			return(sum(l2, l1));	
		}
		else {
			return(sum(l1, l2));
		}		
	}

	private LinkedList<Integer> sum(LinkedList<Integer> sm, LinkedList<Integer> lg) {
		Iterator<Integer> smIter = sm.iterator();
		Iterator<Integer> lgIter = lg.iterator();
		LinkedList<Integer> answer = new LinkedList<Integer>();
		//iterate over the smaller number means we don't have to check the other "number"
		Integer overspill = 0;
		while(smIter.hasNext()) {
			Integer sum = smIter.next() + lgIter.next() + overspill;			
			answer.addLast(sum % 10);
			overspill = sum >= 10 ? 1 : 0;
		}
		while(lgIter.hasNext()) {
			Integer sum = lgIter.next() + overspill;
			answer.addLast(sum % 10);
			overspill = sum >= 10 ? 1 : 0;
		}
		if(overspill > 0) {
			answer.addLast(overspill);
		}
		return answer;
	}
}


