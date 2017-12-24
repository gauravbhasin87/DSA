import java.util.ArrayList;

import javax.xml.stream.events.Characters;

public class PowerSet{
     String str = "abcd"; //our string
     public static void main(String []args){
        PowerSet ps = new PowerSet();
        for(int i = 0; i< ps.str.length();i++){ //traverse through all characters
            ps.subs("",i);
        }
     }
     
     void powerBits(String str){
    	 int length = str.length();
    	 int n = 1<<length;
    	 ArrayList<String> result = new ArrayList<String>();
    	 for(int i=0;i<length;i++){
    		 String subSet = "";
    		 for(int j=0;j<n;j++){
    			 if(((i>>j)&1) == 1){
    				 subSet += str.charAt(j);
    			 }
    		 }
    		 System.out.println(subSet);
    		 result.add(subSet);
    	 }
     }

     void subs(String substr,int index)
     {
         String s = ""+str.charAt(index); //very important, create a variable on each stack
         s = substr+s; //append the subset so far
         System.out.println(s); //print

         for(int i=index+1;i<str.length();i++)
           subs(s,i); //call recursively

     }
}