package by.epam.lab3.entity.sentence;

public class Space extends PartOfSentence {
	private String space;
	public Space(String symbol) {
		this.space = symbol;
	}
	@Override
	public String toString() {
		return space;
	}
	
}
