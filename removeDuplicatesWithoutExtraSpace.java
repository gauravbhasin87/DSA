import java.util.Arrays;

public class removeDuplicatesWithoutExtraSpace {

	static char[] removeDuplicates(char [] ar){
		int length = ar.length;
		int tail = 1;
		for(int i=1;i<length;i++){
			int j = 0;
			for(;j<tail;j++){
				if(ar[i] == ar[j])
					break;
			}
			if(j == tail){
				ar[tail] = ar[i];
				tail++;
			}
		}
		ar[tail] = '0';
		return ar;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abababcbcbcdhdhd";
		System.out.println(Arrays.toString(removeDuplicates(s.toCharArray())));
		
	}

}
