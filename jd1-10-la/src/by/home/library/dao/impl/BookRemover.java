package by.home.library.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.home.library.entity.Book;

public class BookRemover {

	private BufferedReader reader;
	private BufferedWriter writer;
	String file;

	public BookRemover(String file) throws IOException {
		reader = new BufferedReader(new FileReader(file));
		writer = new BufferedWriter(new FileWriter(file, true));
		this.file = file;
		
	}

	public void removeBook(Book book) throws IOException {

		try {

			String regex = " \\| ";
			List<String> linesList = new ArrayList<>();
			List<String[]> userBookComponents = new ArrayList<>();

			String newLine = reader.readLine();
			while (newLine != null) {
				linesList.add(newLine);
				newLine = reader.readLine();
			}

			String[] stringArray;
			for (String bookLine : linesList) {
				stringArray = bookLine.split(regex);
				userBookComponents.add(stringArray);
			}

			List<String[]> bookComponents = userBookComponents;
			for (int i = 0; i < bookComponents.size(); i++) {
				String[] array = bookComponents.get(i);
				if (Integer.parseInt(array[0]) == book.getId()
						& array[1].toUpperCase().equals(book.getTitle().toUpperCase())
						& array[2].toUpperCase().equals(book.getAuthor().toUpperCase())
						& array[3].toUpperCase().equals(book.getPublisher().toUpperCase())
						& Integer.parseInt(array[4]) == book.getPublishingYear()) {
					bookComponents.remove(i);
				}
			}

			int counter = 1;
			for (String[] array : bookComponents) {
				String newDataLine = counter + " | " + array[1] + " | " + array[2] + " | " + array[3] + " | "
						+ array[4];
				writer.newLine();
				writer.write(newDataLine);
				System.out.println("DD");
				counter++;
			}

		} finally {
			try {
				reader.close();
			}finally {}
		}
	}
}
