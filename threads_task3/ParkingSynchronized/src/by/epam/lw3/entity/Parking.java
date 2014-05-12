package by.epam.lw3.entity;

import by.epam.lw3.main.Runner;

	public class Parking {

		private CarPlace[] instance = new CarPlace[Runner.PLACES];
		{
			initParking();
		}
		
		private void initParking() {
			for(int i = 0; i < instance.length; i++){
				instance[i] = new CarPlace();
			}
			
		}

		public void getPlace(int idNumber, int stayTime) throws InterruptedException {
			int place = placeSearcher();
			instance[place].stay(stayTime, idNumber);
			instance[place].setAsEmpty();
			
		}
		synchronized private int placeSearcher(){
			for (int i = 0; i < instance.length; i++) {
				if(instance[i].isEmpty()){
					instance[i].setAsNonEmpty();
					System.out.println("Free place: " + i);
					return i;
				}
			}	
			return 0;
		}
}