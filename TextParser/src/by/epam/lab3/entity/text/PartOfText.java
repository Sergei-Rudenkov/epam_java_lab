package by.epam.lab3.entity.text;

import java.util.ArrayList;
import java.util.List;

public class PartOfText {
	private static List<PartOfText> text = new ArrayList<PartOfText>();
	
	public void addPart(PartOfText part){
		this.text.add(part);
	}

	public static List<PartOfText> getText() {
		return text;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PartOfText other = (PartOfText) obj;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}
	
}
