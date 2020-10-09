package com.philips.sender;

import static org.junit.Assert.*;

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
	public void readWhenFileIsEmpty() throws IOException {
		String filename = "src//test//resources//senderSampleTest1.csv";
		BufferedReader br = new BufferedReader(new FileReader(filename));
		Sender.readFileContentWithoutColumnFilter(br);	
		assertFalse((filename).isEmpty());

	}

	@Test
	public void getColumnFilterIndexTest() {
		int passresult = Sender.getColumnFilterIndex("review-date,comments", "comments");
		Assert.assertEquals(1, passresult);

		int failresult = Sender.getColumnFilterIndex("review-date,comments", "failure");
		Assert.assertEquals(-1, failresult);
	}

	@Test
	public void checkHeaderCount() throws IOException {
		String filepath = "src//test//resources//senderSampleTest1.csv";
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filepath));
			String line = reader.readLine();
			String[] headerEntryDataArray = line.split(",");

			assertEquals("ReviewDate	Comments",headerEntryDataArray[0]);
		}	
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test	
	public void readFileContentWithoutCoulumnFilterTest() throws IOException {	

		BufferedReader br = new BufferedReader(new FileReader("src//test//resources//senderSampleTest1.csv"));	
		com.philips.sender.Sender.readFileContentWithoutColumnFilter(br);			
	}	


	@Test	
	public void readFileContentWithCoulumnFilterTest() throws NumberFormatException, IOException, ParseException {	
		
		String str = "Comments";	
		BufferedReader reader = new BufferedReader(new FileReader("src//test//resources//senderSampleTest1.csv"));			
		com.philips.sender.Sender.readFileContentWhenColumnFilterIfProvided(str, reader);	
	}

}