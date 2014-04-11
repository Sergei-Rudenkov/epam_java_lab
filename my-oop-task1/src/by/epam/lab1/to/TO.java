package by.epam.lab1.to;

import by.epam.lab1.entiry.Treasure;
import by.epam.lab1.view.View;

public class TO {
        
        public Treasure treasure;
        public String message; 

    public TO(View view) {
        treasure = new Treasure(view.getName(),view.getPrice());
    }

	public TO() {
	}
}
