package by.epam.lab3.bl;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import by.epam.lab3.entity.sentence.PartOfSentence;
import by.epam.lab3.entity.sentence.Word;
import by.epam.lab3.entity.text.PartOfText;
import by.epam.lab3.entity.text.Sentence;

public class SecondSpecLogic {
	class SentenceCamparator implements Comparator<Sentence>{

		@Override
		public int compare(Sentence sent1, Sentence sent2) {
			int wordQ1 = countWords(sent1.getSplitedSentence());
			int wordQ2 = countWords(sent2.getSplitedSentence());
			if(wordQ1 < wordQ2){
				return -1;
			}else if(wordQ1 == wordQ2){
				return 0;
			}else{
				return 1;
			}
		}
		
		private int countWords(List<PartOfSentence> sent){
			int quantity = 0;
			for(PartOfSentence partOfSentence : sent){
				if(partOfSentence instanceof Word){
					quantity++;
				}
			}
			return quantity;
		}
	}
	
	public TreeSet go(List<PartOfText> text){
		SentenceCamparator comparator = new SentenceCamparator();
		TreeSet<Sentence> sentences = new TreeSet<Sentence>(comparator);
			for(PartOfText partOfText : text){
				if(partOfText instanceof Sentence){
					sentences.add((Sentence) partOfText);
				}
			}
		return sentences;
	}
}
