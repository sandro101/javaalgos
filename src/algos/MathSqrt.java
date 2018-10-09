package algos;

class MathSqrt {
	
	public static void main(String[] args) {
		System.out.println(new MathSqrt().mySqrt(10));
	}

    public int mySqrt(int x) {
    	if(x == 0) return 0;      
    	long i = 1;
        while(true) {
        	if ((i + 1) * (i + 1) > x) {
				return (int)i;
			}
        	i++;
        }
    }
}