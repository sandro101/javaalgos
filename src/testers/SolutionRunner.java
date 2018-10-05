package testers;

class SolutionRunner {

	public static void main(String[] args) {
		int[] a = new int[]{100, 100, 50, 40, 40, 20, 10};
		int[] b = new int[]{278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436};
		System.out.println(Solution.nonDivisibleSubset(7, b));
		

	}
}