package Observer;

import java.util.Observer;

public interface Subject {
	void attach(Observer observer);

	void detach(Observer observer);

	void notifyObservers();

}
