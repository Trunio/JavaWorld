import java.util.ArrayList;

public class ToadStool extends Plant {
    public ToadStool (Position position, World world) {
        this.power = 0;
        this.powerToReproduce = 9;
        this.life = 10;
        this.position = position;
        this.world = world;
        this.sign = '☠';
    }

    public ToadStool(World world) {
        this.power = 0;
        this.powerToReproduce = 9;
        this.life = 10;
        this.world = world;
        this.sign = '☠';
    }

    public ToadStool(ToadStool toadStool) {
        super(toadStool);
    }

    public void initParams() {
        this.setPower(0);
        this.setLife(10);
        this.sign = '☠';
        this.powerToReproduce = 9;
        this.world = this.world;
    }

    public ToadStool clone() {
        return new ToadStool(this);
    }

    @Override
    public ArrayList<Action> consequences(Organism enemy) {
        ArrayList<Action> result = new ArrayList<Action>();
        if (this.getPower() > enemy.getPower()) {
            result.add(new Action(ActionEnum.A_REMOVE, new Position(-1, -1), 0, enemy));
        } else {
            result.add(new Action(ActionEnum.A_REMOVE, new Position(-1, -1), 0, enemy));
            result.add(new Action(ActionEnum.A_REMOVE, new Position(-1, -1), 0, this));
        }
        return result;
    }
}
