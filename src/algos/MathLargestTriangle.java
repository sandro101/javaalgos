package algos;

public class MathLargestTriangle {

    public double largestTriangleArea(int[][] points) {
    	double ma = Integer.MIN_VALUE;
    	for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				for (int k = 0; k < points.length; k++) {
					int[] c1 = points[i];
					int[] c2 = points[j];
					int[] c3 = points[k];	
                    double a = Math.abs(c1[0] * (c2[1] - c3[1]) + c2[0] * (c3[1] - c1[1]) + c3[0] * (c1[1] - c2[1]));
					ma = Math.max(ma, a);
				}
			}
		}
    	return ma/2;
    }
};