package by.epam.lw2.view;

import by.epam.lw2.entity.Bouquet;

public abstract class View {

	public static void show(Bouquet bouqet) {
		System.out.println(bouqet);
	}
	public static void show(String message) {
		System.out.println(message);
	}
}









