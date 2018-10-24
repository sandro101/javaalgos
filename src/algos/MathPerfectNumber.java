package algos;

class MathPerfectNumber {

    public boolean checkPerfectNumber(int num) {
        if(num == 1) return false;
        if(num == 0) return false;
    	int sum = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
			if(num % i == 0) {
				sum += i;
				sum += num / i;
			}
		}        
        return sum - num == num;
    }

}