package com.philips.sender;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileNotFoundException;

class Sender {
	static Logger LOGGER = LogManager.getLogger(Sender.class);
	public static final String DELIMITER = ",";

	public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
     
		
		InputStream inputStream = new FileInputStream(args[0]);
		try (FileInputStream fis = new FileInputStream(args[0]);
				InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
				BufferedReader br = new BufferedReader(isr)) {
		if (args.length==1) {
			readFileContentWithoutColumnFilter(args[0], br); 
		} else {
			readFileContentWhenColumnFilterIfProvided(inputStream, args[1],br);
	   }
		}

	}

	private static void readFileContentWithoutColumnFilter(String fileName,BufferedReader br) throws IOException {

			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} 

	private static void readFileContentWhenColumnFilterIfProvided(InputStream fileInputStream,
			String filteredColumnName,BufferedReader reader) throws IOException, NumberFormatException, ParseException {
	 
			String line = reader.readLine();
			int columnFilterIndex = getColumnFilterIndex(line, filteredColumnName);
			while ((line = reader.readLine()) != null) {
				if (line.isEmpty()) {
					continue;
				}
				readFileContentWhenColumnFilter(line, columnFilterIndex);
			}
		
	}

	private static int getColumnFilterIndex(String line, String filteredColumnName) {
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
		String[] RowEntryDataArray = line.split(DELIMITER);
		if (columnFilterIndex >= 0 && RowEntryDataArray.length != 1) {
			if (RowEntryDataArray.length > columnFilterIndex)
				LOGGER.info(RowEntryDataArray[columnFilterIndex]);
		}

		else if (columnFilterIndex == 1 && RowEntryDataArray.length != 1) {
			for (String row : RowEntryDataArray) {
				LOGGER.info(row + "  ");
			}
			System.out.println();
		}
	}

}
