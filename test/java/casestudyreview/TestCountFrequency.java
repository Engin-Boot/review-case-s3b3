package casestudyreview;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.junit.Test;

public class TestCountFrequency {

	@Test
	public void test() throws FileNotFoundException {
		
		HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
		com.philips.receiver.Receiver junit = new com.philips.receiver.Receiver();
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\shubhanshu\\eclipse-workspace\\casestudyreview\\src\\test\\resources\\test.csv"));
		junit.countFrequency(br,wordCount);
		assertTrue(wordCount.containsKey("the"));
		assertFalse(wordCount.containsKey("future"));
		assertFalse(wordCount.containsKey("today"));
	}
}
