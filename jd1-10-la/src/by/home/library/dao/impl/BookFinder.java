package by.home.library.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookFinder {

	private BufferedReader reader;

	public BookFinder(String file) throws IOException {
		reader = new BufferedReader(new FileReader(file));
	}

	public boolean findBook(String filter, String parameter) throws IOException {

		try {

			String regex = " \\| ";
			List<String> linesList = new ArrayList<>();
			List<String[]> userBookComponents = new ArrayList<>();
			boolean find = false;

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
				case ("НОМЕР"):{
					if (userBookComponents.get(i)[0].equals(parameter)) {
						find = true;
						return find;
					}
					break;
				}
				case ("НАЗВАНИЕ"):{
					if (userBookComponents.get(i)[1].trim().toUpperCase().equals(parameter.trim().toUpperCase())) {
						find = true;
						return find;
					}
					break;
				}
				case ("АВТОР"):{
					if (userBookComponents.get(i)[2].trim().toUpperCase().equals(parameter.trim().toUpperCase())) {
						find = true;
						return find;
					}
					break;
				}
				case ("ИЗДАТЕЛЬСТВО"):{
					if (userBookComponents.get(i)[3].trim().toUpperCase().equals(parameter.trim().toUpperCase())) {
						find = true;
						return find;
					}
					break;
				}
				case ("ГОД"):{
					if (Integer.parseInt(userBookComponents.get(i)[4]) == Integer.parseInt(parameter)) {
						find = true;
						return find;
					}
					break;
				}
				default: {
					System.out.println("Введен неправильный фильтр.");
					find = false;
					break;
				}
				}
			}
			return find;

		} finally {

		}

	}

}
