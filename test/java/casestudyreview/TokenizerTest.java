package casestudyreview;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class TokenizerTest {

	@Test
	public void TokenizerTestPassing() {
		com.philips.receiver.Receiver junit= new com.philips.receiver.Receiver();
		
		Set<String> TestString1 = new TreeSet<String>();
		TestString1 = junit.tokenizer("check the tokenizer funtion");
		int count1 = TestString1.size();
		
		Set<String> TestString2 = new TreeSet<String>();
		TestString2 = junit.tokenizer("check, the, tokenizer, funtion, with, commas");
		int count2 = TestString2.size() ;
		
		assertEquals(4, count1);
		assertEquals(6, count2);
		
	}



@Test
public void TokenizerTestFailing() {
	com.philips.receiver.Receiver junit= new com.philips.receiver.Receiver();
	
	Set<String> TestString1 = new TreeSet<String>();
	TestString1 = junit.tokenizer("check the tokenizer funtion");
	int count1 = TestString1.size();
	
	assertNotEquals(2, count1);
	
}

}