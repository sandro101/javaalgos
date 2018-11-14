package algos;

class StringConvertToInt {

	// 7 on leet code
	
	public int myAtoi(String s) {  
        if(s.length() == 0) return 0;
        double sol = 0;
        int i = 0;
        int len = s.length();
        while(s.charAt(i) == ' ') {
            i++;
            if(i >= len) return 0;
        }        
        char c = s.charAt(i);
        int sign = 0;
        if(c - '0' >= 0 && c - '0' <= 9 || c == '-' || c == '+') {
            if(s.charAt(i) == '-') {
                sign = -1;
                i++;
            } else {
                if(s.charAt(i) == '+') {
                    sign = 1;
                    i++;
                } else {
                    sign = 1;
                }                   
            }
         
        } else {
            return 0;
        }   
        while(i < len && s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
            sol *= 10;
            sol += (s.charAt(i) - '0');
            i++;
        }
        sol = sol * sign;
        if(sol > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(sol < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) sol;
    }

}