import java.util.Arrays;

class Job implements Comparable<Job>{
	int startTime;
	int endTime;
	int value;
	
	public Job(int s, int e, int v){
		startTime = s;
		endTime = e;
		value = v;
	}

	@Override
	public int compareTo(Job o) {
		// TODO Auto-generated method stub
		return this.endTime - o.endTime;
	}
}


public class WeightedJobSceduling {

	public static int findLastNonConflict(Job[] jArray, int i){
		for(int j = i-1;j>=0;j--){
			if(jArray[j].endTime<=jArray[i].startTime)
				return j;
		}
		return -1;
	}
	
	public static int findBinarySearch(Job[] jobs, int i){
		int low = 0;
		int high = i-1;
		
		
		while(low<=high){
			int mid = (low+high)/2;
			if(jobs[mid].endTime<=jobs[i].startTime){
				if(jobs[mid+1].endTime <= jobs[i].startTime)
					low = mid + 1;
				else
					return mid;
				}
			else
				high = mid-1;
		}
		return -1;
	}
	
	public static int findMaxProfit(Job [] jArray){
		Arrays.sort(jArray);
		int size = jArray.length;
		int dp[] = new int[size];
		//dp[0] = 0;
		dp[0] = jArray[0].value;
		for(int i=1;i<size;i++){
			
			int incl = jArray[i].value;
			//int index = findLastNonConflict(jArray,i);
			int index = findBinarySearch(jArray,i);
			if(index != -1)
				incl += dp[index];
			
			dp[i] = Math.max(dp[i-1], incl);
		}
		
		return dp[size-1];
	}
	
	public static int findRecursive(Job[] jobs, int n){
		if(n<0)
			return 0;
		
		int incl = jobs[n].value;
		int i = findLastNonConflict(jobs, n);
		if(i!=-1)
			incl += findRecursive(jobs,i);
		int excl = findRecursive(jobs,n-1);
		
		return Math.max(incl, excl);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Job jobs[] = new Job[6];
        jobs[0] = new Job(1,3,5);
        jobs[1] = new Job(2,5,6);
        jobs[2] = new Job(4,6,5);
        jobs[3] = new Job(6,7,4);
        jobs[4] = new Job(5,8,11);
        jobs[5] = new Job(7,9,2);
		System.out.println(findMaxProfit(jobs));
		System.out.println(findRecursive(jobs,5));
		
	}

}
