
public class PrintAllCoinCombinations {

	
	static int findChange(int arr[], int index , int value, String str){
		
		if(value == 0){
			System.out.println(str);
			return 1;
		}
		if(index<0){
			return 0;
		}
		if(value<0){
			return 0;
		}
		
		int excl  = findChange(arr,index-1,value,str);
		
		str += " "+ arr[index];
		
		int incl = findChange(arr,index,value-arr[index],str);
		
		return incl + excl;
	
	}
	
	
	
	public static void main(String [] arg){
		int arr[] = {1,5,10,25};
		String s = "";
		int result = findChange(arr,3,16,s);
		System.out.println(result);
	}
}
