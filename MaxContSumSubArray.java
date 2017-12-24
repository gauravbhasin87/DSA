
public class MaxContSumSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println("Sum "+maxCSum(A));
	}
	
	static int maxCSum(int [] A){
		int s=0;
		int e=0;
		int start=0;
		int end=0;
		int curSum=0;
		int maxSum=0;
		int length = A.length;
		for(int i=0;i<length;i++){
			curSum = curSum + A[i];
			
			
			if(curSum<0){	
				s=i+1;
				curSum = 0;//Math.max(A[i], curSum);
			}
			
			if(curSum<A[i]){
				//curSum = 0;
			}
			else{
				e = i;
			}
			
			if(maxSum<curSum){
				start = s;
				end = e;
				maxSum = curSum;
			}
		}
		System.out.println(start);
		System.out.println(end);
		return maxSum;
	}

}
