import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class WorldTest {
    @Test
    public void addOrganismTest() {
        OrganismFactory of = new OrganismFactory();
        Organism sheep = of.createOrganism("Sheep");
        World world = new World(5,5,0);
        world.addOrganisms(sheep);
        Assert.assertEquals( world.getOrganisms().size(),1);

    }
    @Test
    public void inWorldTest() {
        World world = new World(0,0,0);
        Assert.assertEquals( world.inWorld(new Position(6,6)),false);
    }
    @Test
    public void freePostionTest() {
        World world = new World(0,0,0);
        ArrayList<Position> freespace= world.FreePosition();
        Assert.assertEquals( freespace.size(),1);
    }
    @Test
    public void filterfreePostionTest() {
        World world = new World(0,0,0);
        ArrayList<Position> freespace= world.filterFreePosition(new Position(0,0));
        Assert.assertEquals( freespace.size(),0);
    }
    @Test
    public void filterPostionTest() {
        World world = new World(6,6,0);
        ArrayList<Position> freespace= world.filterFreePosition(new Position(3,3));
        Assert.assertEquals( freespace.size(),8);
    }
    @Test
    public void filterPostionTwiceTest() {
        World world = new World(6,6,0);
        ArrayList<Position> freespace= world.filterPositionTwice(new Position(3,3));
        Assert.assertEquals( freespace.size(),24);
    }

    @Test
    public void organismpositionTest1() {
        World world = new World(6,6,0);
        Assert.assertEquals( world.getOrganismFromPosition(new Position(1,1)),null);
    }
    @Test
    public void organismpositionTest2() {
        World world = new World(6,6,0);
        OrganismFactory of = new OrganismFactory();
        Organism sheep = of.createOrganism("Sheep");
        sheep.setPosition(new Position(1,1));
        sheep.setWorld(world);
        world.addOrganisms(sheep);
        Assert.assertEquals( world.getOrganismFromPosition(new Position(1,1)),sheep);
    }
    @Test
    public void currentspieciesTEST() {
        World world = new World(6,6,0);
        OrganismFactory of = new OrganismFactory();
        Organism sheep = of.createOrganism("Sheep");
        sheep.setWorld(world);
        world.addOrganisms(sheep);
        Assert.assertEquals( world.getCurrentSpecies().size(),1);
    }
}
