package by.home.library.main;

import java.io.IOException;

import by.home.library.dao.impl.FileBookDao;
import by.home.library.entity.Book;
import by.home.library.service.impl.BookServiceImpl;

public class Main {
	
	public static void main(String[] args) throws IOException{
		FileBookDao fileBookDao = new FileBookDao();
		BookServiceImpl bookServiceImpl = new BookServiceImpl();
		
		//Book book = new Book(fileBookDao.getLastBookNumber(), "Убить пересмешника", "Харпер Ли", "АСТ", 2017); //fileBookDao.getLastBookNumber()
		Book book = new Book(5, "Глаз Голема", "Джонатан Страуд", "Эксмо", 2005);
		
		// добавляем новую книгу
		//fileBookDao.add(book);
		
		// Выводим список найденных книг
		bookServiceImpl.printBookList(bookServiceImpl.find("номер", "2"));
		bookServiceImpl.printBookList(bookServiceImpl.find("автор", "дэн браун"));
		bookServiceImpl.printBookList(bookServiceImpl.find("название", "Время должно остановиться"));
		
		fileBookDao.delete(book);
		
		
	}
	
}
