//package testerThing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.Scanner;

public class Email {
	
	private static Scanner input = new Scanner(System.in);

	public static void main(String... args) {
		String in, out, encoding;
		int menuOption;

		System.out.print("Please provide the name of the file you wish to extract emails from (omit file extension!): ");

		in = input.nextLine();

		System.out.print("Please provide the name of the file you wish to write the extracted emails to: ");

		out = input.nextLine();

		System.out.println("Do you wish to provide encoding, or use the default UTF-8?");
		System.out.println("[1] Default encoding.");
		System.out.println("[2] Custom encoding");

		menuOption = Integer.parseInt(input.nextLine());

		switch (menuOption) {
		case 1:
			createValidEmailFile(in, out);
			break;
		case 2:
			System.out.println("Please provide encoding");
			encoding = input.nextLine();
			createValidEmailFile(in, out, encoding);
			break;
		default:
			createValidEmailFile(in, out);
		}

		// We will have to add more try/catch blocks and clean up the menu prompt code above for modularity and validations.
		System.out.println("Successfully created the output file!");
	}

	// Overloaded method.
	public static void createValidEmailFile(String inputName, String outputName, String encoding) {
		File dirname = new File(".");
		Stream<String> validEmails = null;
		String extension = ".txt";

		try {
			String sourcePath = dirname.getCanonicalPath() + File.separator + inputName + extension;
			String destinationPath = dirname.getCanonicalPath() + File.separator + outputName + extension;

			File f = new File(sourcePath);

			// Read
			try (InputStreamReader inputStream = new InputStreamReader(new FileInputStream(f), "UTF-8");
					BufferedReader bufferedInputStream = new BufferedReader(inputStream)) {
				validEmails = filterValidEmails(bufferedInputStream);

				// Write. Break this out into a separate method? Not quite as straightforward as
				// JS.
				try (OutputStreamWriter outputStream = new OutputStreamWriter(new FileOutputStream(destinationPath),
						"UTF-8"); BufferedWriter bufferedOutputStream = new BufferedWriter(outputStream)) {
					validEmails.forEach(email -> {
						try {
							bufferedOutputStream.write(email);
							bufferedOutputStream.newLine();
						} catch (IOException e) {
							e.printStackTrace();
						}
					});
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Original method signature unchanged.
	public static void createValidEmailFile(String inputName, String outputName) {
		createValidEmailFile(inputName, outputName, "UTF-8");
	}

	// Handles line-by-line comma separated Emails (Works even for single lines).
	// Will need to adjust this later, so that we can provide parameters for what
	// we're splitting on.
	// There also has to be a way to de-nest the filter from the flatmap. Look into
	// Collections more later.
	private static Stream<String> filterValidEmails(BufferedReader bufferedStream) {

		return bufferedStream.lines().flatMap(line -> split(line, ',').stream().filter(word -> {
			int atSymbolIndex = -1;
			int periodIndex = -1;
			boolean result = false;

			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) == '@') {
					atSymbolIndex = i;
				}

				if (word.charAt(i) == '.') {
					periodIndex = i;
				}

				if (atSymbolIndex > -1) {
					if (periodIndex > atSymbolIndex) {
						result = periodIndex <= word.length() - 3;
						break;
					}
				}
			}
			return result;
		}));
	}

	private static List<String> split(String word, char splitOn) {
		List<String> result = new ArrayList<>();
		String temp = "";

		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == splitOn) {
				result.add(temp);
				temp = "";
			} else {
				temp += word.charAt(i);
			}
		}

		return result;
	}

}
