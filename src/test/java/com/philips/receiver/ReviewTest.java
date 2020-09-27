package com.philips.receiver;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

import org.junit.Test;

public class ReviewTest {

	@Test
	public void whenAStringContainsMultipleWordsThenEachWordMustGetAddedToTheList(){
		String multipleWords = "Illuminati is real";
		HashMap<String,Integer> wordCount = new HashMap<String, Integer>();
		
		final Set<String> setOfWordsInReview = new TreeSet<String>();
		final StringTokenizer st = new StringTokenizer( multipleWords, " ");
		while (st.hasMoreTokens()) {
			final String s = st.nextToken();
			setOfWordsInReview.add(s);
		}
		
		for (final String word :setOfWordsInReview) {
			if (!wordCount.containsKey(word)) {
				wordCount.put(word, 1);
			} else {
				final int count = wordCount.get(word);
				wordCount.put(word, count + 1);
			}
		}
			assertTrue( wordCount.containsKey("Illuminati"));
			assertTrue(wordCount.containsKey("is"));
			assertFalse( wordCount.containsKey("sun"));
			
			if( wordCount.containsKey("is")){
				assertEquals(1, wordCount.get("is").intValue());
			}
			else{
				assertNull( wordCount.get("is"));
			}
					assertEquals(1,  wordCount.get("real").intValue());
		assertNull( wordCount.get("jupiter"));
		}
		
	@Test
	public void test() throws FileNotFoundException {
		
		HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
		com.philips.receiver.Receiver junit = new com.philips.receiver.Receiver();
		BufferedReader br = new BufferedReader(new FileReader("C:\\\\Users\\\\User\\\\eclipse-workspace\\\\casestudyreview\\\\src\\\\test\\\\resources\\\\senderSampleTest1.csv"));
		Receiver.countFrequency(br);
		assertFalse(wordCount.containsKey("No file found"));
		assertFalse(wordCount.containsKey("future"));
		assertFalse(wordCount.containsKey("today"));
	}
	@Test
	public void TokenizerTestPassing() {
		com.philips.receiver.Receiver junit= new com.philips.receiver.Receiver();
		
		Set<String> TestString1 = new TreeSet<String>();
		TestString1 = Receiver.tokenizer("check the tokenizer funtion");
		int count1 = TestString1.size();
		
		Set<String> TestString2 = new TreeSet<String>();
		TestString2 = Receiver.tokenizer("check, the, tokenizer, funtion, with, commas");
		int count2 = TestString2.size() ;
		
		assertEquals(4, count1);
		assertEquals(6, count2);
		
	}
	@Test
	public void TokenizerTestFailing() {
		com.philips.receiver.Receiver junit= new com.philips.receiver.Receiver();
		
		Set<String> TestString1 = new TreeSet<String>();
		TestString1 = Receiver.tokenizer("check the tokenizer funtion");
		int count1 = TestString1.size();
		
		assertNotEquals(2, count1);
		
	}


		
	
	
}
