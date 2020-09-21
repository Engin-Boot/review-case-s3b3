package receiver;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map.Entry;

public class receiver {

	private static HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	     whenWordComesThenCountFrequency(reader);

				   try {
					whenFrequencyCountCompletesThenCreateCSVFile(wordCount);
					}catch(Exception e){
						e.getMessage();
					}
}
  
				
	    public static void whenWordComesThenCountFrequency(BufferedReader reader) {
	        
			try{
				String name = reader.readLine();
            while(name!=null){
				Set<String> wordSet=new TreeSet<String>();

		name=name.replaceAll("[\\p{Punct}&&[^/]]+", "");
		wordSet=Tokenizer(name);
		for(String word:wordSet){
			if(!wordCount.containsKey(word)) {
				wordCount.put(word, 1);
			}
			else{
			int count=wordCount.get(word);
			wordCount.put(word, count+1);
			}
		}
                name=reader.readLine();
            }
        } catch (IOException e) {
            e.getMessage();
        }
			}

			public static Set<String> Tokenizer(String review){
				Set<String> setOfWordsInReview=new TreeSet<String>();
				StringTokenizer st=new StringTokenizer(review," ");
				while(st.hasMoreTokens()) {
					String s=st.nextToken();
					setOfWordsInReview.add(s);
				}
				return setOfWordsInReview;
			}
			public static void whenFrequencyCountCompletesThenCreateCSVFile(Map<String,Integer> wordCount) throws IOException{
				Set<String> wordSet=new TreeSet<String>();
				wordSet=wordCount.keySet();
				String str="Word,Count\n";
				for(String word:wordSet){
					System.out.println(word +" : "+ wordCount.get(word));
					str=str+word+","+Integer.toString(wordCount.get(word))+"\n";
				}
			   
				PrintWriter pw = null;
				try {
					pw = new PrintWriter(new File("output.csv"));
				} catch (FileNotFoundException e) {
					e.getMessage();
					e.printStackTrace();
				}
				pw.println(str);
				pw.flush();
				pw.close();
			}
			
}


