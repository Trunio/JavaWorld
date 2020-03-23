import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class OrganismTest {

    @Test
    public void OrganismFactorySheep() {
        OrganismFactory of = new OrganismFactory();
        Organism sheep = of.createOrganism("Sheep");
        Assert.assertEquals('S', sheep.getSign());

    }

    @Test
    public void OrganismFactoryHorse() {
        OrganismFactory of = new OrganismFactory();
        Organism horse = of.createOrganism("Horse");
        Assert.assertEquals('♘', horse.getSign());

    }

    @Test
    public void OrganismFactoryWolf() {
        OrganismFactory of = new OrganismFactory();
        Organism Wolf = of.createOrganism("Wolf");
        Assert.assertEquals('W', Wolf.getSign());
    }

    @Test
    public void OrganismFactoryToadStool() {
        OrganismFactory of = new OrganismFactory();
        Organism ToadStool = of.createOrganism("ToadStool");
        Assert.assertEquals('☠', ToadStool.getSign());

    }

    @Test
    public void OrganismFactoryDandelion() {
        OrganismFactory of = new OrganismFactory();
        Organism Dandelion = of.createOrganism("Dandelion");
        Assert.assertEquals('✿', Dandelion.getSign());

    }

    @Test
    public void OrganismFactoryGrass() {
        OrganismFactory of = new OrganismFactory();
        Organism Grass = of.createOrganism("Grass");
        Assert.assertEquals('*', Grass.getSign());

    }

    @Test
    public void OrganismFactoryZombie() {
        OrganismFactory of = new OrganismFactory();
        Organism Zombie = of.createOrganism("Zombie");
        Assert.assertEquals('☢', Zombie.getSign());

    }

    @Test
    public void Consequences() throws IOException, CloneNotSupportedException {
        World world = new World(0, 0, 0);
        OrganismFactory of = new OrganismFactory();
        Organism Grass = of.createOrganism("Grass");
        Organism Wolf = of.createOrganism("Wolf");
        Position pos1 = new Position(0, 0);
        Grass.setPosition(pos1);
        Wolf.setPosition(pos1);
        world.addOrganisms(Grass);
        world.addOrganisms(Wolf);
        ArrayList<Action> actions = Grass.consequences(Wolf);
        world.makeMove(actions.get(0));
        world.getOrganisms().removeIf(org -> org.getPosition().getX() == -1 && org.getPosition().getY() == -1);
        Assert.assertEquals(1, world.getOrganisms().size());
    }

    @Test
    public void Consequences2() throws IOException, CloneNotSupportedException {
        World world = new World(0, 0, 0);
        OrganismFactory of = new OrganismFactory();
        Organism Grass = of.createOrganism("Grass");
        Organism Dandelion = of.createOrganism("Dandelion");
        Position pos1 = new Position(0, 0);
        Grass.setPosition(pos1);
        Dandelion.setPosition(pos1);
        world.addOrganisms(Grass);
        world.addOrganisms(Dandelion);
        ArrayList<Action> actions = Grass.consequences(Dandelion);
        world.makeMove(actions.get(0));
        world.getOrganisms().removeIf(org -> org.getPosition().getX() == -1 && org.getPosition().getY() == -1);
        Assert.assertEquals(1, world.getOrganisms().size());
    }


    @Test
    public void Reproduce() throws IOException, CloneNotSupportedException {
        World world = new World(5, 5, 0);
        OrganismFactory of = new OrganismFactory();
        Organism Grass= of.createOrganism("Grass");
        Position pos1 = new Position(1,1);
        Grass.setPosition(pos1);
        Grass.setPower(10);
        Grass.setWorld(world);
        world.addOrganisms(Grass);
        ArrayList<Action> actions =  Grass.reproduce();
        world.makeMove(actions.get(0));
        world.getOrganisms().addAll(world.getNeworganisms());
        Assert.assertEquals(2, world.getOrganisms().size());
    }

    @Test
    public void ReproduceDandelion() throws IOException, CloneNotSupportedException {
        World world = new World(5, 5, 0);
        OrganismFactory of = new OrganismFactory();
        Organism Dandelion= of.createOrganism("Dandelion");
        Position pos1 = new Position(1,1);
        Dandelion.setPosition(pos1);
        Dandelion.setPower(10);
        Dandelion.setWorld(world);
        world.addOrganisms(Dandelion);
        ArrayList<Action> actions =  Dandelion.reproduce();
        world.makeMove(actions.get(0));
        world.getOrganisms().addAll(world.getNeworganisms());
        Assert.assertEquals(2, world.getOrganisms().size());
    }

    @Test
    public void ReproduceToadStool() throws IOException, CloneNotSupportedException {
        World world = new World(5, 5, 0);
        OrganismFactory of = new OrganismFactory();
        Organism ToadStool= of.createOrganism("ToadStool");
        Position pos1 = new Position(1,1);
        ToadStool.setPosition(pos1);
        ToadStool.setPower(10);
        ToadStool.setWorld(world);
        world.addOrganisms(ToadStool);
        ArrayList<Action> actions =  ToadStool.reproduce();
        world.makeMove(actions.get(0));
        world.getOrganisms().addAll(world.getNeworganisms());
        Assert.assertEquals(2, world.getOrganisms().size());
    }
    @Test
    public void ReproduceWolf() throws IOException, CloneNotSupportedException {
        World world = new World(5, 5, 0);
        OrganismFactory of = new OrganismFactory();
        Organism Wolf= of.createOrganism("Wolf");
        Position pos1 = new Position(1,1);
        Wolf.setPosition(pos1);
        Wolf.setPower(10);
        Wolf.setWorld(world);
        world.addOrganisms(Wolf);
        ArrayList<Action> actions =  Wolf.reproduce();
        world.makeMove(actions.get(0));
        world.getOrganisms().addAll(world.getNeworganisms());
        Assert.assertEquals(2, world.getOrganisms().size());
    }
    @Test
    public void ReproduceSheep() throws IOException, CloneNotSupportedException {
        World world = new World(5, 5, 0);
        OrganismFactory of = new OrganismFactory();
        Organism Sheep= of.createOrganism("Sheep");
        Position pos1 = new Position(1,1);
        Sheep.setPosition(pos1);
        Sheep.setPower(10);
        Sheep.setWorld(world);
        world.addOrganisms(Sheep);
        ArrayList<Action> actions =  Sheep.reproduce();
        world.makeMove(actions.get(0));
        world.getOrganisms().addAll(world.getNeworganisms());
        Assert.assertEquals(2, world.getOrganisms().size());
    }

    @Test
    public void ReproduceHorse() throws IOException, CloneNotSupportedException {
        World world = new World(5, 5, 0);
        OrganismFactory of = new OrganismFactory();
        Organism Horse= of.createOrganism("Horse");
        Position pos1 = new Position(1,1);
        Horse.setPosition(pos1);
        Horse.setPower(10);
        Horse.setWorld(world);
        world.addOrganisms(Horse);
        ArrayList<Action> actions =  Horse.reproduce();
        world.makeMove(actions.get(0));
        world.getOrganisms().addAll(world.getNeworganisms());
        Assert.assertEquals(2, world.getOrganisms().size());
    }

    @Test
    public void Move() throws IOException, CloneNotSupportedException {
        World world = new World(5, 5, 0);
        OrganismFactory of = new OrganismFactory();
        Organism Wolf = of.createOrganism("Wolf");
        Position pos1 = new Position(0, 0);
        Wolf.setPosition(pos1);
        world.addOrganisms(Wolf);
        Wolf.setWorld(world);
        ArrayList<Action> actions = Wolf.move();
        world.makeMove(actions.get(0));
        Assert.assertEquals(null, world.getOrganismFromPosition(new Position(0,0)));
    }
    @Test
    public void MoveHorse() throws IOException, CloneNotSupportedException {
        World world = new World(5, 5, 0);
        OrganismFactory of = new OrganismFactory();
        Organism Horse = of.createOrganism("Horse");
        Position pos1 = new Position(0, 0);
        Horse.setPosition(pos1);
        world.addOrganisms(Horse);
        Horse.setWorld(world);
        ArrayList<Action> actions = Horse.move();
        world.makeMove(actions.get(0));
        Assert.assertEquals(null, world.getOrganismFromPosition(new Position(0,0)));
    }
    @Test
    public void MoveSheep() throws IOException, CloneNotSupportedException {
        World world = new World(5, 5, 0);
        OrganismFactory of = new OrganismFactory();
        Organism Sheep = of.createOrganism("Sheep");
        Position pos1 = new Position(0, 0);
        Sheep.setPosition(pos1);
        world.addOrganisms(Sheep);
        Sheep.setWorld(world);
        ArrayList<Action> actions = Sheep.move();
        world.makeMove(actions.get(0));
        Assert.assertEquals(null, world.getOrganismFromPosition(new Position(0,0)));
    }
    @Test
    public void MoveZombie() throws IOException, CloneNotSupportedException {
        World world = new World(5, 5, 0);
        OrganismFactory of = new OrganismFactory();
        Organism Zombie = of.createOrganism("Zombie");
        Position pos1 = new Position(0, 0);
        Zombie.setPosition(pos1);
        world.addOrganisms(Zombie);
        Zombie.setWorld(world);
        ArrayList<Action> actions = Zombie.move();
        world.makeMove(actions.get(0));
        Assert.assertEquals(null, world.getOrganismFromPosition(new Position(0,0)));
    }
}
