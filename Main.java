import com.vdurmont.emoji.EmojiParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String args[]) throws CloneNotSupportedException, InterruptedException, IOException {
        World world = new World(15, 15, 0);
        WorldLogger Plik = new WorldLogger();
        WorldTerminal Terminal = new WorldTerminal();
        Organism plant = new Grass(new Position(4, 0), world);
        Organism owca = new Sheep(new Position(0, 0), world);
        Organism dandelion = new Dandelion(new Position(0, 6), world);
        Organism horse = new Horse(new Position(0, 8), world);
        Organism wolf = new Wolf(new Position(7, 7), world);
        Organism toadstool = new ToadStool(new Position(4, 4), world);
        Organism zombie = new Zombie(new Position(8,0),world);
        Organism rabbit = new Rabbit(new Position(5,5),world);
        PrintWorld printer = new PrintWorld(world);
        world.attach(Terminal);
       world.addOrganisms(zombie);
        world.addOrganisms(rabbit);
        world.addOrganisms(toadstool);
        world.addOrganisms(dandelion);
        world.addOrganisms(owca);
        world.addOrganisms(wolf);
        world.addOrganisms(plant);
        world.addOrganisms(horse);
        world.attach(Plik);
        while (true) {
            world.makeTurn();
            printer.printworld();
            TimeUnit.MILLISECONDS.sleep(1000);
        }

}
}