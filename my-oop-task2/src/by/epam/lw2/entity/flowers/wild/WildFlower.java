package by.epam.lw2.entity.flowers.wild;

import by.epam.lw2.entity.flowers.Flower;

public abstract class WildFlower extends Flower {
	
	private int brenchLength;
	
	public WildFlower(String color, int length) {
		super(color);
		this.brenchLength = length;
		
	}
	public String toString(){
		return  color +" "+ name +" with "+ brenchLength+ "sm of length";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + brenchLength;
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
		WildFlower other = (WildFlower) obj;
		if (brenchLength != other.brenchLength)
			return false;
		return true;
	}
	
}
