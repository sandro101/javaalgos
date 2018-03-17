package algos;

public class ABBADiv1 {
	// A - > ABBA X
	// A - > BABA O
	public String canObtain(String initial, String finalValue) {
		if (finalValue.equals(initial)) {
			return "Possible";
		}
		boolean triedAddingA = false;
		while (finalValue.length() >= initial.length()) {
			if (triedAddingA) {				
				initial = addBAndReverse(initial);
				if(doesntContain(finalValue, initial)) return "Impossible";
				triedAddingA = false;
			} else {
				initial += "A";
				if(doesntContain(finalValue, initial)) {
					triedAddingA = true;
					initial = initial.substring(0, initial.length() - 1);
				}
			}
			if (finalValue.equals(initial)) {
				return "Possible";
			}
		}
		return "Impossible";
	}

	private boolean doesntContain(String finalValue, String initial) {
		return !finalValue.contains(initial) && !finalValue.contains(new StringBuilder(initial).reverse().toString());
	}

	private String addBAndReverse(String str) {
		return new StringBuilder(str.concat("B")).reverse().toString();
	}
}
