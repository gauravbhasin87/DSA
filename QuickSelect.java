import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class QuickSelect {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i] = in.nextInt();
        }
        
        System.out.println(quickSelect(ar,0,ar.length-1,8));
        
    }
    
    static int quickSelect(int [] ar, int start, int end, int N){
        if(start>end)
            return -1;
        int pindex = partition(ar,start, end);
        if(N == pindex)
            return ar[N];
        else if(N<pindex)
            return quickSelect(ar, start, pindex-1,N);
        else
            return quickSelect(ar, pindex+1, end, N);
    }
    
    static int partition(int [] ar, int left, int right){
        int pivot = ar[right];
        int pindex = left;
        for(int i=left;i<=right-1;i++){
            if(ar[i]<pivot){
                swap(ar,i,pindex);
                pindex++;
            }
        }
        swap(ar,pindex,right);
        return pindex;
    }
    
    static void swap(int [] ar, int i, int j){
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

}
