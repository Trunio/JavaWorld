
public class Action {

    private  ActionEnum action;
    private  Position position;
    private  int value;
    private Organism organism;

    public Action(ActionEnum action, Position position, int value, Organism organism) {
        this.action = action;
        this.position = position;
        this.value = value;
        this.organism = organism;
    }

    @Override
    public String toString() {
        switch(action){
            case A_ADD:
                return organism.getClass().getName() + ": add at: " + this.position;
            case A_INCREASEPOWER:
                return organism.getClass().getName() + ": increase power: " + this.value;
            case A_MOVE:
                return organism.getClass().getName() + ": move from: " + organism.getLastPosition() + " to: " +this.position;
            case A_REMOVE:
                return organism.getClass().getName() + ": remove from: " + this.position;
            case A_EXCTINCTIONCONTROL:
                return organism.getClass().getName() + " Extinction! New add at: " + this.position;
            default:
                return null;
        }
    }

    public ActionEnum getAction() {
        return action;
    }

    public void setAction(ActionEnum action) {
        this.action = action;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getValue() {
        return value;
    }

    public Organism getOrganism() {
        return organism;
    }

    public void setOrganism(Organism organism) {
        this.organism = organism;
    }
}