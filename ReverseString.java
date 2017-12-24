
public class ReverseString {
	
	static String reverse(String s){
		char [] ar = s.toCharArray();
		int end = s.length()-1;
		int start = 0;
		while(start<end){
			swap(ar,start,end);
			start++;
			end--;
		}
		
		return new String(ar);
	}
	
	static String reverseRecursively(String s){
		if(s.equals(""))
			return "";
		return reverseRecursively(s.substring(1)) + s.charAt(0);
	}
	
	static void swap(char [] ar, int i, int j){
		char temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}
	
	public static void main(String[] arg){
		String s = "abcd";
		System.out.println(reverse(s));
		System.out.println(reverseRecursively(s));
		System.out.println(s);
	}
}
