package algos;

class GreedyLemondeStand {

	public static void main(String[] args) {
		int[] bills = new int[] { 5, 5, 10, 10, 20 };
		System.out.println(new GreedyLemondeStand().lemonadeChange(bills));
	}

	public boolean lemonadeChange(int[] bills) {
		int[] changeDraw = new int[21];
		if (bills.length == 0)
			return true;
		changeDraw[bills[0]]++;
		for (int i = 1; i < bills.length; i++) {
			int payment = bills[i];
			changeDraw[payment]++;
			if (payment == 5) continue;
			if (payment == 10) {
				if (changeDraw[5] < 1) return false;
				changeDraw[5]--;
				continue;
			}
			if (changeDraw[10] > 0 && changeDraw[5] > 0) {
				changeDraw[10]--;
				changeDraw[5]--;
				continue;
			}
			if (changeDraw[5] > 2) {
				changeDraw[5] -= 3;
				continue;
			}
			return false;
		}
		return true;
	}
}