public class Grass extends Plant {
    public Grass(Position position, World world) {
        this.power = 0;
        this.powerToReproduce = 5;
        this.life = 8;
        this.position = position;
        this.world = world;
        this.sign = '*';
    }

    public Grass(World world) {
        this.power = 0;
        this.powerToReproduce = 5;
        this.life = 8;
        this.world = world;
        this.sign = '*';
    }

    public Grass(Grass grass) {
        super(grass);
    }

    public void initParams() {
        this.setPower(0);
        this.setLife(8);
        this.sign = '*';
        this.powerToReproduce = 5;
        this.world = this.world;
    }

    public Grass clone() {
        return new Grass(this);
    }
}
