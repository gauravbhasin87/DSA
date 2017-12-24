
public class StairsDP {
	
	//one or two steps
	static int printAllStairsCombinations(int N, String str){
		if(N==1){
			str += " 1";
			System.out.println(str);
			return N;
		}
		if(N==0){
			System.out.println(str);
			return 1;
		}
		
		int l = printAllStairsCombinations(N-1, str + " 1");
		int r = printAllStairsCombinations(N-2, str + " 2");
		
		return l+r;
	}
	
	static int printAllStairsCombinationsArr(int[] ar, int N, String str){
		if(N<0)
			return 0;
		
		if(N==1){
			str += " 1";
			System.out.println(str);
			return N;
		}
		if(N==0){
			System.out.println(str);
			return 1;
		}
		int l = 0;
		for(int i= 0;i<ar.length;i++){
			l += printAllStairsCombinationsArr(ar, N-ar[i], str + " " + ar[i]);
		}
		//int l = printAllStairsCombinations(N-1, str+ " 1");
		//int r = printAllStairsCombinations(N-2, str+ " 2");
		
		return l;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int countWays = printAllStairsCombinations(5, "");
		int [] arr = {1,3};
		int countWays2 = printAllStairsCombinationsArr(arr, 5, "");
		System.out.println("count ways :"+ countWays2 );
	}

}
