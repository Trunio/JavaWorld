public class OrganismFactory {
    protected int power;
    protected int initiative;
    protected Position position;
    protected World world;
    protected int life;
    protected int powerToReproduce;
    protected char sign;

        public Organism createOrganism(String name) {
            Organism org = null;
            if (name.equals("Grass")) {
               Grass grass = new Grass(world);
               org=grass;
            }
            if (name.equals("Dandelion")) {
                Dandelion Dandelion = new Dandelion(world);
                org=Dandelion;
            }
            if (name.equals("ToadStool")) {
                ToadStool ToadStool= new ToadStool(world);
                org=ToadStool;
            }
            if (name.equals("Sheep")) {
                Sheep Sheep = new Sheep(world);
                org=Sheep;
            }
            if (name.equals("Wolf")) {
                Wolf Wolf = new Wolf(world);
                org=Wolf;
            }
            if (name.equals("Horse")) {
                Horse Horse = new Horse(world);
                org=Horse;
            }
            if (name.equals("Zombie")) {
                Zombie zombie = new Zombie(world);
                org=zombie;
            }
            if (name.equals("Rabbit")) {
                Rabbit rabbit = new Rabbit(world);
                org=rabbit;
            }
            return org;
        }
    }

