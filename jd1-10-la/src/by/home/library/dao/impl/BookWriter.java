package by.home.library.dao.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import by.home.library.entity.Book;

public class BookWriter {

	private BufferedWriter writer;
	
	public BookWriter(String file) throws IOException  {
		writer = new BufferedWriter(new FileWriter(file, true));
	}
	
	public void writeNewBook(Book book) throws IOException {
		
		String regex = " | ";
		String newDataLine = book.getId() + regex + book.getTitle() + regex + book.getAuthor() + regex
				+ book.getPublisher() + regex + book.getPublishingYear();
		try {
			writer.newLine();
			writer.write(newDataLine);
		
		} finally {
			try {
				writer.close();
			} finally {}
		}
	}
}
