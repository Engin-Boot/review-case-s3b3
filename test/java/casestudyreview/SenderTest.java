package casestudyreview;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;

public class SenderTest {

	@Test
	public void readFileContentWithoutCoulumnFilterTest() throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\shubhanshu\\eclipse-workspace\\casestudyreview\\src\\test\\resources\\test.csv"));
		Sender.Sender.readFileContentWithoutColumnFilter("C:\\Users\\shubhanshu\\eclipse-workspace\\casestudyreview\\src\\test\\resources\\test.csv", br);		
	}
	
	@Test
	public void getColumnFilterIndexTest() {
		int passresult = Sender.Sender.getColumnFilterIndex("review-date,comments", "comments");
		Assert.assertEquals(1, passresult);
		
		int failresult = Sender.Sender.getColumnFilterIndex("review-date,comments", "failure");
		Assert.assertEquals(-1, failresult);
	}
	@Test
	public void readFileContentWithCoulumnFilterTest() throws NumberFormatException, IOException, ParseException {
		InputStream inputStream = new FileInputStream("C:\\Users\\shubhanshu\\eclipse-workspace\\casestudyreview\\src\\test\\resources\\test.csv");
		String str = "Comm";
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\shubhanshu\\eclipse-workspace\\casestudyreview\\src\\test\\resources\\test.csv"));		
		Sender.Sender.readFileContentWhenColumnFilterIfProvided(inputStream, str, reader);
	}
}
