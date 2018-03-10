package leetcode;

// https://leetcode.com/problems/custom-sort-string/description/
public class CustomSortString {
	
    public String customSortString(String S, String T) {
    	int[] counters = new int[26];
    	for (int i = 0; i < counters.length; i++) {
    		counters[i] = 0;
    	}
    	for (int i = 0; i < T.length(); i++) {
    		counters[(int)(T.charAt(i) - 'a')]++;
    	}
    	StringBuilder builder = new StringBuilder();
    	for (int i = 0; i < S.length(); i++) {
    		for (int j = 0; j < counters[(int)S.charAt(i) - (int)'a']; j++) {
    			builder.append(S.charAt(i));
    		}
    		counters[(int)S.charAt(i) - (int)'a'] = 0;
    	}
    	for (int i = 0; i < 26; i++) {
    		for (int j = 0; j < counters[i]; j++) {
    			builder.append((char)('a' + i));
    		}
    	}
    	return builder.toString();
    }
	
    //"hucw"
    //"utzoampdgkalexslxoqfkdjoczajxtuhqyxvlfatmptqdsochtdzgypsfkgqwbgqbcamdqnqztaqhqanirikahtmalzqjjxtqfnh"
	public static void main(String[] args) {
		System.out.println(new CustomSortString().customSortString("hucw", "utzoampdgkalexslxoqfkdjoczajxtuhqyxvlfatmptqdsochtdzgypsfkgqwbgqbcamdqnqztaqhqanirikahtmalzqjjxtqfnh"));
		
	}

}
