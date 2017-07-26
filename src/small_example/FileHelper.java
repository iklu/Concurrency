package small_example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileHelper {

	/**
	 * 
	 * @param inputFile
	 * @return
	 */
	public static  List<String> read(String inputFile) {
		List<String> lines = new ArrayList<>();
		try {
			try (BufferedReader reader = new BufferedReader(
					new FileReader(FileHelper.getRoot() + "docs/" + inputFile))) {

				String line;
				while ((line = reader.readLine()) != null) {
					lines.add(line);
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
	
	/**
	 * 
	 * @param data
	 * @param outputFile
	 */
	public static  void write(List<String> data, String outputFile){
		try{
			try(BufferedWriter writer = new BufferedWriter(new FileWriter(FileHelper.getRoot() + "docs/" + outputFile))){
				for(String line: data){
					writer.write(line);
				}
			}
		} catch(IOException e){
			e.printStackTrace();
		}
	}

	/**
	 * Intoarce ruta a proiectului absoluta
	 * 
	 * @return
	 */
	public static String getRoot() {
		File project = new File(".");
		String root = project.getAbsolutePath() + "/";
		return root;
	}
}
