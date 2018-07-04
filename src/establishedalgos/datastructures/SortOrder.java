package establishedalgos.datastructures;

public enum SortOrder {
	ASCENDING(-1),
	DESENDING(1);
	
	int order;
	SortOrder(int order){
		this.order = order;
	}
	
	public int getOrder() {
		return this.order;
	}
}
