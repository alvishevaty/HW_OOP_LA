package by.home.library.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.home.library.dao.BookDao;
import by.home.library.entity.Book;

public class FileBookDao implements BookDao {

	private String file = "resources\\books.txt";
	private BufferedReader br;

	// Добавляем новую книгу
	@Override
	public void add(Book newBook) throws IOException {
		BookWriter writer = new BookWriter(file);
		writer.writeNewBook(newBook);
	}
	
	// Проверяем, есть ли в списке книга по определенному фильтру.
	@Override
	public boolean find(String filter, String parameter) throws IOException {
		BookFinder finder = new BookFinder(file);
		return finder.findBook(filter, parameter);
	}
	
	// Удаляем книгу по параметру
	@Override
	public void delete(Book book) throws IOException {
		BookRemover bookRemover = new BookRemover(file);
		bookRemover.removeBook(book);

	}
	
	@Override
	public int getLastBookNumber() throws IOException {
		
		List<String> linesList = new ArrayList<>();
		int bookNumber = 0;
		String newLine;
				
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(file));
			newLine = br.readLine();

			while (newLine != null) {
				linesList.add(newLine);
				newLine = br.readLine();
			}
			bookNumber = linesList.size() + 1;

			return bookNumber;
			
		} finally {
			try {
				br.close();
			} finally {}
		}
		

	}

	@Override
	public void editInfo(Book book) {
		// TODO Auto-generated method stub

	}
	
}
