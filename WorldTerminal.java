import java.io.FileWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.io.*;

public class WorldTerminal implements Observer {

    @Override
    public void update(Action action) throws IOException {
        System.out.println(action.toString());
    }
}
