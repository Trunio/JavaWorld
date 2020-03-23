public class Dandelion extends Plant {

    public Dandelion(Position position, World world) {
        this.power = 0;
        this.powerToReproduce = 5;
        this.life = 6;
        this.position = position;
        this.world = world;
        this.sign = '✿';
    }

    public Dandelion(World world) {
        this.power = 0;
        this.powerToReproduce = 5;
        this.life = 6;
        this.world = world;
        this.sign = '✿';
    }

    public Dandelion(Dandelion dandelion) {
        super(dandelion);
    }

    public void initParams() {
        this.setPower(0);
        this.setLife(6);
        this.sign = '✿';
        this.powerToReproduce = 5;
        this.world = this.world;
    }

    public Dandelion clone() {
        return new Dandelion(this);
    }
}
