package com.philips.receiver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class WriteCSV {
	public static void writeWordCountToCSV(final Map<String, Integer> wordCount) throws IOException {
		Set<String> wordSet = new TreeSet<String>();
		wordSet = wordCount.keySet();
		String str = "Word,Count\n";
		for (final String word : wordSet) {
			System.out.println(word + " : " + wordCount.get(word));
			str = str + word + "," + Integer.toString(wordCount.get(word)) + "\n";
		}

		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File("output.csv"));
		} catch (final FileNotFoundException e) {
			e.getMessage();
			e.printStackTrace();
		
		}
		pw.println(str);
		pw.flush();
		pw.close();
	}
}
