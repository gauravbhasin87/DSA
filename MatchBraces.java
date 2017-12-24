package wepay;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MatchBraces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] values = {"{{]}","{{{{{}}}}}"};
		values = matchBraces(values);
		System.out.println(Arrays.toString(values));
	}
	
	public static String[] matchBraces(String [] values){
		
		int length = values.length;
		for(int i=0;i<length;i++){
			Deque<Character> stack = new ArrayDeque<>();
			int l = values[i].length();
			char[] array = values[i].toCharArray();
			for(int j=0;j<l;j++){
				if(array[j] == ')' || array[j] == '}' || array[j] == ']'){
					char closing = array[j];
					if(stack.size() == 0){
						values[i] = "NO";
						break;
					}
					char opening = stack.removeLast();
					if( (closing == ')' && opening != '(') || (closing == '}' && opening != '{') || (closing == ']' && opening != '[')){
						values[i] = "NO";
						break;
					}
				}
				else{
					stack.addLast(array[j]);
				}
			}
			
			if(stack.size() == 0 && !values[i].equals("NO"))
				values[i] = "YES";
			else
				values[i] = "NO";
		}
		
		return values;
	}

}
