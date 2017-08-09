package small_example_with_read_write;

import java.util.List;

public class ReadThread implements Runnable {
	
	@Override
	public void run(){
		
		try{
			List<String> read = FileHelper.read("file.txt");	
			System.out.println("Copy the first line from 'file.txt' and write to 'outputFile.txt' :" + read.get(0));
			FileHelper.write(read, "outputFile.txt");
		}catch(InterruptedException e){
			
		}		
	}
}
