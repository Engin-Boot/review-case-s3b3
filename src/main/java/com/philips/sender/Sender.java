package com.philips.sender;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Sender {
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
			
			String[] rowEntryDataArray = line.split(DELIMITER);
			if (columnFilterIndex >= 0 && rowEntryDataArray.length != 1)
				readFileContentWhenColumnFilter0(columnFilterIndex,rowEntryDataArray);
			else if (columnFilterIndex == 1 && rowEntryDataArray.length != 1)
				readFileContentWhenColumnFilter1(columnFilterIndex,rowEntryDataArray);
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

	public static void readFileContentWhenColumnFilter0( int columnFilterIndex,String[] rowEntryDataArray) {

		if (rowEntryDataArray.length > columnFilterIndex)
			LOGGER.info(rowEntryDataArray[columnFilterIndex]);
		System.out.println();
	}

	public static void readFileContentWhenColumnFilter1( int columnFilterIndex,String[] rowEntryDataArray) {

		for (String row : rowEntryDataArray) {
			String space = "  ";
			LOGGER.info(row + space);
		}
		System.out.println();
	}
}


