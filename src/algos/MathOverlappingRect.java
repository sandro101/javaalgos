package algos;

class MathOverlappingRect {
	
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return isOverlap(rec1, rec2) || isOverlap(rec2, rec1);       
    }

	private boolean isOverlap(int[] rec1, int[] rec2) {
		int top1 = rec1[3];
        int bottom1 = rec1[1];
        int left1 = rec1[0];
        int right1 = rec1[2];
        
        int top2 = rec2[3];
        int bottom2 = rec2[1];
        int left2 = rec2[0];
        int right2 = rec2[2];
        
        return !(bottom1 >= top2 || left1 >= right2 || top1 <= bottom2 || right1 <= left2);

	}   
    
}