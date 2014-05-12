package by.epam.lw5.parsers.dom;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import by.epam.lw5.entity.Employee;

public class DomWriter {
	static DocumentBuilderFactory dbFactory = DocumentBuilderFactory
			.newInstance();
	static DocumentBuilder dBuilder;
	static Document doc = null;

	public static void run(List<Employee> empList) throws TransformerException {

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.newDocument();
			// add elements to Document
			Element rootElement = doc.createElementNS(
					"http://www.journaldev.com/employee", "Employees");
			// append root element to document
			doc.appendChild(rootElement);
			for (Employee employee : empList) {
				String strAge = String.valueOf(employee.getAge());
				// append first child element to root element
				rootElement.appendChild(getEmployee(doc, employee.getName(), strAge, employee.getGender(), employee.getRole()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// }
		// public static void write() throws TransformerException{
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		// for pretty print
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource source = new DOMSource(doc);

		// write to console or file
		StreamResult console = new StreamResult(System.out);
		StreamResult file = new StreamResult(new File("emps_result.xml"));

		// write data
		transformer.transform(source, console);
		transformer.transform(source, file);

	}

	private static Node getEmployee(Document doc, String name, String age,
			String role, String gender) {
		Element employee = doc.createElement("Employee");

		// create name element
		employee.appendChild(getEmployeeElements(doc, employee, "name", name));

		// create age element
		employee.appendChild(getEmployeeElements(doc, employee, "age", age));

		// create role element
		employee.appendChild(getEmployeeElements(doc, employee, "role", role));

		// create gender element
		employee.appendChild(getEmployeeElements(doc, employee, "gender",
				gender));

		return employee;
	}

	private static Node getEmployeeElements(Document doc, Element element,
			String name, String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}
}
