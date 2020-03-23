
import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public abstract class Organism implements Cloneable{

    protected int power;
    protected int initiative;
    protected Position position;
    protected World world;
    protected int life;
    protected int powerToReproduce;
    protected char sign;

    public Organism(Position position, World world) {
        this.position = position;
        this.world = world;
    };

    public Organism() {
    }

    //public Organism(){};

    public abstract Position getLastPosition();

    public Organism(Organism organism){
        this.power = power;
        this.initiative = organism.initiative;
        this.position=new Position(organism.position);
        this.world = organism.world;
        this.life = organism.life;
        this.powerToReproduce = organism.powerToReproduce;
        this.sign = organism.sign;

    }
    public abstract Organism clone();


    public abstract ArrayList<Action> reproduce();
    public abstract ArrayList<Action> move();

    public ArrayList<Action> consequences(Organism enemy) {
        ArrayList<Action> result = new ArrayList<Action>();
        if (this.getPower() > enemy.getPower()) {
            result.add(new Action(ActionEnum.A_REMOVE, new Position(-1, -1), 0, enemy));
        } else {
            result.add(new Action(ActionEnum.A_REMOVE, new Position(-1, -1), 0, this));
        }
        return result;
    }


    public int ifReproduce(){
        int result = 0;
        if (this.power >= this.powerToReproduce){
            result = 1;
        }
        return result;
    }


    public abstract void initParams();

    @Override
    public String toString() {
        return this.getClass().getName() +
                ": power: " + power + " " +
                " initiative: " + initiative + " " +
                " position: " + position;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getPowerToReproduce() {
        return powerToReproduce;
    }

    public void setPowerToReproduce(int powerToReproduce) {
        this.powerToReproduce = powerToReproduce;
    }

    public char getSign() {
        return sign;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }
}