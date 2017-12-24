import java.util.HashSet;
import java.util.Set;

public class LongestUniqueSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaaaaaa";
		System.out.println(findLongestUniqueSubString(s));

	}
	
	static int findLongestUniqueSubString(String str){
		char [] ar = str.toCharArray();
		Set<Character> set = new HashSet<>();
		int curStart = 0;
		int curEnd = 0;
		int maxLength = 0;
		int curLength = 0;
		int size = ar.length;
		while(curEnd<size){
			if(set.add(ar[curEnd])){
				curLength = curEnd - curStart + 1;
				curEnd++;
				maxLength = Math.max(maxLength, curLength);
			}
			else{
				set.remove(ar[curStart]);
				curStart++;
			}
		}
		
		return maxLength;
	}

}
