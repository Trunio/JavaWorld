public class Wolf extends Animal{

    public Wolf (Position position, World world){
        super();
        this.power = 6;
        this.powerToReproduce=12;
        this.life=15;
        this.position=position;
        this.sign='W';
        this.world = world;
    }

    public Wolf (World world){
        super();
        this.power = 6;
        this.powerToReproduce=12;
        this.life=15;
        this.sign='W';
        this.world = world;
    }

    @Override
    public Animal clone() {
        return new Wolf(this);
    }

    public Wolf(Wolf wolf){
        super(wolf);
    }

    @Override
    public void initParams() {
        this.setPower(6);
        this.setLife(15);
        this.sign='W';
        this.powerToReproduce=12;
        this.world = this.world;
    }


}


