package by.epam.lw3.entity;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CarPlace { 
	private Lock permission = new ReentrantLock(); 	
	private boolean emp = true;
	
	public Lock getPermission() {
		return permission;
	}
	public boolean isEmpty(){
		return emp;
	}
	public void setAsNonEmpty(){
		this.emp = false;
	}
	public void setAsEmpty(){
		this.emp = true;
	}
	
}
