import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] ar = {1,2,3,4,5,6,7,8,5,5};
	//	int [] result = twoSumSorted(ar, 5);
	//	int [] result1 = twoSumUnsorted(ar,10);
		//System.out.println(Arrays.toString(result));
		//System.out.println(Arrays.toString(result1));
		findAllPairsSum(ar, 10);
	}
	
	public static int[] twoSumSorted(int [] ar, int target){
		int start = 0;
		int end = ar.length-1;
		while(start<end){
			int sum = ar[start] + ar[end];
			if(sum<target)
				start++;
			else if(sum>target)
				end--;
			else
				return new int[]{start,end};
		}
		return null;
	}
	
	public static int[]	twoSumUnsorted(int [] ar, int target){
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int length = ar.length;
		for(int i=0;i<length;i++){
			int num = ar[i];
			if(map.containsKey(num)){
				int index1 = map.get(num);
				System.out.println(ar[index1] + " "+ ar[i]);
				//return new int[]{index1, i};
			}
			else{
				map.put(target - num, i);
			}
		}
		
		return null;
	}
	
	public static void findAllPairsSum(int [] arr, int target){
		//Map<Integer,Integer> map = new HashMap<>();
		int length = arr.length;
		Set<Integer> set = new HashSet<>();
		
		for(int i=0;i<length;i++){
			int num = arr[i];
			if(set.contains(num)){
				System.out.println(num  +"  " + (target-num));
			}
			else{
				set.add(target-num);
			}
		}
			
			
//			if(map.containsKey(num)){
//				int count = map.get(num);
//				if((num == target - num) && count == 2)
//					System.out.println(num + " " + (target - num) );
//				else if( (target-num) != num)
//					System.out.println(num + " " + (target - num) );
//				
//				map.put(target-num, count+1);
//			}
//			else{
//				map.put(target-num, 1);
//			}
			
		}
		
	

}
