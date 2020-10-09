package com.philips.receiver;

import java.io.BufferedReader;
import java.io.IOException;


public class Main {
	
	public static void main(final String[] args) throws IOException {
		BufferedReader reader=ReadBuffer.readInputFromConsole(System.in);
		ParseCSV.parseLineFromCSV(reader);
		try {
			WriteCSV.writeWordCountToCSV(CountWords.wordCount);
		} catch (final Exception e) {
			e.getMessage();
		}
	}
}
