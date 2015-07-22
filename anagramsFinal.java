package day3;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class anagramsFinal {
	
	public static String sortWord(String word) {
	        char[] chars = word.toCharArray();
	        Arrays.sort(chars);
	        return new String(chars);
	}

	
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		FileReader sowpods= new FileReader("C:/Users/test/Desktop/sowpodsInput.txt");
		BufferedReader in=new BufferedReader(sowpods);
		
		String filePath="C:/Users/test/Desktop/anagramOutput.txt";
		FileOutputStream fos = new FileOutputStream(filePath);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		
		String currentWord=in.readLine();
		HashMap<String, String> sowPodsList = new HashMap<String, String>();
		String sortedWord,value;
		while (currentWord!=null)
		{
			sortedWord=sortWord(currentWord);
			if(!sowPodsList.containsKey(sortedWord)){
				sowPodsList.put(sortedWord, currentWord);
			}
			else{
				value=sowPodsList.get(sortedWord);
				value=value+" "+currentWord;
				sowPodsList.put(sortedWord, value);
			}
			currentWord=in.readLine();
			
		}
		in.close();
	    Iterator<Entry<String, String>> itrtr = sowPodsList.entrySet().iterator();
	    while (itrtr.hasNext()) {
	        Map.Entry pair = (Map.Entry)itrtr.next();
	        if (pair.getValue().toString().contains(" ")) {
		        bw.write(String.valueOf(pair.getValue()));
				bw.newLine();
	        }
	    }
	    System.out.println("Output written to "+filePath);
	    bw.close();
	}
}
