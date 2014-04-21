package by.epam.lab3.bl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import by.epam.lab3.entity.sentence.PartOfSentence;
import by.epam.lab3.entity.sentence.Word;
import by.epam.lab3.entity.text.PartOfText;
import by.epam.lab3.entity.text.Sentence;

public class ThirdSpecLogic {
	static ArrayList wordsApartFirst = new ArrayList();
	static ArrayList wordsFromFirst = new ArrayList();
	static ArrayList<Sentence> sentences = new ArrayList<Sentence>();

	
	public String go(List<PartOfText> text) {
		for (PartOfText partOfText : text) {
			if (partOfText instanceof Sentence) {
				sentences.add((Sentence) partOfText);
			}
		}
		
		for(int i=1; i<sentences.size(); i++){
			wordsApartFirst.addAll(getWords(sentences.get(i)));
		}		
		wordsFromFirst = getWords(sentences.get(0));
		
		for(int i=0; i<wordsFromFirst.size(); i++){
			if(!wordsApartFirst.contains(wordsFromFirst.get(i))){
				return wordsFromFirst.get(i).toString();
			}
		}
		
		return null;
	}
	
	private ArrayList getWords(PartOfText sentence){
		ArrayList words = new ArrayList();
		List<PartOfSentence> listOfParts = ((Sentence) sentence).getSplitedSentence();
			for(PartOfSentence partOfSentence : listOfParts){
				if(partOfSentence instanceof Word){
					words.add(partOfSentence);
				}
			}
			return words;
	}
}
