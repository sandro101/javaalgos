package algos;

class StringToLowerCase {
	
	public static void main(String[] args) {
		System.out.println("[" + new StringToLowerCase().toLowerCase("HeLlO") + "]");
	}

	    public String toLowerCase(String str) {
	    	char[] lower = new char[str.length()];
	    			
	    	str.toCharArray().toString();
	        for (int i = 0; i < str.length(); i++) {
	        	char c = str.charAt(i);      
	        	if(c <= 90 && c >= 65) {
	        		lower[i] = (char) (c - 'A' + 'a');		
	        	} else {
	        		lower[i] = c;
	        	}
	        		
			}
	        return new String(lower);
	    }

}