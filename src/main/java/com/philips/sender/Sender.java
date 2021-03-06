package com.philips.sender;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


class Sender {
	private static Logger LOGGER = LogManager.getLogger(Sender.class);
	public static final String DELIMITER = ",";

	public static void main(String[] args) throws IOException {
		try (FileInputStream fis = new FileInputStream(args[0]);
				InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
				BufferedReader reader = new BufferedReader(isr)) {
			if (args.length == 1) {
				readFileContentWithoutColumnFilter( reader);
			} else {
				readFileContentWhenColumnFilterIfProvided(args[1], reader);
			}
		}

	}

	static void readFileContentWithoutColumnFilter( BufferedReader br) throws IOException {

		String line;
		while ((line = br.readLine()) != null) {
		LOGGER.info(line);
		}
	}

	static void readFileContentWhenColumnFilterIfProvided(String filteredColumnName, BufferedReader reader)
			throws IOException {

		String line = reader.readLine();
		int columnFilterIndex = getColumnFilterIndex(line, filteredColumnName);
		while ((line = reader.readLine()) != null) {
			if (line.isEmpty()) {
				continue;
			}
			readFileContentWhenColumnFilter(line, columnFilterIndex);
		}

	}

	static int getColumnFilterIndex(String line, String filteredColumnName) {
		String[] headerEntryDataArray = line.split(",");
		int columnFilterIndex = -1;
		for (int i = 0; i <= headerEntryDataArray.length - 1; i++) {
			if (headerEntryDataArray[i].equalsIgnoreCase(filteredColumnName)) {
				columnFilterIndex = i;
				LOGGER.info(columnFilterIndex);
				break;
			}
		}
		return columnFilterIndex;
	}

	private static void readFileContentWhenColumnFilter(String line, int columnFilterIndex) {
		String[] rowEntryDataArray = line.split(DELIMITER);
		if (rowEntryDataArray.length > columnFilterIndex  && rowEntryDataArray.length != 1)
				LOGGER.info(rowEntryDataArray[columnFilterIndex]);
		
	 printLastColumn(line,columnFilterIndex,rowEntryDataArray);
		
	}
	
	private static void printLastColumn(String line, int columnFilterIndex,String[] rowEntryDataArray ) {
	
		if(columnFilterIndex == 1 ) {
			for (String row : rowEntryDataArray) {
				String space = "  ";
				LOGGER.info(row + space);
			}
		}
			System.out.println();
		}
	

}
