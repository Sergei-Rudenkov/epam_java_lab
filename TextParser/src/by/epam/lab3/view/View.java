package by.epam.lab3.view;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import by.epam.lab3.bl.TextParser;
import by.epam.lab3.entity.text.Sentence;

public class View {

	public void writeFile(TreeSet<Sentence> result, String message) {
		try{
			BufferedWriter out = new BufferedWriter(new FileWriter("resultfile.txt"));
			for(Sentence sent : result){
				out.write(sent.toString());
				out.write(System.lineSeparator());
			}
			out.close();
			System.out.println(message);
		}catch(IOException e){
			e.getMessage();
		}
	}

	public void show(String resultSecond) {
		System.out.println("Exist at the first sentence and doesn't repiat anywhere more, " +resultSecond);
		
	}
}