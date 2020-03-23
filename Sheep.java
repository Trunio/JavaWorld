public class Sheep extends Animal{

    public Sheep (Position position, World world){
        super();
        this.power = 3;
        this.powerToReproduce=5;
        this.life=10;
        this.position=position;
        this.sign='S';
        this.world = world;
    }

    public Sheep (World world){
        super();
        this.power = 3;
        this.powerToReproduce=5;
        this.life=10;
        this.sign='S';
        this.world = world;
    }

    @Override
    public Animal clone() {
        return new Sheep(this);
    }

    public Sheep(Sheep sheep){
        super(sheep);
    }

    @Override
    public void initParams() {
        this.setPower(3);
        this.setLife(10);
        this.sign='S';
        this.powerToReproduce=5;
        this.world = world;
    }


}


