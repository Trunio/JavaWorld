import java.io.IOException;

public interface Observer {

        void update(Action action) throws IOException;

}
