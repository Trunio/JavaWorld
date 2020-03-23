import java.util.concurrent.TimeUnit;

public class PrintWorld {
    World world;

    public PrintWorld(World world){
        this.world = world;
    }

    public void printworld() throws InterruptedException {
        System.out.println("Tura: " + world.getTurn());
            for (int i = 0; i <= world.getWorldX(); i++) {
                for (int j = 0; j <= world.getWorldY(); j++) {
                    if (world.getOrganismFromPosition(new Position(i, j)) == null) {
                        System.out.print("-");
                    } else
                        System.out.print(world.getOrganismFromPosition(new Position(i, j)).getSign());
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }

