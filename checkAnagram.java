package Hyland;

public class checkAnagram {
	
	static boolean checkAnagram(String s1, String s2){
		 if(s2.length() != s1.length())
             return false;
        char [] a1 = s1.toLowerCase().toCharArray();
    char [] a2 = s2.toLowerCase().toCharArray();
    int length = s1.length();
    int[] array = new int[26];
    for(int i=0;i<length;i++){
          array[a1[i]-'a']++;
          array[a2[i]-'a']--;
    }
    for(int i=0;i<length;i++){
        if(array[i]!=0)
             return false;
    }  
    return true;

	}
	
	
	public static void main(String arg[]){
		System.out.println(checkAnagram("MEAT", "TEsAM"));
	}
}
