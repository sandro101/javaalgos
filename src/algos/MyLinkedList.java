package algos;

public class MyLinkedList {

	public Entry head = new Entry();
	public class Entry {
		public String data;
		public Entry next = null;
		public Entry(){}		
		public Entry(String data){
			this.data = data;
		}
	}
	
	public Entry getHead() {
		return this.head;
	}

	public void addEntryToTail(String data) {
		if(head.data == null) {
			head = new Entry(data);
		}
		else {
			//point at the head of the list
			Entry temp = head;
			//work down to point at the bottom of the list
			while(temp.next != null) {temp = temp.next;}
			//then when at the bottom of the list point its "next pointer" at the new entry making it the new tail
			temp.next = new Entry(data);
		}
	}
	
	public void removeEntry(Entry element) {
		if(element.next != null) {
			//notice that we set the data first, if you set "next" first
			//we basically move the pointer and then set the incorrect data
			element.data = element.next.data;
			element.next = element.next.next;
		}
		else {
			element.data = null;
		}
	}
	
	public String getFirstValue() {
		return head.data;
	}

	public void removeFirst(String data) {
		//point the cursor at the head of the list
		Entry cursor = head;
		//whilst the cursor isn't pointing at an entry which is pointing at 
		//nothing (i.e the end of the list) then continue
		while(cursor.next != null) {
			if(data.equals(cursor.next.data)) {
				//if we end up pointing at an entry who's data is same as what we want to remove
				//then re-point that objects "next pointer" to the next objects "next pointer"
				//important to recognise here that we are not re-pointing the cursor in this step
				//we are actually re-pointing the pointer on the entry 
				cursor.next = cursor.next.next;
				break;
			}
			else {
				cursor = cursor.next;
			}
		}
	}
}


