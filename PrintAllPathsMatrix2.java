
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class PrintAllPathsMatrix2
{
	static void printPaths (String tempString, int i, int j, int m, int n, char [][] arr) {
		String newString = tempString + arr[i][j];
		if (i == m-1 && j == n-1) {
			System.out.println(newString);
			return;
		}
		//right
		if (j+1 < n) {
			printPaths (newString, i, j+1, m, n, arr);
		}
		//down
		if (i+1 < m) {
			printPaths (newString, i+1, j, m, n, arr);			
		}
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		char [] [] pathInput = {
				{'a', 'b', 'c', 'z'},
				{'d', 'e', 'f', 'y'},
				{'g', 'h', 'i', 'x'},
		};
		printPaths ("", 0, 0, pathInput.length, pathInput[0].length, pathInput);
	}
}