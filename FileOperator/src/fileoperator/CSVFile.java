package fileoperator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;

public class CSVFile {	
	
	public CSVFile() {	}
	
	public void writeCSV(String values,String path) {
		try (PrintWriter writer = new PrintWriter(
				new FileWriter(path, true))) {
			StringBuilder sb = new StringBuilder();
			sb.append(values);
			sb.append('\n');
			writer.write(sb.toString());

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<String[]> readCSV(String path) {
		String line = "";
		String cvsSplitBy = ",";		
		
		ArrayList<String[]> arrayList = new ArrayList<>();
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			ArrayList<String> header = new ArrayList<>();
			
			int count = 0;
			while ((line = br.readLine()) != null) {

				count++;
				// use comma as separator
				String[] linearray = line.split(cvsSplitBy);
				
				if(count==1) {
					for(int i=0;i<linearray.length;i++) {
						header.add(linearray[i]);
					}
				}else {
//					for(int i=0;i<header.size();i++) {
//						System.out.print(header.get(i)+" = " + linearray[i] + ", ");
//						System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa" + header.size());
						arrayList.add(linearray);
//					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return arrayList;

	}
	
	public String modifyCSV(String id,String input){
		
		File inputFile = new File(input);
		String temp = inputFile.getParentFile()+"/temp.csv";
		File tempFile = new File(temp);
		String specificLine = null;

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(inputFile));

			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			
			String currentLine;

			while ((currentLine = reader.readLine()) != null) {
				String trimmedLine = currentLine.trim();
				if (trimmedLine.startsWith(id)) {
					specificLine = trimmedLine;
					continue;
				}
				writer.write(currentLine);
				writer.newLine(); // Writes a line separator.
			}

			writer.close();
			reader.close();
			
			inputFile.delete();
			boolean successful = tempFile.renameTo(inputFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return specificLine;
	}
	public String findline(String keyword,String file) {
		File inputFile = new File(file);
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(inputFile));
			String currentLine;
			while ((currentLine = reader.readLine()) != null) {
				String trimmedLine = currentLine.trim();
				if (trimmedLine.startsWith(keyword)) {
					reader.close();
					return trimmedLine;
				}
			}
			reader.close();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void createFirestCSV(String path,String values) {
		File f = new File(path);

		File parent = f.getParentFile();
		if (!parent.exists() && !parent.mkdirs()) {
		    throw new IllegalStateException("Couldn't create dir: " + parent);
		}
		
		if(!f.exists()) { 
			try (PrintWriter writer = new PrintWriter(
					new FileWriter(path, true))) {
				StringBuilder sb = new StringBuilder();
				sb.append(values);
				sb.append('\n');
				writer.write(sb.toString());

			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}