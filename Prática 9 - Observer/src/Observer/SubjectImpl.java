package Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class SubjectImpl implements Subject {
	@SuppressWarnings("deprecation")
	List<Observer> observerList = new ArrayList<Observer>();

	public void attach(@SuppressWarnings("deprecation") Observer observer) {
		observerList.add(observer);
	}

	public void detach(@SuppressWarnings("deprecation") Observer observer) {
		observerList.remove(observer);
	}

	@SuppressWarnings("deprecation")
	public void notifyObservers() {
		for (Observer observer : observerList) {
			observer.update(null, this);
		}
	}

}
