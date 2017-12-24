package vmWare;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class AcquireAndReleaseLocks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] events = {
				"1. ACQUIRE 123",
				"2. ACQUIRE 364",
				"3. ACQUIRE 84",
				"4. RELEASE 84",
				"5. RELEASE 364",
				"6. ACQUIRE 789",
				"7. RELEASE 456",
				"8. RELEASE 123"
						   };
		String [] events1 = {
				"1. ACQUIRE 364",
				"2. ACQUIRE 84",
				"3. ACQUIRE 364",
				"4. RELEASE 364"
						   };
		check_log_history(events1);
	}
	
	static void check_log_history(String[] events){
		int length = events.length;
		Deque<String> stack = new ArrayDeque<>();
		Set<String> set = new HashSet<>();
		int i=0;
		for(;i<length;i++){
			String [] array = events[i].split(" ");
			if(array[1].equals("ACQUIRE")){
				if(set.contains(array[2])){
					System.out.println(i+1);
					return;
				}
				else{		
					stack.add(array[2]);
					set.add(array[2]);
				}
			}
			else if(array[1].equals("RELEASE")){
				String pop = stack.removeLast();
				set.remove(pop);
				if(!pop.equals(array[2])){
					System.out.println(i+1);
					return;
				}
			}
		}
		
		if(stack.size() == 0){
			System.out.println(0);
		}
		else{
			System.out.println(i+1);	
		}
	}

}
