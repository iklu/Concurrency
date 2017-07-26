package small_example;

import java.util.List;

public class ReadThread implements Runnable {
	
	@Override
	public void run(){
		List<String> read = FileHelper.read("file.txt");		
		System.out.println("Copy the first line from 'file.txt' and write to 'outputFile.txt' :" + read.get(0));
		FileHelper.write(read, "outputFile.txt");		
		//copy the words in another file 	
		
	}
}
