import java.util.ArrayList;
import java.util.Random;

public class Zombie extends Animal{

    public Zombie (Position position, World world){
        super();
        this.power = 10;
        this.powerToReproduce=500;
        this.life=30;
        this.position=position;
        this.sign='☢';
        this.world = world;
    }

    public Zombie (World world){
        super();
        this.power = 10;
        this.powerToReproduce=500;
        this.life=30;
        this.sign='☢';
        this.world = world;
    }

    @Override
    public Animal clone() {
        return new Zombie (this);
    }

    public Zombie (Zombie zombie){
        super(zombie );
    }

    @Override
    public void initParams() {
        this.setPower(10);
        this.setLife(30);
        this.sign='☢';
        this.powerToReproduce=500;
        this.world = world;
    }

@Override
public ArrayList<Action> consequences(Organism enemy) {
    ArrayList<Action> result = new ArrayList<Action>();
    ArrayList<Position> freespace = new ArrayList<>();
    freespace = world.filterPosition(this.position);
    Random rand = new Random();
    int n = rand.nextInt(freespace.size());
    Position newPosition;
    newPosition=freespace.get(n);
    Organism newZombie= this.clone();
    newZombie.initParams();
    newZombie.position = newPosition;
    if (this.getPower() > enemy.getPower()) {
        result.add(new Action(ActionEnum.A_REMOVE, new Position(-1, -1), 0, enemy));
        result.add(new Action(ActionEnum.A_ADD, newPosition, 0, newZombie));
    } else {
        result.add(new Action(ActionEnum.A_REMOVE, new Position(-1, -1), 0, this));
    }
    return result;
}
}
