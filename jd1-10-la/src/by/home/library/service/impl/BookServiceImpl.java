package by.home.library.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.home.library.dao.impl.FileBookDao;
import by.home.library.entity.Book;
import by.home.library.service.BookService;

public class BookServiceImpl implements BookService {

	FileBookDao fileBookDao = new FileBookDao();
	String file = "resources\\books.txt";
	BufferedReader reader;

	@Override
	public List<Book> find(String filter, String parameter) throws IOException {

		if (fileBookDao.find(filter, parameter) == true) {

			try {

				reader = new BufferedReader(new FileReader(file));
				String regex = " \\| ";
				List<String> linesList = new ArrayList<>();
				List<String[]> userBookComponents = new ArrayList<>();
				List<Book> books = new ArrayList<Book>();
				int counter = 1;

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

				for (int i = 0; i < userBookComponents.size(); i++) {
					switch (filter.trim().toUpperCase()) {
					case ("НОМЕР"): {
						if (userBookComponents.get(i)[0].equals(parameter)) {
							String[] array = userBookComponents.get(i);
							books.add(new Book(counter, array[1], array[2], array[3], Integer.parseInt(array[4])));
							counter++;

						}
						break;
					}
					case ("НАЗВАНИЕ"): {
						if (userBookComponents.get(i)[1].trim().toUpperCase().equals(parameter.trim().toUpperCase())) {
							String[] array = userBookComponents.get(i);
							books.add(new Book(counter, array[1], array[2], array[3], Integer.parseInt(array[4])));
							counter++;

						}
						break;
					}
					case ("АВТОР"): {
						if (userBookComponents.get(i)[2].trim().toUpperCase().equals(parameter.trim().toUpperCase())) {
							String[] array = userBookComponents.get(i);
							books.add(new Book(counter, array[1], array[2], array[3], Integer.parseInt(array[4])));
							counter++;

						}
						break;
					}
					case ("ИЗДАТЕЛЬСТВО"): {
						if (userBookComponents.get(i)[3].trim().toUpperCase().equals(parameter.trim().toUpperCase())) {
							String[] array = userBookComponents.get(i);
							books.add(new Book(counter, array[1], array[2], array[3], Integer.parseInt(array[4])));
							counter++;

						}
						break;
					}
					case ("ГОД"): {
						if (Integer.parseInt(userBookComponents.get(i)[4]) == Integer.parseInt(parameter)) {
							String[] array = userBookComponents.get(i);
							books.add(new Book(counter, array[1], array[2], array[3], Integer.parseInt(array[4])));
							counter++;

						}
						break;
					}
					default: {
						break;
					}
					}
					
				}
				counter = 1;
				return books;

			} finally {
				try {
					reader.close();

				} finally {
				}

			}
		} else {
			return null;
		}

	}

	@Override
	public void printBookList(List<Book> bookList) {

		if (bookList != null) {
			System.out.println("List of books: ");
			for (Book book : bookList) {
				System.out.print("\t" + book.getId() + ". ");
				System.out.print("\"" + book.getTitle() + "\", ");
				System.out.print(book.getAuthor() + ", ");
				System.out.print("Издательство: " + book.getPublisher() + ", ");
				System.out.print(book.getPublishingYear() + "г.\n");
			}
		} else {
			System.out.println("We do not have such books.");
		}

	}

}
