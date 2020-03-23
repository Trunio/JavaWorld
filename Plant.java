import java.util.ArrayList;
import java.util.Random;

public abstract class Plant extends Organism implements Cloneable {
    public Plant(Plant plant) {
        super(plant);
    }

    public Plant() {
    }

    public abstract void initParams();

    public abstract Plant clone();

    public ArrayList<Action> reproduce() {
        ArrayList<Action> result = new ArrayList();
        Random rand = new Random();
        new ArrayList();
        if (this.ifReproduce() == 1) {
            ArrayList<Position> freespace = this.world.filterFreePosition(this.position);
            if (this.world.inWorld(this.position) && freespace.size() != 0) {
                int n = rand.nextInt(freespace.size());
                Position newPosition = (Position)freespace.get(n);
                Plant newPlant = this.clone();
                newPlant.initParams();
                newPlant.position = newPosition;
                result.add(new Action(ActionEnum.A_ADD, newPosition, 0, newPlant));
                this.setPower(this.getPower() / 2);
            }
        }

        return result;
    }

    public ArrayList<Action> move() {
        ArrayList<Action> result = new ArrayList();
        return result;
    }

    public Position getLastPosition() {
        return this.position;
    }

    public void setPosition(Position position, boolean back) {
        this.position = position;
    }
}
