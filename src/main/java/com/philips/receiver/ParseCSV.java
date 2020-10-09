package com.philips.receiver;

import java.io.BufferedReader;

public class ParseCSV {
	private ParseCSV() {}
	public static void parseLineFromCSV(BufferedReader reader)
	{
		try {
			String reviewComment = reader.readLine();
            while(reviewComment!=null)
            {
                CountWords.countFrequency(reviewComment);
                reviewComment=reader.readLine();
            }
        }catch(Exception e) {
        	System.out.println(e.getMessage());
        }
	}
}
