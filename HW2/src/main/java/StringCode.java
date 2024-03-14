import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		int max = 1;
		int cnt = 1;
		if (str.equals("")){
			return 0;
		}
		for(int i=0;i<str.length()-1;++i){
			if(str.charAt(i)==str.charAt(i+1)) {
				cnt++;
			}
			else {
				max = Math.max(max,cnt);
				cnt = 1;
			}
		}
		max = Math.max(max,cnt);
		return max; // YOUR CODE HERE
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		String neww = new String();
		for(int i = 0; i< str.length(); ++i){
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9' && i!=str.length()-1){
				int k = (int) str.charAt(i) - 48;
				while(k>0){
					k--;
					neww = neww + str.charAt(i+1);
				}
			}
			else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				continue;
			}
			else {
				neww = neww + str.charAt(i);
			}
		}
		return neww; // YOUR CODE HERE
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		Set<String> seta = new HashSet<>();
		Set<String> setb = new HashSet<>();
		for(int i=0;i<=a.length()-len;++i){
			seta.add(a.substring(i,i+len));
		}
		for(int i=0;i<=b.length()-len;++i){
			setb.add(b.substring(i,i+len));
		}
		for (String ten : seta){
			for(String tenz : setb){
				if(tenz.equals(ten)){
					return true;
				}
			}
		}
		return false; // YOUR CODE HERE
	}
}
