package wepay;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class kSubSequence {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
       
        
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for(int i=0;i<T;i++){
            int n = in.nextInt();
            int k = in.nextInt();
            int [] array = new int[n];
            for(int j=0;j<n;j++){
                array[j] = in.nextInt();
            }
            System.out.println();
            System.out.println(kSubSeq2(array,k));
        }
    }
    
    public static long kSubSeq2(int[] array, int k) {
    	HashMap<Integer,Integer> map = new HashMap<>();
    	int length = array.length;
    	 if(k == 1){
         	return ((long)array.length*(array.length+1))/2;
         }
    	long count = 0;
    	long cur_sum = 0;
    	long[] prefix = new long[k];
    	prefix[0]++;
    	for(int i=0;i<length;i++){
    		cur_sum += array[i];
    		prefix[(int) (cur_sum%k)]++;
    	}
    	
    	for(int i=0;i<k;i++){
    		count += (long)(prefix[i]*(prefix[i]-1))/2;
    	}
    	
    	return count;
    }
    
    public static int kSubSeq(int [] array,int k){
        HashSet<Integer> map = new HashSet<>();
        int length = array.length;
        int cur_sum = array[0];
        int count = 0;
        if(k == 1){
        	return (array.length*(array.length+1))/2;
        }
        
        if(array[0]%k == 0)
            count++;
        else
        	map.add(array[0]%k);
        
        for(int i=1;i<length;i++){
            if(array[i]%k == 0)
                count++;
            cur_sum += array[i];
            if(cur_sum%k == 0)
                count++;
            else{ 
                    if(map.contains(cur_sum%k)){
                        count++;
                    }
                    map.add(cur_sum%k);
                    
            }
        }
        
        return count;
    }
}