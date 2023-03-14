package com.yalyshev.finaltest.csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVReaderWriter {
	
	public static final String PERSONS_CSV_FILE = "Persons.csv";
	
	
	public static <T> void writeToCSVFile(List<T> items,
										  StringArrayEncoder<T> encoder,
										  String fileName) {
		File file = new File(fileName);
		try (PrintWriter pw = new PrintWriter(file)) {
			items.stream().map((item) -> convertToCSV(item, encoder))
					.forEach(pw::println);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static <T> List<T> readFromCSVFile(StringArrayDecoder<T> decoder,
											  String filename) {
		List<T> items = new ArrayList<>();
		try {
			FileReader fileReader = new FileReader(filename);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = bufferedReader.readLine();
			while (line != null) {
				items.add(convertFromCSV(line, decoder));
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return items;
	}
	
	public static String convertToCSV(String[] strings) {
		return Stream.of(strings).map(CSVReaderWriter::escapeSpecialChars)
				.collect(Collectors.joining(","));
	}
	
	public static String[] convertFromCSV(String string) {
		return string.split(",");
	}
	
	private static String escapeSpecialChars(String data) {
		String escapedData = data.replaceAll("\\R", " ");
		if (data.contains(",") || data.contains("\"") || data.contains("'")) {
			data = data.replace("\"", "\"\"");
			escapedData = "\"" + data + "\"";
		}
		return escapedData;
	}
	
	public static <T> String convertToCSV(T object,
										  StringArrayEncoder<T> encoder) {
		return convertToCSV(encoder.encodeToStringArray(object));
	}
	
	public static <T> T convertFromCSV(String csvString,
									   StringArrayDecoder<T> decoder) {
		String[] strings = convertFromCSV(csvString);
		return decoder.decodeFromStringArray(strings);
	}
}
