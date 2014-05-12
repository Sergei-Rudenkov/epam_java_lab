package by.epam.lab3.bl;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import by.epam.lab3.entity.sentence.PartOfSentence;
import by.epam.lab3.entity.sentence.Punctuation;
import by.epam.lab3.entity.sentence.Space;
import by.epam.lab3.entity.sentence.Word;
import by.epam.lab3.entity.text.PartOfText;
import by.epam.lab3.entity.text.Sentence;

public class SentenceParser {
	
	private static ResourceBundle bundle = ResourceBundle.getBundle("by.epam.lab3.resourcebundle.regexp");
	
	public static List<PartOfText> separateLine(Sentence line){
		
		List<PartOfText> returnList = new ArrayList<PartOfText>();
		String	key = bundle.getString("prop.key2");
		String[] l = line.getLine().split(key);
			for(int i =0; i<l.length; i++){
				Sentence newSent = new Sentence(l[i]);
				returnList.add(newSent);
		}
		return returnList;	
	}
	public static List<PartOfSentence> parse(Sentence sentence){
		List<PartOfSentence> returnList = new ArrayList<PartOfSentence>();
		String[] part = sentence.getLine().split("\\b");
		for(int i =0; i<part.length; i++){
			returnList.add(recognize(part[i]));
		}
		return returnList;
	}
	
	private static PartOfSentence recognize(String symbol){
		if (symbol.matches("\\W")){
			return new Punctuation(symbol);	
		} else if(symbol.equals("")||symbol.equals(" ")){
			return new Space(symbol);
		}
		return new Word(symbol);
		
	}
}
