package com.philips.receiver;

import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class CountWords {
	
	private CountWords(){}
	static HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
	public static Set<String> Tokenizer(final String review) {
		final Set<String> setOfWordsInReview = new TreeSet<String>();
		final StringTokenizer st = new StringTokenizer(review, " ");
		while (st.hasMoreTokens()) {
			final String s = st.nextToken();
			setOfWordsInReview.add(s);
		}
		return setOfWordsInReview;
	}
	public static void countFrequency(String review) {

		Set<String> wordSet ;
		review = review.replaceAll("[\\p{Punct}&&[^/]]+", "").toLowerCase();
		wordSet = Tokenizer(review);
		for (final String word : wordSet) {
			if (!wordCount.containsKey(word)) {
				wordCount.put(word, 1);
			} else {
				final int count = wordCount.get(word);
				wordCount.put(word, count + 1);
			}
		}

}
	
	
}
