
class RecursivelyRemoveAllAdjDuplicates {
	public static void main(String[] args) {
		String[] input = {"acaaabbbacddd", "acaaabbbcddd", "aaccdda", "aaccaddac", "aacddc", "mississipie"};

		for(String str : input) {
			String res = removeAdjDuplictes(str);
			System.out.println(str + " --> " + res);
		}
	}

	/* IDEA:

	    acaaabbbacdddd
	    -> acbbbacdddd
	    -> acacdddd
	    -> acac

	    accdddd

	    - see curr char with i + 1 char if they are equal then
	    run loop to remove the chars unil it ends or i !- curr char
	    - restart the loop with i - 1

	   special case : mississipie --> mpie
	*/
	static String removeAdjDuplictes(String str) {

	    int i = 0;
	    StringBuffer sb = new StringBuffer(str);
	    while(i < sb.length()) {
	        int nexti = -1;
    	    while(i < sb.length()) {
    	        if(i + 1 < sb.length() && sb.charAt(i) == sb.charAt(i+1)) {

    	            char ch = sb.charAt(i);

    	            while(i < sb.length() && sb.charAt(i) == ch)
    	                sb.deleteCharAt(i);

    	            if(nexti == -1)
    	                nexti = i > 0 ? i-1 : i;

    	            continue;
    	        }

    	        i++;
    	    }
    	    if(nexti > -1)
    	        i = nexti;
	    }

	    return sb.toString();
	}

}