package com.philips.receiver;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

public class ReviewTest {

	@Test
	public void TokenizerTestPassing() {
		
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
		
		Set<String> TestString1 = new TreeSet<String>();
		TestString1 = Receiver.tokenizer("check the tokenizer funtion");
		int count1 = TestString1.size();
		
		assertNotEquals(2, count1);
		
	}


	@Test	
	public void test() throws FileNotFoundException {	

		HashMap<String, Integer> wordCount = new HashMap<String, Integer>();	
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\shubhanshu\\eclipse-workspace\\casestudy (1).zip_expanded\\casestudy.zip_expanded\\casestudyreview\\src\\test\\resources\\senderSampleTest1.csv"));	
		Receiver.countFrequency(br,wordCount);
		
		HashMap<String, Integer> wordCount2 = new HashMap<String, Integer>();	
		BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\shubhanshu\\eclipse-workspace\\casestudy (1).zip_expanded\\casestudy.zip_expanded\\casestudyreview\\src\\test\\resources\\TestSample2.csv"));	
		Receiver.countFrequency(br2,wordCount2);
		assertTrue(wordCount.containsKey("provided"));	
		assertFalse(wordCount2.containsKey("future"));	
		assertFalse(wordCount2.containsKey("today"));	
	}
	
	@Test
	public void writeWordCountToCSVTest() throws IOException {
		
		HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
		wordCount.put("apple", 100);
		wordCount.put("banana", 50);
		wordCount.put("mango", 80);
		wordCount.put("pineapple", 90);
		wordCount.put("cherry", 200);
		wordCount.put("guava", 20);
		Receiver.writeWordCountToCSV(wordCount);
		File dir = new File("C:\\Users\\shubhanshu\\eclipse-workspace\\casestudy (1).zip_expanded\\casestudy.zip_expanded\\casestudyreview\\src\\main\\java\\com\\philips\\receiver");
		File[] files = dir.listFiles((dir1, name) -> name.startsWith("output") && name.endsWith(".csv"));
		Assert.assertNotNull(files);
	}
	
	
}
