package small_example_with_read_write;

import java.util.Scanner;

import java.util.List;
import java.util.ArrayList;

public class WriteThread implements Runnable {

	@Override
	public void run() {
		List<String> write = new ArrayList<>();

		try {
			System.out.println("Write the first line to 'file.txt': 'this is a line'");
			write.add("this is a line");
			FileHelper.write(write, "file.txt");
		} catch (InterruptedException e) {

		}
	}
}
