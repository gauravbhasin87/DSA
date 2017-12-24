
public class LargestContiguousSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int a[] = {-2, -3, -4, -1, -2, -1, -5, -3};
		 findSum(a);
	}
	
	static void findSum(int [] ar){
		int curSum = ar[0];
		int maxSum = ar[0];
		for(int i=0;i<ar.length;i++){
			curSum = Math.max(ar[i], ar[i]+curSum);
			maxSum = Math.max(maxSum, curSum );
		}
		
		System.out.println(maxSum);
	}

}
