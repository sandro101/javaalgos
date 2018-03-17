package algos.test;

import algos.MyLinkedList;

public class MyLinkedListTest {

	public static void main(String[] args) {		
		addToTailAndTestRemove();
		removeWithOnlyAccessToNode();
	}

	private static void removeWithOnlyAccessToNode() {
		MyLinkedList myLinkedList = buildSimpleList();	
		myLinkedList.removeEntry(myLinkedList.getHead().next.next);
		System.out.println(myLinkedList.getFirstValue());
	}

	private static void addToTailAndTestRemove() {
		MyLinkedList myLinkedList = buildSimpleList();		
		myLinkedList.removeFirst("4");
		System.out.println(myLinkedList.getFirstValue());
	}

	private static MyLinkedList buildSimpleList() {
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.addEntryToTail("1");
		myLinkedList.addEntryToTail("2");
		myLinkedList.addEntryToTail("3");
		myLinkedList.addEntryToTail("4");
		myLinkedList.addEntryToTail("5");
		myLinkedList.addEntryToTail("4");
		return myLinkedList;
	}
}
