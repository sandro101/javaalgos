package algos;

class MathPowerReimplementation {
	
	// https://leetcode.com/problems/powx-n/description/
	
	public static void main(String[] args) {
		System.out.println(new MathPowerReimplementation().myPow(0.86429, 18));
	}

	//Solution as follows:
	//While ever it is possible to multiply the result by itself, in effect squaring it,
	//do this and add the power to itself as this is how powers are combined when multiplied
	//together. Once adding the powers together creates a number larger than the power we
	//are raising to we have no choice but to continue the rest of the algo by just
	//multiplying over and over by the value we are raising to the power
	
	//Similar solution holds true for negative powers but with division
	
    public double myPow(double x, int n) {
    	long longN = n;
    	if(x == 1) return 1;
    	if(x == -1 && n % 2 == 0) {
    		return 1;
    	}
    	if(x == -1 && n % 2 == 1) {
    		return -1;
    	}
    	if(n > 0) {
        	double res = x;
        	long power = 1;
        	while(power < longN) {
                if(res == 0) return 0;
        		if(power + power < longN) {
        			res = res * res;        			
        			power = power + power;
        			System.out.println("My Calc  : " + res + " for power: " + power);
        			System.out.println("Real Calc: " + Math.pow(x, power) + " for power: " + power);
        		} else {
        			res = res * x;
        			power++;
        		}
        	}
            return res;
    	}
    	if(n < 0) {
    		double res = 1/x;
    		long i = 1;
        	while(i < Math.abs(longN)) {
                if(res == 0) return 0;
        		if(i + i < Math.abs(longN)) {
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