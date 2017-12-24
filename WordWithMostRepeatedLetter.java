import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class WordWithMostRepeatedLetter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inStr = "" ;
		String path = "src/TestDatto.txt";
		String result = doFileIO(path);
		System.out.println(result);
		

	}	
	
	public static String doFileIO(String path){
		String result = "";
		int curCount = 0;
		int maxCount = 0;
		try {
			File file = new File(path);
			Scanner in = new Scanner(new FileInputStream(file));
			while(in.hasNext()){
				String word = in.next();
				curCount = countMaxRepeatedCharacter(word);
				if(curCount>maxCount){
					result = word;
					maxCount = curCount;
				}
			}
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
/*
 * This method finds the word with most repeated character.
 * @param String - sentence(s) of multiple words
 * @return String - the word with most repeated character
 */	
	public static String findWordWithMostRepeatedLetter(String inStr){
		String [] words = inStr.split(" ");
		int curCount = 0;
		int maxCount = 0;
		String result = "";
		int wordCount = words.length;
		
		for(int i=0;i<wordCount;i++){
			curCount = countMaxRepeatedCharacter(words[i]);
			if(curCount>maxCount){
				result = words[i];
				maxCount = curCount;
			}
		
		}
		
		return result;
	}
	
/*
 * This method finds the count of most repeated character.
 * @param String - word to be searched for
 * @return int - count of the most repeated character in the word
 */
	public static int countMaxRepeatedCharacter(String word){
		word = word.toLowerCase();
		char [] array = word.toCharArray();
		int length = array.length;
		int maxCountSeen = 0;
		int curCount = 0;
		int [] countOfChar = new int[26];
		for(int i=0;i<length;i++){
			if(array[i]>=97 && array[i]<=122){
				int index = array[i] - 'a';
				curCount = ++countOfChar[index];
				maxCountSeen = Math.max(maxCountSeen, curCount);
			}
		}
		return maxCountSeen;
	}

}
