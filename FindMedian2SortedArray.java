
public class FindMedian2SortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,5,19,121};
		int b[] = {3,4,12,17,19};
		System.out.println(findMedian(a,b,0,4,0,4));

	}
	
	static double findMedian(int[] a, int[] b, int startA, int endA, int startB, int endB){
		if(endA-startA == 1 && endB - startB == 1){
			return ( Math.max(a[startA], b[startB]) + Math.min(a[endA], b[endB]))/2.0;
		}
		
		int medianIndexA = startA + (endA-startA)/2;
		int medianIndexB = startB + (endB-startB)/2;
		
		if(a[medianIndexA] == b[medianIndexB])
			return a[medianIndexA];
		
		if(a[medianIndexA] < b[medianIndexB]){
			startA = medianIndexA;
			endB = medianIndexB;
		}
		else{
			endA = medianIndexA;
			startB = medianIndexB;
		}
		
		return findMedian(a,b,startA,endA,startB,endB);
		
	}
	

}
