package Hyland;

public class printPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countPrimes(99);
		
	}
	
	static void countPrimes(int n){
		
		boolean [] isNotPrimes = new boolean[n+1];
		isNotPrimes[0] = true;
		isNotPrimes[1] = true;
		isNotPrimes[2] = false;
		
		for(int i=0;i<=n;i++){
			
			if(!isNotPrimes[i]){
				int j = i;
				int k = 2;
				while(j*k<=n){
					isNotPrimes[k*j] = true;
					k++;
				}
			}
		}
		
		for(int i=0;i<=n;i++){
			if(!isNotPrimes[i])
				System.out.println(i);
		}
	}
}
