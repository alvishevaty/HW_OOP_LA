package by.home.library.service;

import java.io.IOException;
import java.util.List;

import by.home.library.entity.Book;

public interface BookService {
	
	public void printBookList(List<Book> bookList);

	public List<Book> find(String filter, String author) throws IOException;

}
