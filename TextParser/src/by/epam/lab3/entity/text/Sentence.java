package by.epam.lab3.entity.text;

import java.util.ArrayList;
import java.util.List;

import by.epam.lab3.entity.sentence.PartOfSentence;

public class Sentence extends PartOfText {
	private String line;
	private List<PartOfSentence> splitedSentence = new ArrayList<PartOfSentence>();
	
	public Sentence(String line) {
		this.line = line;
	}

	public String getLine() {
		return line;
	}

	public List<PartOfSentence> getSplitedSentence() {		
		return splitedSentence;
	}
	
	public void setSplitedSentence(List<PartOfSentence> sentence) {
		this.splitedSentence = sentence;
	}

	@Override
	public String toString() {
		return line;
	}
	
	public void addPart(PartOfSentence part){
		this.splitedSentence.add(part);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((line == null) ? 0 : line.hashCode());
		result = prime * result
				+ ((splitedSentence == null) ? 0 : splitedSentence.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sentence other = (Sentence) obj;
		if (line == null) {
			if (other.line != null)
				return false;
		} else if (!line.equals(other.line))
			return false;
		if (splitedSentence == null) {
			if (other.splitedSentence != null)
				return false;
		} else if (!splitedSentence.equals(other.splitedSentence))
			return false;
		return true;
	}
	
}
