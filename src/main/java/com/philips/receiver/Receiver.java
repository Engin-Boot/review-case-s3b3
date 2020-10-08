package com.philips.receiver;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Receiver {

	private static HashMap<String, Integer> wordCount = new HashMap<String,Integer>();

	public static void main(final String[] args) throws IOException {

		readFromconsole();

		try {
			writeWordCountToCSV(wordCount);
		} catch (final Exception e) {
			e.getMessage();
		}
	}

	private static void readFromconsole() {

		final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		countFrequency(reader,wordCount);
	}

	public static void countFrequency(final BufferedReader reader,HashMap<String, Integer> wordCount) {

		try {

			String line;
			while ((line = reader.readLine()) != null) {
				line = line.replaceAll("[\\p{Punct}&&[^/]]+", "").LowerCase();
				Set<String> wordSet = tokenizer(line);
				for (final String word : wordSet) {
					if (!wordCount.containsKey(word)) {
						wordCount.put(word, 1);
					} else {
						final int count = wordCount.get(word);
						wordCount.put(word, count + 1);
					}
				}

			}
		} catch (final IOException e) {
			e.getMessage();
		}
	}

	public static Set<String> tokenizer(final String review) {
		final Set<String> setOfWordsInReview = new TreeSet<String>();
		final StringTokenizer st = new StringTokenizer(review, " ");
		while (st.hasMoreTokens()) {
			final String s = st.nextToken();
			setOfWordsInReview.add(s);
		}
		return setOfWordsInReview;
	}

	public static void writeWordCountToCSV(final Map<String, Integer> wordCount) throws IOException {

		 Set<String>wordSet = wordCount.keySet();
		String str = "Word,Count\n";
		StringBuilder bld = new StringBuilder();

		for (final String word : wordSet) {
			System.out.println(word + " : " + wordCount.get(word));
			 bld.append(word + "," + Integer.toString(wordCount.get(word)) + "\n");
			 str = str+bld.toString();

		}
		

		PrintWriter pw = new PrintWriter(new File("output.csv"));
	
		
		pw.println(str);
		  
		pw.flush();
		pw.close();
		  
	}
}
