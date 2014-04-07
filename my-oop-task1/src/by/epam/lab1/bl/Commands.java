package by.epam.lab1.bl;

public enum Commands {
	SHOW(1),
	SEARCH(2),
	ADD(3);
	
	private int index;
	
	Commands(int i){
		index = i;
	}

	public int getIndex() {
		return index;
	}
	
	public static Commands getByIndex(int i){
		if(i==1)
			return SHOW;
		else if (i==2)
			return SEARCH;
		else if(i==3)
			return ADD;
		else
			throw new IllegalArgumentException();	
	}
}
