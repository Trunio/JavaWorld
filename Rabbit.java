import java.util.ArrayList;
import java.util.Random;

public class Rabbit extends Animal{

    public Rabbit (Position position, World world){
        super();
        this.power = 2;
        this.powerToReproduce=6;
        this.life=10;
        this.position=position;
        this.sign='R';
        this.world = world;
    }

    public Rabbit(World world){
        super();
        this.power = 2;
        this.powerToReproduce=6;
        this.life=10;
        this.sign='R';
        this.world = world;
    }

    public Rabbit(Rabbit rabbit) {
        super(rabbit);
    }

    @Override
    public Animal clone() {
        return new Rabbit(this);
    }

    public Rabbit(Wolf Rabbit){
        super(Rabbit);
    }
    @Override
    public ArrayList<Action> reproduce() {
        ArrayList<Action> result = new ArrayList<Action>();
        Random rand = new Random();
        ArrayList<Position> freespace = new ArrayList<>();
        Animal newAnimal;
        Position newPosition;
        Animal newAnimal2;
        Position newPosition2;
        if (this.ifReproduce()==1) {
            freespace=world.filterFreePosition(this.position);
            if (world.inWorld(this.position)&&freespace.size()!=1&&freespace.size()!=0)
            {
                int n = rand.nextInt(freespace.size());
                int n2 = rand.nextInt(freespace.size());
                newPosition=freespace.get(n);
                newPosition2=freespace.get(n2);
                newAnimal = this.clone();
                newAnimal.initParams();
                newAnimal.position = newPosition;
                newAnimal2 = this.clone();
                newAnimal2.initParams();
                newAnimal2.position = newPosition2;
                result.add(new Action(ActionEnum.A_ADD, newPosition, 0, newAnimal));
                result.add(new Action(ActionEnum.A_ADD, newPosition2, 0, newAnimal2));
                this.setPower(this.getPower()/2);
            }
        }
        return result;
    }
    @Override
    public void initParams() {
        this.setPower(2);
        this.setLife(6);
        this.sign='R';
        this.powerToReproduce=10;
        this.world = this.world;
    }


}


