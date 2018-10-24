package algos;

class StringRobotReturnsToOrigin {
	
	public static void main(String[] args) {
		System.out.println(new StringRobotReturnsToOrigin().judgeCircle("UDDLR"));
	}
	
    public boolean judgeCircle(String moves) {
        int y = 0;
        int x = 0;
        for (int i = 0; i < moves.length(); i++) {
			switch (moves.charAt(i)) {
			case 'U':
				y++;
				break;
			case 'D':
				y--;
				break;
			case 'R':
				x++;
				break;
			case 'L':
				x--;
				break;
			default:
				break;
			}
		}
        return (x == y && x == 0);
    }

}