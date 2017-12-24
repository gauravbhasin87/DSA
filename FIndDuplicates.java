package Hyland;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FIndDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array [] = {1,2,9,4,5,5,6,4,3,6,7,7,8,3,1};
		int result [] = findDuplicates(array);
		System.out.println(Arrays.toString(result));

	}
	
	static int[] findDuplicates(int[] array){
		Set<Integer> uniques = new HashSet<Integer>();
		Set<Integer> duplicates = new HashSet<>();
		int length = array.length;
		for(int i=0;i<length;i++){
			if(!uniques.add(array[i])){
				duplicates.add(array[i]);
			}
		}
		int result[] = new int[duplicates.size()];
		int k=0;
		for(Integer i : duplicates){
			result[k] = i;
			k++;
		}
		
		return result;
	}
}
