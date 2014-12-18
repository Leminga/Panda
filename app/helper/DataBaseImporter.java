package helper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class DataBaseImporter {
	
	public static void main(String[] args) {
		/* */
		CSVParser parser = null;
		/* */
		File csvData = null;
		/* */
		Charset charset = Charset.forName("ISO_8859_1");
		
		if (args == null || args.length == 0) {
			csvData = new File("./data.csv");
		} else {
			csvData = new File(args[0]);
		}
		
		try {
			parser = CSVParser.parse(csvData, charset, CSVFormat.RFC4180);
			
			//Get a list of CSV file records
			List<CSVRecord> csvRecords = parser.getRecords();
			
			//Read the CSV file records starting from the second record to skip the header
			for (CSVRecord record : csvRecords) {
				//System.out.println("TEST: " + record.get(name));
			}
		} catch (IOException e) {
			System.out.println("Error in CsvFileReader!");
			e.printStackTrace();
		} finally {
			try {
				parser.close();
			} catch (IOException e) {
				System.out.println("Error while closing fileReader/csvFileParser!");
				e.printStackTrace();
			}
		}
	}
	
}
