package algos;

class MathExcelNumber {
	
	public static void main(String[] args) {
		System.out.println(new MathExcelNumber().titleToNumber("AB"));
	}

    public int titleToNumber(String s) {
        return s.chars().reduce(0, (acc, x) -> acc * 26 + x-'A' + 1);
    }

}