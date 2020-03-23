import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World implements Subject {
    private ArrayList<Class>  spiecies;
    private ArrayList<Observer> observers;
    private ArrayList<Organism> organisms;
    private ArrayList<Organism> neworganisms;
    private int turn=0;
    private int WorldX;
    private int WorldY;
//inicjalizacja
    public World(int X, int Y,int turn) {
        this.WorldX = X;
        this.WorldY = Y;
        this.organisms = new ArrayList<>();
        this.neworganisms = new ArrayList<>();
        this.turn=turn;
        this.observers = new ArrayList<>();
        this.spiecies = new ArrayList<>();
    }
    //dodaj do organizmow

    public void addOrganisms(Organism organism){
        this.organisms.add(organism);
       // ArrayList<Organism> pomorganisms = getOrganisms();
       // ArrayList<String> pomstring = new ArrayList<>();
        if(!this.spiecies.contains(organism.getClass())){
            this.spiecies.add(organism.getClass());
        }

    }

    //dodaj do nowych
    //czy pole jest na swiecie
    public boolean inWorld(Position position){
        return position.getX() >= 0 && position.getY() >= 0 && position.getX() <= this.getWorldX() && position.getY() <= this.getWorldY();
    };


//wolne pola
    public ArrayList<Position> FreePosition(){
        ArrayList<Position> freespace= new ArrayList<>();
        for(int x=0; x<=WorldX;x++){
            for(int y=0; y<=WorldY;y++){
                if(getOrganismFromPositionNew(new Position(x,y))==null){
                    freespace.add(new Position(x,y));
                }
            }
        }
        return freespace;
    }

    //pozycje wolne dookola danej pozycji
    public ArrayList<Position> filterFreePosition(Position position){
        ArrayList<Position> neighbours = new ArrayList<>();
        for(int x=position.getX()-1; x<=position.getX()+1;x++){
            for(int y=position.getY()-1; y<=position.getY()+1;y++){
                if(getOrganismFromPositionNew(new Position(x,y))==null && getOrganismFromPosition(new Position(x,y))==null  && inWorld(new Position(x,y))&&!new Position(x, y).equals(position)){
                    neighbours.add(new Position(x,y));
                }
            }
        }
     return neighbours;
    }
    //pozycje dookoła
    public ArrayList<Position> filterPosition(Position position){
        ArrayList<Position> neighbours = new ArrayList<>();
        for(int x=position.getX()-1; x<=position.getX()+1;x++){
            for(int y=position.getY()-1; y<=position.getY()+1;y++){
                if(inWorld(new Position(x,y))&& !new Position(x, y).equals(position)){
                    neighbours.add(new Position(x,y));
                }
            }
        }
        return neighbours;
    }
    public ArrayList<Position> filterPositionTwice(Position position){
        ArrayList<Position> neighbours = new ArrayList<>();
        for(int x=position.getX()-2; x<=position.getX()+2;x++){
            for(int y=position.getY()-2; y<=position.getY()+2;y++){
                if(inWorld(new Position(x,y))&& !new Position(x, y).equals(position)){
                    neighbours.add(new Position(x,y));
                }
            }
        }
        return neighbours;
    }

    public void makeMove(Action action) throws IOException {
        publish(action);
       // System.out.println(action);
        switch (action.getAction()) {
            case A_ADD:
                this.neworganisms.add(action.getOrganism());
                break;
            case A_INCREASEPOWER:
                action.getOrganism().setPower(action.getOrganism().getPower() + action.getValue());
                break;

            case A_MOVE:
                action.getOrganism().setPosition(action.getPosition());
                break;
            case A_REMOVE:
                action.getOrganism().setPosition(new Position(-1, -1));
                break;
            case A_EXCTINCTIONCONTROL:
                this.organisms.add(action.getOrganism());
                break;
        }
    }
    //tura swiata
    public void makeTurn() throws CloneNotSupportedException, IOException {
        organisms=getOrganisms();
        neworganisms = getNeworganisms();
        Position copyposition;
        ArrayList<Action> actions = new ArrayList<>();
        for (Organism d : organisms) {
            if(inWorld(d.getPosition())){
                actions = d.move();
                for (Action action : actions){
                    makeMove(action);
                }
                actions.clear();
            }
        }

        for (Organism d : organisms) {
            if(inWorld(d.getPosition())){
                actions = d.reproduce();
                for (Action action : actions){
                    makeMove(action);
                }
                actions.clear();
            }
        }
        for (Organism o : organisms){
            o.setLife(o.getLife()-1);
         //  actions.add(new Action(ActionEnum.A_INCREASEPOWER, o.getPosition(), 1, o));
            o.setPower(o.getPower()+1);
            if (o.getLife()<1){
                actions.add(new Action(ActionEnum.A_REMOVE, o.getPosition(), 0, o));
            }
        }
        for (Action action : actions){
            makeMove(action);
        }
        actions.clear();
        organisms.removeIf(org -> org.getPosition().getX() == -1 && org.getPosition().getY() == -1);
        organisms.addAll(neworganisms);
        neworganisms.clear();
        CheckExtinction();
        this.turn++;
    }

    //organizm z danej pozycji
    public Organism getOrganismFromPosition(Position position){
        organisms=getOrganisms();
        Organism pomOrganism = null;
        for (Organism d : organisms) {
            if (d.getPosition().equals(position)){
                pomOrganism=d;
                break;
            }
        }
        return pomOrganism;
    }
    public Organism getOrganismFromPositionNew(Position position){
        neworganisms=getNeworganisms();
        Organism pomOrganism = null;
        for (Organism d : neworganisms) {
            if (d.getPosition().equals(position)){
                pomOrganism=d;
                break;
            }
        }
        return pomOrganism;
    }

    public List<Class> getCurrentSpecies(){
        List<Organism> organizmy = new ArrayList<>();
        organizmy=getOrganisms();
        List<Class> pomarray = new ArrayList<>();
        for(Organism o : organizmy){
            if(!pomarray.contains(o.getClass()))
            pomarray.add(o.getClass());
        }
        return pomarray;
    }


    public void CheckExtinction() throws IOException {
        ArrayList<Action> result = new ArrayList<>();
        Random rand = new Random();
        OrganismFactory of = new OrganismFactory();
        List<Class> currentspecies = getCurrentSpecies();
        List<Class> ogspecies = (List<Class>) getSpiecies().clone();

        Organism organism;
        if(currentspecies.size()!=ogspecies.size()) {

            ogspecies.removeAll(currentspecies);

            for (Class klasa : ogspecies) {
                ArrayList<Position> freespace = this.FreePosition();
                int n = rand.nextInt(freespace.size());
                Position newPosition = freespace.get(n);
                organism = of.createOrganism(klasa.getName());
                organism.setPosition(newPosition);
                organism.initParams();
                organism.setWorld(this);
                makeMove(new Action(ActionEnum.A_EXCTINCTIONCONTROL, newPosition, 0, organism));
            }
        }

    }


//Gety i Setery
    public ArrayList<Organism> getOrganisms() {
        return organisms;
    }

    public ArrayList<Organism> getNeworganisms() {
        return neworganisms;
    }

    public int getWorldX() {
        return WorldX;
    }

    public int getWorldY() {
        return WorldY;
    }

    public int getTurn(){return turn;}

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void dettach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Action action) throws IOException {
        for(Observer o : observers){
            o.update(action);
        }
    }
    public void publish(Action action) throws IOException {
        notifyObservers(action);
    }

    public ArrayList<Class> getSpiecies() {
        return spiecies;
    }

}