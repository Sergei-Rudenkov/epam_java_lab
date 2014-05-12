package by.epam.lw5.parsers.sax;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import by.epam.lw5.entity.Employee;

public class SaxParser {

	public static List<Employee> run() {
		List<Employee> empList = null;
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			SaxHandler handler = new SaxHandler();
			saxParser.parse(new File("employees.xml"), handler);
			// Get Employees list
			empList = handler.getEmpList();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return empList;
	}
	
}
