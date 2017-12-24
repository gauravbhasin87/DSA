public class IsPossible {
	
	static boolean cFound = false;
	static boolean dFound = false;
	
	public static String isItPossible(int a, int b, int c, int d){
		
		//System.out.println(a + " "+ b + " " + c + " " + d);
		
		if(a==c){
			cFound = true;
		}
		if(b==d){
			dFound = true;
		}	
		
		int sum = a+b;
		
		
		if(!cFound && sum<=c)
			isItPossible(sum,b,c,d);
		if(!dFound && sum<=d)
			isItPossible(a,sum,c,d);
		
		if(cFound && dFound){
			return "Yes";
		}
		else
			return "No";
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isItPossible(1,6,5,9));

	}

}