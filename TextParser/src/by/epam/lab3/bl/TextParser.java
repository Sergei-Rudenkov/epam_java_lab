package by.epam.lab3.bl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import by.epam.lab3.entity.sentence.PartOfSentence;
import by.epam.lab3.entity.text.Code;
import by.epam.lab3.entity.text.PartOfText;
import by.epam.lab3.entity.text.Sentence;
import by.epam.lab3.entity.text.Uncertain;

public class TextParser {
	private PartOfText text = new PartOfText();
	private StringBuilder nonParseText = new StringBuilder();
	private String message;
	private String key;
	private ResourceBundle bundle = ResourceBundle.getBundle("by.epam.lab3.resourcebundle.regexp");
	private BufferedReader bufferReader;
	private int tokenCounter = 0; 
	
	public TextParser(File file) throws IOException { 
		bufferReader = new BufferedReader(new FileReader(file));
	}
		
	public void parse() throws IOException{
		try{
			String line = bufferReader.readLine();
			while(line != null){
				if(recognize(line) instanceof Sentence){
					List<PartOfText> tempList = SentenceParser.separateLine((Sentence) recognize(line));
					
					for(int i = 0; i < tempList.size(); i++){
						Sentence sentence = (Sentence) tempList.get(i);
						List<PartOfSentence> parseSentence = SentenceParser.parse((Sentence) sentence);
						sentence.setSplitedSentence(parseSentence);
						text.addPart(sentence);
						//System.out.println(parseSentence);
					}
					
				//	System.out.println(tempList);
				}else{
					text.addPart(recognize(line));
				}
					line = bufferReader.readLine();
			}
		}finally{
			bufferReader.close();
		}
	//	System.out.println(nonParseText);
	}
	/*
		
	*/
	public String getMessage() {
		return message;
	}
	
	private PartOfText recognize(String line){
		//key = bundle.getString("prop.key2");	
		if(line.matches(".*\\}.*\\{")){
			return new Code(line);
		}
		if(line.matches(".*\\{")){ 
			tokenCounter++;
			return new Code(line);
		}
		if(line.matches(".*\\}")){
			tokenCounter--;
			return new Code(line);
		}
		if(tokenCounter>0){
			return new Code(line);
		}
				
		key = bundle.getString("prop.key1");
		if(line.matches(key)){ // if line ends with ':' or ',' or '.'
			return new Sentence(line);
		}
		
			
		
		return new Uncertain(line);
	}
}
