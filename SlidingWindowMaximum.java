import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {12, 1, 78, 90, 57, 89, 56};
		int result [] = slidingWindowMax(arr, 3);
		System.out.println(Arrays.toString(result));
		

	}
	
	static int [] slidingWindowMax(int[] arr, int k){
		int length = arr.length;
		int result[] = new int[length-k+1];
		Deque<Integer> dq = new ArrayDeque<>();
		for(int i=0;i<length;i++){
			if(!dq.isEmpty() && dq.peekFirst() == i-k){
				dq.removeFirst(); 
			}
			
			while(!dq.isEmpty() && arr[dq.peekLast()]<=arr[i]){
				dq.removeLast();
			}
			dq.addLast(i);
			if(i>=k-1){
				result[i-k+1] = arr[dq.peekFirst()];
				System.out.println( "result " + (i-k+1) + "  "+ result[i-k+1]);
			}
		}
		
		return result;
	}

}
