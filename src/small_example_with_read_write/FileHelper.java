package small_example_with_read_write;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.List;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import read_write_resources_locks.ReadWriteLock;

/**
 * 
 * @author ovidiu.dragoi
 *
 *         Two threads reading the same resource does not cause problems for
 *         each other, so multiple threads that want to read the resource are
 *         granted access at the same time, overlapping. But, if a single thread
 *         wants to write to the resource, no other reads nor writes must be in
 *         progress at the same time. To solve this problem of allowing multiple
 *         readers but only one writer, you will need a read / write lock.
 * 
 *         Read Access If no threads are writing, and no threads have requested
 *         write access. Write Access If no threads are reading or writing.
 *
 *
 */
public class FileHelper {

	public static ReadWriteLock lock = new ReadWriteLock();

	/**
	 * 
	 * @param inputFile
	 * @return
	 */
	public static List<String> read(String inputFile) throws InterruptedException {

		// lock resource
		lock.lockRead();

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

		// unlock resource
		lock.unlockRead();

		return lines;
	}

	/**
	 * 
	 * @param data
	 * @param outputFile
	 */
	public static void write(List<String> data, String outputFile) throws InterruptedException {

		// lock resource
		lock.lockWrite();

		try {
			try (BufferedWriter writer = new BufferedWriter(
					new FileWriter(FileHelper.getRoot() + "docs/" + outputFile))) {
				for (String line : data) {
					writer.write(line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		lock.unlockWrite();
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
