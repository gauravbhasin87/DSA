import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MrXandHisShots {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        Shot [] shots = new Shot[N];
        Prange [] ranges = new Prange[M];
        for(int i=0;i<N;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            shots[i] = new Shot(a,b);
        }
        
        for(int i=0;i<M;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            ranges[i] = new Prange(a,b);
        }
        
        Arrays.sort(shots);
        Arrays.sort(ranges);
        int pcounter = 0, scounter=0;
        int curshot = 0;
        int count = 0;
        while(pcounter<M){
            scounter = curshot;
            while(scounter<N &&  shots[scounter].b>=ranges[pcounter].a){
                    if(shots[scounter].a<=ranges[pcounter].b)
                        count++;
                    scounter++;   
            }
            
            if(scounter == curshot){
                while(scounter<N &&  shots[scounter].b<ranges[pcounter].a){
                    curshot++;
                    scounter++;
                }
                continue;
                    
            }
            pcounter++;         
        }
        System.out.println(count);
    }
    
    static class Shot implements Comparable<Shot>{
        int a;
        int b;
        Shot(int a, int b){
            this.a = a;
            this.b = b;
        }
        
        public int compareTo(Shot other){
            if(this.b<other.b)
                return -1;
            else if(this.b>other.b)
                return 1;
            else{
                return this.a - other.a;
            }
        }
        
    }
    
    static class Prange implements Comparable<Prange>{
        int a;
        int b;
        Prange(int a, int b){
            this.a = a;
            this.b = b;
        }
        
        public int compareTo(Prange other){
            if(this.a<other.a)
                return -1;
            else if(this.a>other.a)
                return 1;
            else{
                return this.b - other.b;
            }
        }
    }
}