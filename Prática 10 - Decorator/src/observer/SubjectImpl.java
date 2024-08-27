package observer;

import java.util.ArrayList;
import java.util.List;

public class SubjectImpl implements Subject {
	
	List<Observer> observerList = new ArrayList<Observer>();
	
	public void attach(Observer observer) {
		observerList.add(observer);
	}
    
	public void detach(Observer observer) {
		observerList.remove(observer);
	}
	
	public void notifyObservers() {
		for (Observer observer : observerList) {
			observer.update(this);
		}
	}

}
