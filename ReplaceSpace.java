import java.util.Arrays;

public class ReplaceSpace {
	
	public static void replaceSpace(char [] ar){
		int length = ar.length;
		int countSpace = 0;
		for(int i=0;i<length;i++){
			if(ar[i] == ' '){
				countSpace++;
			}
		}
		int newLength = length + 2*countSpace;
		char [] newStr = new char[newLength];
		//ar[newLength] = '\0';
		int j=0;
		for(int i=0;i<newLength;){
			if(ar[j] == ' '){
				newStr[i] = '%';
				newStr[i+1] = '2';
				newStr[i+2] = '0';
				i += 3;
				j++;
			}
			else{
				newStr[i] = ar[j];
				j++;
				i++;
			}
		}
		System.out.println(Arrays.toString(newStr));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a b c d";
		replaceSpace(s.toCharArray());
	}

}
