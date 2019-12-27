package by.home.library.dao;


import java.io.IOException;

import by.home.library.entity.Book;

public interface BookDao {

	public void add(Book newBook) throws IOException;
		
	public boolean find(String filter, String parameter) throws IOException;
	
	public int getLastBookNumber() throws IOException;
	
	public void delete(Book book) throws IOException;
	
	public void editInfo(Book book);
	
}
