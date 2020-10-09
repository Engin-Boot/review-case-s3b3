package com.philips.receiver;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class ReceiverTest {


	@Test
	public void TokenizerTestPassing() {
		
		Set<String> TestString1 = new TreeSet<String>();
		TestString1 = Receiver.Tokenizer("check the tokenizer funtion");
		int count1 = TestString1.size();
		
		Set<String> TestString2 = new TreeSet<String>();
		TestString2 = Receiver.Tokenizer("check, the, tokenizer, funtion, with, commas");
		int count2 = TestString2.size() ;
		
		assertEquals(4, count1);
		assertEquals(6, count2);
		
	}
	@Test
	public void TokenizerTestFailing() {
		Set<String> TestString1 = new TreeSet<String>();
		TestString1 = Receiver.Tokenizer("check the tokenizer funtion");
		int count1 = TestString1.size();
		
		assertNotEquals(2, count1);
		
	}


	@Test	
	public void test() throws FileNotFoundException {	

		String wordCount = "provided";	
		BufferedReader br = new BufferedReader(new FileReader("src//test//resources//senderSampleTest1.csv"));	
		Receiver.countFrequency(wordCount);	
		assertTrue(wordCount.contains("provided"));	
		assertFalse(wordCount.contains("future"));	
		assertFalse(wordCount.contains("today"));	
	}
		
	
	
}
