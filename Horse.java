import java.util.ArrayList;
import java.util.Random;

public class Horse extends Animal{

    public Horse (Position position, World world){
        super();
        this.power = 4;
        this.powerToReproduce=8;
        this.life=10;
        this.position=position;
        this.sign='♘';
        this.world = world;
    }

    public Horse (World world){
        super();
        this.power = 4;
        this.powerToReproduce=8;
        this.life=10;
        this.sign='♘';
        this.world = world;
    }

    @Override
    public Animal clone() {
        return new Horse (this);
    }

    public Horse (Horse Horse ){
        super(Horse );
    }

    @Override
    public void initParams() {
        this.setPower(4);
        this.setLife(10);
        this.sign='♘';
        this.powerToReproduce=8;
        this.world = world;
    }
    @Override
    public ArrayList<Action> move() {
        ArrayList<Action> result = new ArrayList<Action>();
        ArrayList<Position> positions = new ArrayList<Position>();
        Random rand = new Random();
        Position newPosition;
        Organism interaction;
        World world = this.getWorld();
        world.getOrganismFromPosition(this.position);
        positions = world.filterPositionTwice(this.position);
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

}


