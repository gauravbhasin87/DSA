package wepay;

import java.util.HashSet;
import java.util.Set;

public class PairSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {6, 6, 3, 9, 3, 5, 1};
		int count = findCountPairs(array, 12);
		System.out.println(count);
	}
	
	public static int findCountPairs(int[] array, int k){
		int count = 0;
		Set<Integer> set = new HashSet<Integer>();
		int length = array.length;
		for(int i=0;i<length;i++){
			if(set.contains(k-array[i])){
				count++;
			}
			else
				set.add(array[i]);
		}
		return count;
	}

}
