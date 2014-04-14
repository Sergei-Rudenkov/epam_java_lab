package by.epam.lw2.entity.flowers.pots;

import by.epam.lw2.entity.flowers.Flower;

public abstract class PotsFlowers extends Flower {
		private String size;
	
	public PotsFlowers(String color, String size){
        super(color);
        this.size = size;
    }
	
	public String toString(){
		return size +" "+ color +" "+ name;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		PotsFlowers other = (PotsFlowers) obj;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}
	
}
