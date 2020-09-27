package com.philips.receiver;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

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
		assertTrue(wordCount.containsKey("provided"));	
		assertFalse(wordCount.containsKey("future"));	
		assertFalse(wordCount.containsKey("today"));	
	}
		
	
	
}
