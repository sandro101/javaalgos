package establishedalgos.test;

class Runner {

	public static void main(String[] args) {
		//1560834904 - Richard
		//1533726144 - Lousie
		System.out.println(counterGame(1560834904));
	}
	
	static String counterGame(long n) {
        if(n == 1) return "Richard";
        int counter = 0;
        while(n > 1){
            long bitDiv2 = n >> 1;
            if(bitDiv2 == n/2d){
            	n = bitDiv2;
                counter++;
            } else {
                int pow2Pos = 0;
                long t = n;
                while(t > 0){
                    t = t >> 1;
                    pow2Pos++;
                }
                counter++;
                n = n - (1 << (pow2Pos - 1));
            }
        }  
        return (counter % 2 == 0) ? "Richard" : "Louise";
    }
}
