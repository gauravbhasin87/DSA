
public class FindMaximumInSortedRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr = {3,4,5,6,7,8,9,10,1000,1,2};
		System.out.println(findMaximum(arr));

	}
	
	static int findMaximum(int [] arr){
		int low = 0;
		int high = arr.length;
		int mid = 0;
		while(low<=high){
			mid = low + (high-low)/2;
			
			if(arr[mid]>arr[low])
				low = mid;
			else if(arr[mid]<arr[low])
				high = mid -1;
			else 
				break;
		}	
		
		return arr[mid];
	}
}
