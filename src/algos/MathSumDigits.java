package algos;

public class MathSumDigits {
	
	public static void main(String[] args) {
		System.out.println(new MathSumDigits().addDigits(38));
	}
	
    public int addDigits(int num) { 
    	while(num > 9) {
    		num = sum(num);
    	}
    	return num;
    }

	private int sum(int num) {
		return (num == 0) ? num : num % 10 + sum(num/10);
	}
};