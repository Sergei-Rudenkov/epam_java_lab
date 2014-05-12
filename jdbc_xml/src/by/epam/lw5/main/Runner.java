package by.epam.lw5.main;

import java.util.List;

import by.epam.lw5.dao.MySQLAccess;
import by.epam.lw5.entity.Employee;
import by.epam.lw5.parsers.dom.DomReader;
import by.epam.lw5.parsers.sax.SaxParser;
import by.epam.lw5.parsers.stax.StaxParser;

public class Runner {
	static List<Employee> empList;
	public static void main(String[] args) throws Exception {
		MySQLAccess dao = new MySQLAccess();
	    empList = SaxParser.run();
	    dao.writeDataBase(empList);
	    System.out.println("SaxParsing and DB writing is finished");
	 
	    empList = StaxParser.run();
	    dao.writeDataBase(empList);
	    System.out.println("StaxParsing and DB writing is finished");
	    
	    empList = DomReader.run();
	    dao.writeDataBase(empList);
	    System.out.println("DomParsing and DB writing is finished");
	    
	    dao.readDataBase();
	    System.out.println("DB reading and XML wreting is finished");
	}
}
