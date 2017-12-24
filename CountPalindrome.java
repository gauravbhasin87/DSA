package vmWare;

public class CountPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "aaa";
		char [] array = s.toCharArray();
		int count  = 0 ;
		for(int i=0;i<s.length();i++){
			count += countPalindrom(array, i, i);
		}
		
		for(int i=0;i<s.length()-1;i++){
			count += countPalindrom(array, i, i+1);
		}

		System.out.println(count);	
	}
	
	static int countPalindrom(char[] array, int i,int j){
		int count = 0;
		while(i>=0 && j<array.length){
			if(array[i] == array[j]){
				count++;
				i--;
				j++;
			}
			else{
				break;
			}
		}
		
		return count;
	}

}
