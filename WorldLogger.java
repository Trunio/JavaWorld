import java.io.FileWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.io.*;

public class WorldLogger implements Observer {

    @Override
    public void update(Action action) throws IOException {

        File file = new File("World.txt");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter br = new BufferedWriter(fr);
        br.write(action.toString());
        br.newLine();
        br.close();
        fr.close();

    }
}
