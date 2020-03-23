import java.io.IOException;

public interface Subject {
    void attach(Observer observer);
    void dettach(Observer observer);
    void notifyObservers(Action action) throws IOException;
}