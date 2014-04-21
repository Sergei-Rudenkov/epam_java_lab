package by.epam.lab3.controller;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.TreeSet;

import by.epam.lab3.bl.SecondSpecLogic;
import by.epam.lab3.bl.TextParser;
import by.epam.lab3.bl.ThirdSpecLogic;
import by.epam.lab3.entity.text.PartOfText;
import by.epam.lab3.entity.text.Sentence;
import by.epam.lab3.view.View;

public class Controller {

	public void run() throws IOException {
		ResourceBundle bundle;
		String key = "prop.file1"; // get file name and file path from property file 
		bundle = ResourceBundle.getBundle("by.epam.lab3.resourcebundle.textfile");
		
		File file = new File(bundle.getString(key));
		TextParser textParser = new TextParser(file);
		textParser.parse();
		
		SecondSpecLogic secondSpecLogic = new SecondSpecLogic();
		TreeSet<Sentence> resultFirst = secondSpecLogic.go(PartOfText.getText());
		ThirdSpecLogic thirdSpecLogic = new ThirdSpecLogic();
		String resultSecond = thirdSpecLogic.go(PartOfText.getText());
		
		View view = new View();
		view.writeFile(resultFirst,"File has been written according with spec 2.");
		view.show(resultSecond);
	}

}
