package by.epam.lab1.to;

import by.epam.lab1.view.View;

public class TOwithPrices extends TO {
	

	public int lowPrice;
	public int highPrice;  
	
	public TOwithPrices(View view) {
		super(view);
		this.lowPrice = view.getPriceValue1();
		this.highPrice = view.getPriceValue2();
	}

 

}
