package by.epam.lab3.entity.sentence;

public class Punctuation extends PartOfSentence {
	String punctuation;
	public Punctuation(String symbol) {
		this.punctuation = symbol;
	}
	@Override
	public String toString() {
		return "'" + punctuation + "'";
	}
}
