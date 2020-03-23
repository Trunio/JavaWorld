import java.util.*;
public abstract class Animal extends Organism implements Cloneable {

    protected Position lastPosition;

    public Animal(Animal animal){
        super(animal);
        this.lastPosition = position;
        this.world = world;
    }

    public Animal() {
        super();
    }

    @Override
    public abstract Animal clone();

    @Override
    public ArrayList<Action> move() {
        ArrayList<Action> result = new ArrayList<Action>();
        ArrayList<Position> positions = new ArrayList<Position>();
        Random rand = new Random();
        Position newPosition;
        Organism interaction;
        World world = this.getWorld();
        Organism cos = this;
        world.getOrganismFromPosition(this.position);
        positions = world.filterPosition(this.position);
            int n = rand.nextInt(positions.size());
            newPosition=positions.get(n);
            result.add(new Action(ActionEnum.A_MOVE, newPosition, 0, this));
            this.lastPosition = this.position;
            interaction = world.getOrganismFromPosition(newPosition);
            if(interaction != null){
                ArrayList<Action> pomresult = new ArrayList<Action>();
                pomresult = (interaction.consequences(this));
                result.addAll(pomresult);
            }
        return result;
    }

    @Override
    public ArrayList<Action> reproduce() {
        ArrayList<Action> result = new ArrayList<Action>();
        Random rand = new Random();
        ArrayList<Position> freespace = new ArrayList<>();
        Animal newAnimal;
        Position newPosition;
        if (this.ifReproduce()==1) {
            freespace=world.filterFreePosition(this.position);
            if (world.inWorld(this.position)&&freespace.size()!=0)
            {
                int n = rand.nextInt(freespace.size());
                newPosition=freespace.get(n);
                newAnimal = this.clone();
                newAnimal.initParams();
                newAnimal.position = newPosition;
                result.add(new Action(ActionEnum.A_ADD, newPosition, 0, newAnimal));
                this.setPower(this.getPower()/2);
            }
        }
        return result;
    }

    @Override
    public Position getLastPosition() {
        return this.lastPosition;
    }

    @Override
    public String toString() {
        return super.toString() + " lastPosition: " + lastPosition;
    }

}