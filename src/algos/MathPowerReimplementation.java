package algos;

class MathPowerReimplementation {
	
	public static void main(String[] args) {
		System.out.println(new MathPowerReimplementation().myPow(0.86429, 18));
	}

    public double myPow(double x, int n) {
    	long bigN = n;
    	if(x == 1) return 1;
    	if(x == -1 && n % 2 == 0) {
    		return 1;
    	}
    	if(x == -1 && n % 2 == 1) {
    		return -1;
    	}
    	if(n > 0) {
        	double res = x;
        	long i = 1;
        	while(i < bigN) {
                if(res == 0) return 0;
        		if(i + i < bigN) {
        			res = res * res;        			
        			i = i + i;
        			System.out.println("My Calc  : " + res + " for power: " + i);
        			System.out.println("Real Calc: " + Math.pow(x, i) + " for power: " + i);
        		} else {
        			res = res * x;
        			i++;
        		}
        	}
            return res;
    	}
    	if(n < 0) {
    		double res = 1/x;
    		long i = 1;
        	while(i < Math.abs(bigN)) {
                if(res == 0) return 0;
        		if(i + i < Math.abs(bigN)) {
        			res = res * res;
        			i = i + i;
        			System.out.println("My Calc  : " + res + " for power: " + i);
        			System.out.println("Real Calc: " + Math.pow(x, i) + " for power: " + i);
        		} else {
        			res = res / x;
        			i++;
        		}
        	}
            return res;
    	}
        return 1;
    }	
}