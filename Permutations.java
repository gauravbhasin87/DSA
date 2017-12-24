public class Permutations {

    // print N! permutation of the characters of the string s (in order)
    
	
	private static void perm1(String prefix, String suffix){
		if(suffix.equals("")){
			System.out.println(prefix);
			return;
		}
		int length = suffix.length();
		for(int i=0;i<length;i++){
			perm1(prefix+suffix.charAt(i) , suffix.substring(0,i)+ suffix.substring(i+1));
		}
	}
    
    
    private static void permuteString(char[] arr, StringBuilder sb, boolean[] used, int pos){
    	if(pos == arr.length){
    		System.out.println(sb);
    		return;
    	}
    	for(int i=0;i<arr.length;i++){
    		if(used[i])
    			continue;
    		used[i] = true;
    		sb.append(arr[i]);
    		permuteString(arr,sb,used,pos+1);
    		used[i] = false;
    		sb.setLength(pos);
    	}
    }

    // print N! permutation of the elements of array a (not in order)
    public static void perm2(String s) {
        int N = s.length();
        char[] a = new char[N];
        for (int i = 0; i < N; i++)
            a[i] = s.charAt(i);
        perm2(a, N);
    }

    private static void perm2(char[] a, int n) {
        if (n == 1) {
        	System.out.println(a);
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n-1);
            perm2(a, n-1);
            swap(a, i, n-1);
        }
    }  

    // swap the characters at indices i and j
    private static void swap(char[] a, int i, int j) {
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }



    public static void main(String[] args) {
//        int N = 4;
//        String str = "abcd";
//        char [] ar = str.toCharArray();
//        int length = ar.length;
//        boolean [] used = new boolean[length];
//        StringBuilder sb = new StringBuilder();
//        permuteString(ar,sb,used,0);
//        
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String elements = alphabet.substring(0, 3);
        System.out.println(elements);
        perm1("",elements);
        System.out.println();
        //perm2(elements);
    }
}
